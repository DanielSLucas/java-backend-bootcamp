# Maven
## A typical Java project needs

- organizing source coda
- organizing tests
- JARs to add to the class path
- commands to run to start locally
- commands to test
- commands to deploy

All of those problems can be solved by Maven.

## What is Maven?

- build automation tool
- dependency management tool
- project management tool

## Project management with Maven

Maven provides a consistent project model

- metadata about the project
- helps start developing
- helps test
- helps build and deploy

## Convention over configuration

Maven has an opinion about how a java project should be, so you dont have
to worry about it or do any extra configurarion (as long you stick to the default).

## The Project Object Model

`pom.xlm` where you can specify things on you java project.

- project metadata
- declarative format


## my notes

- A maven project is characterized by the presence of the pom.xml file in the project root.
- `groupId`, `artifactId` and `version` is what are called Project coordinates. 
  -> When a project version is finished it will generate an artifact, that is unique and differentiable by these pieces of information.
- When a maven project is compiled (you can use `mvn compile` for that), the compiled files go to the `target` folder.
- You can run the test files under the folder `test` using the commmand `mvn test`
- You can generate a jar file with the command `mvn install`
  -> When you do this, maven also pushes this jar file to the **local maven repository** in your machine, allowing you to import those jar files from any other maven project in your machine.
- Clean the targe folder `mvn clean`
- To add dependecies to you maven project, add the dependencies key in the `pom.yml` file
then add the depency `groupId`, `artifactId` and `version`. And refresh the classpath.
The dependencies will be fetched from the **local or central maven repository**.
- Dependencies can have a scope, to indicate when these are needed. Like, test libraries
are only usefull when running tests, but not in the runtime. So you can use the key
`<scope>test</scope>` with the dependency in `pom.yml` file to indicate it.
Scopes: compile, provided, runtime, system, test.
- Maven uses versioning is really similar to semantic versioning.
- In Maven, goals represents specific actions that can be performed on a project.
([more about maven goals](https://koushikkothagal.github.io/java-backend-bootcamp/docs/java-backend-bootcamp/maven/maven-goals))