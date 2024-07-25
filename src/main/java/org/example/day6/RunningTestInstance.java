package org.example.day6;

import java.beans.BeanProperty;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation(name="Bob",value="123")
public class RunningTestInstance {
    private String val;

    public RunningTestInstance(){
        this.val = "12345";
    }

    public void method(){
        System.out.println("here is method");
    }
    public void method1(int n){
        System.out.println("here is method1"+n);
    }
    private void method2(){
        System.out.println("here is private method");
    }
    @BeanProperty
    public void method3(){
        System.out.println("here is method with annotation");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation{
    public String name();
    public String value();

}