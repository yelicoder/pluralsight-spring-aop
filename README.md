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
* An AOP xml configuration
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
      * ref has 
