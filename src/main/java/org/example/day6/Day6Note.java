package org.example.day6;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Day6Note {
    /*
    1. Design Pattern(23 design pattern)
        - Creational Pattern
            Singleton / Factory /Prototype Pattern
       `- Structural Pattern
            Decorator/ Static Proxy / Dynamic Proxy Pattern...
        - Behavioral Pattern
            Observer / Interpreter / Iterator Pattern

       Singleton Pattern: ONLY one object gets created
       usage case: hardware interface access, Logger, Configuration File
       1. Eager initialization
           class Singleton1{
                private static final Singleton1 instance = new Singleton1();

                private Singleton1(){}

                public static Singleton1 getInstance(){
                    return instance;
                }
            }

        2.Lazing initialization
            class Singleton2{
                private static Singleton2 singleton2;

                private Singleton2(){};

                public static Singleton2 getInstance(){
                    if(singleton2 == null){
                        singleton2 = new Singleton2();
                    }
                    return singleton2;
                }
            }
        3. Thread-safe Lazing initialization
            class Singleton3{
                private static Singleton3 singleton3;

                private Singleton3(){};

                public static synchronized Singleton3 getInstance(){
                    if(singleton3 == null){
                        singleton3 = new Singleton3();
                    }
                    return singleton3;
                }
            }
        4. Double-Checked Locking
            public class Singleton4 {
                private static volatile Singleton4 instance;

                private Singleton4() {}

                public static Singleton4 getInstance() {
                    if (instance == null) {
                        synchronized (Singleton4.class) {
                            if (instance == null) {
                                // 1. create instance reference
                                // 2. new singleton()
                                // 3. instance reference points to instant point
                                instance = new Singleton4();
                            }
                        }
                    }
                    return instance;
                }
            }

       Builder
            Department d = Department.builder().setName("Java").setManagerName("John doe").setId(1).setLocation("NY").build();

       Factory
            PhoneFactory factory = new PhoneFactory();
            Phone iphone = factory.getPhone("iphone");
            Phone sony = factory.getPhone("sony");

       Observe

     */

    /*
     2. reflection
        write code -> compile it -> run it(running)
     */


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        RunningTestInstance obj = new RunningTestInstance();
        Class cls = obj.getClass();

        System.out.println("The name of class is: " + cls.getName());

        Method[] method = cls.getDeclaredMethods();
        for(Method m:method){
            System.out.println(m.getName());
        }

        Method reflectMethod1 = cls.getDeclaredMethod("method1",int.class);
        reflectMethod1.invoke(obj,19);

        //get private method
        Method reflectMethod2 = cls.getDeclaredMethod("method2");
        //grant permission
        reflectMethod2.setAccessible(true);
        reflectMethod2.invoke(obj);

        // get annotation
        Class testClass = RunningTestInstance.class;
        Method reflectMethod3 = testClass.getDeclaredMethod("method3");
        Annotation[] classAnnotation = reflectMethod3.getAnnotations();
        for(Annotation annotation:classAnnotation){
            System.out.println(annotation);
        }


        // get class level annotation
        Annotation[] annotations = testClass.getAnnotations();
        for(Annotation annotation:annotations){
            System.out.println(annotation.annotationType());
            MyAnnotation myAnnotation = (MyAnnotation) annotation;
            System.out.println(myAnnotation.name());
            System.out.println(myAnnotation.value());
        }
    }
}

