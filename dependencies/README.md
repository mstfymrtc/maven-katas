# Dependencies Kata

In this exercise, the main idea is to be able to manage dependencies on a given maven project.
This a regular scenario for new team members joining a project, in which they may need to add or modify dependencies

This exercise is composed by the following steps

* Run and install the given project
* Update one of the dependencies
* Update the artifact version
* Add a new dependency

## Run and install the project
For this step, you're already given a project under the `dependencies-example` folder, which contains a `pom.xml` file

Simply run
`./mvnw clean install` (or `mvnw.cmd` if you're on Windows) and verify that the project is correctly built

## Update one of the dependencies
If you go and look at the test code under `src/test/java/com/codurance/maven/AppTest.java` you'll see it uses a very old JUnit implementation
Now if you take a look at the `pom.xml` file, you'll see as well the only dependency is currently `junit` with version `3.8.1` 

We're now gonna make a breaking change, replacing the current dependency with the following values

* `groupId` to `org.junit.jupiter` 
* `artifactId` to `junit-jupiter` 
* `version` to `5.8.2`

This should also break your testing class