## Mailing Service

- Implemented multi-module project: “config” module to read configuration settings from XML file; “excel” module to read emails from Excel file, and write report data to Excel file; “message” module to create and send emails with attachments through Gmail API; “console” module to output messages to console while application is launching; “assembly” module with Main class that aggregates all functionality
- Implemented unit tests with JUnit

Install and run tests

```shell
cd path/to/mailing
mvn clean install
```

Compile, skip tests

```shell
mvn clean compile -DskipTests
```

Start application

```shell
mvn exec:java -pl assembly -Dexec.mainClass=org.software.mailing.assembly.Main
```