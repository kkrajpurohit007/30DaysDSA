# 30-Day DSA Roadmap (Java)

This repository contains a 30-day DSA practice scaffolding in Java.

Overview
- Each day has a placeholder class `org.finora.dsa.day.DayNN` (NN = 01..30).
- `org.finora.dsa.DsaRunner` dispatches and runs a specific day or all days.

Run
- Build: `mvn -q compile`
- Run a specific day: `java -cp target/classes org.finora.dsa.DsaRunner 01`
- Run all days: `java -cp target/classes org.finora.dsa.DsaRunner all`

Folder layout
- `src/main/java/org/finora/dsa/DsaRunner.java` - runner
- `src/main/java/org/finora/dsa/day/DayNN.java` - day placeholders

Day template
- Each DayNN has a `main(String[] args)` and a `run()` convenience method. Replace placeholders with problem solutions.

Contributing
- Add implementations under the `day` package. Keep the `DayNN` classes small and focused.

License
- Personal/learning project.

