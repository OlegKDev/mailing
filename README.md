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