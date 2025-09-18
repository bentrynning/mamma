# Mamma Spring Annotation

`mamma` is a small Maven package that contributes a reusable Spring annotation,
`@Mamma`, and the supporting aspect that prints your mama's name whenever an
annotated method runs.

## Building and installing the package

```
mvn clean install
```

The command installs the library in your local Maven repository so other
projects can declare a dependency on it.

## Using the annotation in Spring Boot

Add the dependency to your application's `pom.xml`:

```xml
<dependency>
    <groupId>com.example</groupId>
    <artifactId>mamma</artifactId>
    <version>0.1.0</version>
</dependency>
```

`MammaAutoConfiguration` is published as a Spring Boot auto-configuration, so as
soon as the dependency and the `spring-boot-starter-aop` starter are on the
classpath the aspect is activated automatically.

```java
@Service
class GreetingService {

    @Mamma("Gloria")
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
```

Each invocation of `greet` prints `greet's mama is Gloria!` to the console.

## Using the annotation with the classic Spring container

Import the provided `@EnableMamma` on a configuration class to register the
aspect:

```java
@Configuration
@EnableMamma
class AppConfig {
}
```

Once enabled you can annotate any Spring bean method with `@Mamma` and the
aspect will shout out the configured mama name.

## Running tests

```
mvn test
```
