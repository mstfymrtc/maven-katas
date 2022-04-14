# Maven Kata
**Note** This exercise is based on [Kuba Marchwicki's work](https://github.com/kubamarchwicki/maven-kata). All credits to him 

## Project structure

Project is build from three independent modules:

calculator-api:: provides a basic API for calculation
calculator-test:: verification code for the calculator

**NOTE from Codurance**: We don't encourage separation of testing codebase from the actual production code. The separation shown here is just for illustrative purposes

The assignment is to implement the calculator in a few, maven related steps (a little Java code with a lot of maven based steps).

## Pre requisites
Have maven installed locally at least, since some steps will be required before enabling the wrapper

## Exercises

### Clone the project

[CHANGE ME!!!!!!]
Clone the project into the local workspace `git clone https://github.com/kubamarchwicki/maven-kata.git`

### Install locally

Install the `calculator-api` project locally by going inside the `calculator-api` folder and then execute
```bash
mvnw clean install
```

### Create new project
Assuming you're still under the the `calculator-api` folder, we will create a new project based on `maven-archetype-quickstart`

```bash
mvnw archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart -DoutputDirectory=../
```

Use the following parameters:
```
groupId: com.example.maven
artifactId: calculator
version: 1.0-SNAPSHOT
```

### Enable maven wrapper
Go to the newly generated `calculator` module and run

```bash
mvn -N wrapper:wrapper -Dmaven=3.2.3
```

This project can be easily imported to any IDE. In Eclipse just choose _Import_... > _Maven projects_ and choose _Existing Maven project_

### Adjust new project

In the generated project adjust the following:

* set java `source` and `target` runtime to Java 7.0
* change the default `junit` to latest available version (4.11 as of writing this document)
* add `calculator-api` as a dependency in the generated project

.dependencies
```xml
<dependency>
  <groupId>com.example.maven</groupId>
  <artifactId>calculator-api</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

.java source
```xml
<plugin>
  <groupId>org.apache.maven.plugins</groupId>
  <artifactId>maven-compiler-plugin</artifactId>
  <version>3.1</version>
  <configuration>
    <source>1.8</source>
    <target>1.8</target>
  </configuration>
</plugin>
```

Java version can be set as `properties` as well

.properties
```xml
<properties>
  <maven.compiler.source>1.8</maven.compiler.source>
  <maven.compiler.target>1.8</maven.compiler.target>
</properties>
```

### Implement the calculator

And don't forget the tests!

Run the project with `mvnw clean package`

### Test the reference

Check with the reference `calculator-test` project if everything works fine.

First build the project with skipping tests: `-DskipTest=true`

Depending which calculator you've implemented test it with run a desired test. For `Double` calculator run

```bash
mvnw test -Dtest=DoubleCalculatorTest
```
