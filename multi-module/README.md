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

## Going multi module
Now that we've implemented the production code, you may have noticed how weird it was going back and forth between projects
So here comes a Parent POM to rescue

### Parent project generation
Go back to the one of the project folder (for instance `calculator`) and run the following command

```bash
./mvnw -B archetype:generate -DgroupId=com.example.maven -DartifactId=multi-module -DarchetypeArtifactId=pom-root -DarchetypeGroupId=org.codehaus.mojo.archetypes -DoutputDirectory=../../

```

Now go back to the `multi-module` folder and you'll see a `pom.xml` file
Enable the wrapper by running

```bash
mvn -N wrapper:wrapper -Dmaven=3.2.3
```

### Create relationship

Open the `pom.xml` file and add the following after the `<name>multi-module</name>` tag

```xml
<modules>
    <module>calculator-api</module>
    <module>calculator</module>
    <module>calculator-test</module>
</modules>
```

And in each of the project's pom files add the following

```xml
<parent>
  <artifactId>multi-module</artifactId>
  <groupId>com.example.maven</groupId>
  <version>1.0-SNAPSHOT</version>
</parent>
```

Now, your parent pom controls the other artifacts as submodules, and each submodule is declared to extend from the given parent


### Building from the parent pom
Now, you should be able to run
```bash
./mvnw clean package 
```
from the parent pom (`multi-module` folder)