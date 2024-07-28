package org.example.day8;

public class Day8Note {
    /*
    1. types of DI
        - constructor based DI, recommend, make the unit test easier, inject mock easily
        - setter based DI: flexible, partially injection
        - field based DI: most convenient, prevent cycle dependency issue, not safe

    2. Application


        Bean Scope
        Singleton(default)
        Prototype
        Request(request done, bean destroyed)
        Session
        application
        Bean lifecycle


        @PostConstruct
        Mark a method that should be automatically called after dependency injection is complete for any initialization. This annotation is typically used to perform some action before the bean is fully ready for use.
        @PreDestroy
        Marks a method that should be called to perform cleanup before the bean is destroyed. This annotation is usually used to perform some resource release operations before the end of the bean life cycle.

        Public void customInit(){

        }
        AOP

        Aspect =>  @Aspect
        Modularization of a concern that cuts across multiple classes.
        Use case: Logging, Security, Transaction Management
        Advice
        Action taken by an aspect at a particular join point.
        Use case: Before, After, Around, After Returning, After Throwing
        Joinpoint => Joinpoint
        Specific point in the execution of a program where an aspect can be applied.
        Use case: Method execution, Object creation
        Pointcut
        The predicate that matches join points.
        Use case: Define where advice is applied
        Target
        Object being advised by one or more aspects.
        Use case: The actual object whose method is intercepted

        @Aspect
        @Component
        public class LoggingAspect {
            @Pointcut("execution(* com.example.service.*.*(..))")
            public void serviceLayer() {}

            @Before("serviceLayer()")
            public void logBeforeMethodExecution() {
                System.out.println("Method execution log");
            }
        }


        Aspect: The LoggingAspect class is an aspect.
        Notification: The logBeforeMethodExecution method is a notification that records logs before the method is executed.
        Connection point: When all methods under the com.example.service package are executed.
        Pointcut point: execution(* com.example.service.*.*(..)) is a pointcut expression.
        Target objects: all classes under the com.example.service package.

        AOP -> Dynamic Proxy -> Reflection

     */
}
