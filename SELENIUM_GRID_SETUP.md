# Selenium Grid — Setup & Run Guide

Selenium Grid lets you run the SAME automation suite on multiple machines / browsers in parallel through one central **Hub**. The Hub receives test requests from your code and dispatches them to registered **Nodes** (workers).

This project supports Grid through a single config flag: `grid.enabled=true` in `src/main/resources/config.properties`.

---

## 1. Download Selenium Server

You need the standalone server jar (it acts as Hub, Node, or both).

1. Open: https://www.selenium.dev/downloads/
2. Under "Selenium Server (Grid)" download the latest version, for example: `selenium-server-4.21.0.jar`
3. Save it anywhere — e.g. `C:\selenium\` (Windows) or `~/selenium/` (Mac/Linux).

> Required: Java 11 or newer. Check with `java -version`.

---

## 2. Three ways to run the Grid

Pick ONE depending on what you need.

### Option A — Standalone (Hub + Node in one process). EASIEST.

Use this when you just want to try the Grid on a single machine.

```bash
java -jar selenium-server-4.21.0.jar standalone
```

You should see:
```
Started Selenium Standalone 4.21.0 ... http://192.168.x.x:4444
```

The Grid URL becomes: `http://localhost:4444`

### Option B — Hub and Node separately (recommended for the project)

Open **two terminal windows**.

Terminal 1 — start the Hub:
```bash
java -jar selenium-server-4.21.0.jar hub
```

Terminal 2 — start a Node and register it to the Hub:
```bash
java -jar selenium-server-4.21.0.jar node --hub http://localhost:4444
```

The Hub URL is still: `http://localhost:4444`

### Option C — Hub + multiple Nodes (full distributed Grid)

On Machine A (Hub):
```bash
java -jar selenium-server-4.21.0.jar hub
```

On Machine B (Node) — replace `HUB_IP` with Machine A's IP:
```bash
java -jar selenium-server-4.21.0.jar node --hub http://HUB_IP:4444
```

You can repeat the Node command on Machine C, D, etc.

---

## 3. Verify the Grid is running

Open in your browser:
```
http://localhost:4444
```

You will see the Selenium Grid dashboard showing the registered nodes and the available browser slots (Chrome / Firefox / Edge).

---

## 4. Switch the project to Grid mode

Edit `src/main/resources/config.properties`:

```properties
grid.enabled=true
grid.url=http://localhost:4444
browser=chrome
```

That's it — `DriverFactory.java` already detects this flag and uses `RemoteWebDriver` automatically.

---

## 5. Run the tests against the Grid

From the project root:

```bash
mvn clean test
```

You will see in the console:
```
Running on Selenium Grid: http://localhost:4444 (browser=chrome)
```

And on the Grid dashboard (`http://localhost:4444`) you will see a live "session" appear for each test method.

---

## 6. Run on a remote machine

If the Hub is on another computer (or a server), set:
```properties
grid.url=http://<HUB_MACHINE_IP>:4444
```
For example: `grid.url=http://192.168.1.50:4444`

---

## 7. Switch back to local mode

Just set:
```properties
grid.enabled=false
```
No code changes needed.

---

## Troubleshooting

| Problem | Likely fix |
|---|---|
| Browser doesn't open on the Hub | Make sure a Node is connected (check `http://localhost:4444`) |
| `org.openqa.selenium.SessionNotCreatedException` | Chrome version on the Node doesn't match the driver — update Chrome on the Node machine |
| `Connection refused` | The Hub is not running, OR the URL/port in config.properties is wrong |
| tests run locally instead of on Grid | Confirm `grid.enabled=true` and re-build with `mvn clean test` |
| Multiple tests run in serial, not parallel | Add `parallel="methods"` to `testng.xml` `<suite>` tag |

---

## Bonus — Run tests in parallel on the Grid

Update `testng.xml`:

```xml
<suite name="DEPI Automation Suite" parallel="classes" thread-count="3">
    ...
</suite>
```

`parallel="classes"` → all 5 test classes run at the same time on different Grid sessions.
`thread-count="3"` → maximum 3 browsers open at once.

---

## Cheat sheet

```bash
# Start Hub + Node together (easiest)
java -jar selenium-server-4.21.0.jar standalone

# Stop the Grid
# (just press CTRL + C in the terminal that started it)

# Check Grid status
curl http://localhost:4444/status
```
