# pluralsight-spring-aop

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
  * After returning
  * After throwing
  * After 
  * Around
* Spring AOP is proxy based
  * Auto-proxying: if Spring determines that a bean is advised by one or more aspects, it automatically generates a proxy for that bean to intercept method invocations and ensures that advice is run as needed.
* A schema based AOP configuration
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
    * ref has the value of the logginAspect bean defined before
    * pointcut is defined using id and expression
    * before and after reference pointcut

* with Java @Configuration, add the @EnableAspectJAutoProxy annotation to enable @AspectJ support
