package io.jasonlu.learning.springaop.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by jiehenglu on 17/08/02.
 */
@Aspect
@Component
public class MyAspect {

    @Pointcut("execution(* io.jasonlu.learning.springaop.service.MyService.hello())")
    public void helloPointcut() {}

    @Before("helloPointcut()")
    public void before() {
        System.out.println("=== before method execute ===");
    }

    @After("helloPointcut()")
    public void after() {
        System.out.println("=== after method execute ===");
    }

    @AfterReturning("helloPointcut()")
    public void afterReturning() {
        System.out.println("=== after method returning ===");
    }

    @Pointcut("execution(* io.jasonlu.learning.springaop.service.MyService.say(int)) && args(world)")
    public void sayPointcut(int world) {}

    @Before("sayPointcut(world)")
    public void beforeSay(int world) {
        System.out.println(String.format("=== before say %d ===", world));
    }
}
