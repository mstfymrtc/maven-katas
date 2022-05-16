# Dependencies Kata

In this exercise, the main idea is to be able to manage dependencies on a given maven project. This a regular scenario for new team members joining a project, in which they may need to add or modify dependencies

This exercise is composed by the following steps

* Run and install the given project
* Update one of the dependencies
* Update the artifact version
* Add a new dependency

## Run and install the project

For this step, you're already given a project under the `dependencies-example` folder, which contains a `pom.xml` file

Simply run
```
./mvnw clean install
```
(or `mvnw.cmd` if you're on Windows) and verify that the project is correctly built

## Update one of the dependencies

If you go and look at the test code under `src/test/java/com/codurance/maven/AppTest.java` you'll see it uses a very old JUnit implementation
Now if you take a look at the `pom.xml` file, you'll see as well the only dependency is currently `junit` with version `3.8.1` 

We're now gonna make a breaking change, replacing the current dependency with the following values

* `groupId` to `org.junit.jupiter` 
* `artifactId` to `junit-jupiter` 
* `version` to `5.8.2`

This should also break your testing class, so you'll have to look on the internet for a way to fix this

## Update artifact version

Right now we've only been building the artifact `dependencies-example` with version `1.0-SNAPSHOT` 
Let's move to version `2.0-SNAPSHOT` since the previous change was a breaking change

* Locate the `<version>` tag of your artifact
* Replace the version with `2.0-SNAPSHOT`
* Build again with `./mvnw clean install`

## Add a new dependency

Under certain scenarios, we might need to add dependencies to our project so it can have access to more libraries other teams or developers have built.
In our case, we want to give our project the ability to work with Apache Commons library, which provides several functionalities

First of all add the new dependency in the dependencies section by copying this snippet
```xml
    <dependency>
      <groupId>org.apache.commons</groupId>
      <artifactId>commons-lang3</artifactId>
      <version>3.12.0</version>
    </dependency>

```

Then, go to your `App.java` class and replace the `main` method with this

```java
    public static void main( String[] args )
    {
        String capitalize = StringUtils.capitalize("Hello World!");
        System.out.println(capitalize);
    }
```

And build with `./mvnw clean install`

Did you have any error? Fix the imports properly


## Implications and further discussion

Adding dependencies and relying on other's libraries is how the software industry, and specially, the open source movement, have achieve great success
Eventually you may want to handle dependencies on more concise and centralized way. That's where `dependencyManagement` comes to rescue.

Also, take into consideration the **scope** of your dependencies. In this exercise, you've seen the `test` scope and the `compile` scope
Scoping dependencies helps you separate your built artifact from libraries that were only used for verification purposes.
In bigger projects, you'll see this a lot.

