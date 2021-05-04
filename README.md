# pluralsight-spring-aop

Basic concepts:
https://www.dineshonjava.com/spring-aop-interview-questions-and-answers/

### Module 1
* Cross cutting concerns
  * Logging
  * Caching
  * Exception handling
  * User rights check
  * Transactions
  * Performancing monitoring
* AOP solves the follwing problems
  * code tangling
  * code scattering

### Module 2
* Create a Maven Java Project
```
mvn archetype:generate 
    -DgroupId={project-packaging}
    -DartifactId={project-name}
    -DarchetypeArtifactId=maven-archetype-quickstart
    -DinteractiveMode=false
```
* Create a simple Maven Project
```
mvn -X archetype:generate -DgroupId=com.pluralsight.aop -DartifactId=example -DarchetypeArtifactId=maven-archetype-simple -DarchetypeVersion=1.4 -DinteractiveMode=false
```
* * Two types of Spring AOP support
  * schema-based
  * @AspectJ annotation
* Spring AOP Concepts
  * Aspect: A modularization of a concern that cuts across multiple classes. They are regular classes
  * Joint point: A point during the execution of a program, such as the execution of a method or the handling of an exception. In Spring AOP, a join point always represents a method execution.
  * Advice: Action taken by an aspect at a particular join point. Different types of advice include “around”, “before” and “after” advice.
  * Pointcut: A predicate that matches join points. Advice is associated with a pointcut expression and runs at any join point matched by the pointcut (for example, the execution of a method with a certain name).
  * Introduction: Declaring additional methods or fields on behalf of a type
  * Target object: An object being advised by one or more aspects
  * AOP proxy: An object created by the AOP framework in order to implement the aspect contracts (advise method executions and so on). In the Spring Framework, an AOP proxy is a JDK dynamic proxy or a CGLIB proxy
  * Weaving: linking aspects with other application types or objects to create an advised object

* Spring AOP advice types
  * Before
  * After returning: method returns normally
  * After throwing: method exist by throwing an exception
  * After: method exit (finally)
  * Around
* Spring AOP is proxy based
  * Auto-proxying: if Spring determines that a bean is advised by one or more aspects, it automatically generates a proxy for that bean to intercept method invocations and ensures that advice is run as needed.
* A schema based AOP configuration
  * ref has the value of the logginAspect bean defined before
  * pointcut is defined using id and expression
  * before and after reference pointcut
```
 <bean id="loggingAspect" class="com.pluralsight.springaop.example1.LoggingAspect"/>


    <aop:config>
        <aop:aspect id="loggingAspect1" ref="loggingAspect">
            <aop:pointcut id="passengerMethod1"
                          expression="execution(* com.pluralsight.springaop.example1.*.*(..))"
                          />
            <aop:before pointcut-ref="passengerMethod1" method="before"/>
            <aop:after pointcut-ref="passengerMethod1" method="after"/>
        </aop:aspect>
    </aop:config>
 ```
   

* with Java @Configuration, add the @EnableAspectJAutoProxy annotation to enable @AspectJ support

### Module 3 AspectJ support
* Annotation support
  * Annotate @Aspect on the Aspect bean
  * Annotate @Before/@After("execution....") on the Aspect bean's method
  * Add <<aop:aspectj-autoproxy/> to the xml configuration / or using Java @Configuration
  * Declare the Aspect bean

* AspectJ dependency
```
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-aspects</artifactId>
			<version>5.3.6</version>
		</dependency>
```
### Module 4-7 @Around
* Creating Proxy Objects
  * If target class implements an interface, JDK dynamic proxy standard mechanism implements the interface
  * If target class does not implement an interface. CGLIB proxy mechanism extends the target class
  * CGLIB proxy does not work with a final target class
  * CGLIB proxy does not work with a final method in the target class
  * CGLIB proxy can work with public and protected method. It should always work with public method

### Module 8,9,10,11 Orghogonal Behavior
* Orthogonal Behavior: use annotation instead of AspectJ expression
* Use AOP to handle exception and logging

### Module 12
* Declaring pointcuts
  * a signature comprising a name and any parameters 
  * pointcut expression that determines exactly which method executions we are interested in
  * Example below: signature is allTaicketMethods. expression is @Pointcut(....)
```
@Pointcut("within(com.pluralsight.springaop.flightsmanagement.domain.Ticket)")
    public void allTicketMethods() {
    }
```
* Spring AOP supports the following pointcut designator (PCD): execution, within, this, target, args, @target, @args, @within, @annotation, bean(Sprint AOP only)
* execution PCD format: ret-type-pattern, name-pattern and param-pattern are mandatory
  * wild card * can be used in ret-type-pattern and name-pattern
  * param-pattern
    * (): method takes no parameters
    * (..): match any number(zero or more) parameters
    * (*): match one parameter of any type
```
execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
                throws-pattern?)
```

### Module 14 Spring Boot AOP Annotation only
* AppConfig class need have annotation @Config and @@EnableAspectJAutoProxy
* Each of the object class need be declared as a Bean using @Component
* Aspect class need be annotated as @Aspect and @Component
* Test class need @Autowired the bean to use them. Just use the new construction will not trigger Aspect
* If multiple instances of a bean is used.
  * the bean can be annoated by
  ```
    @Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
  ```
  * Application Context can be @Autowired
  ```
    @Autowired
	private ApplicationContext context;
  ```
  * Multiple bean instances can be retrieved by using the application context
  ```
     Passenger jim = context.getBean(Passenger.class);
  ```
