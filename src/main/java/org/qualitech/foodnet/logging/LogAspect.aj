package org.qualitech.foodnet.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Aram on 2/11/2016.
 */
@Aspect
public aspect LogAspect {

    @Before("@annotation(org.qualitech.foodnet.logging.LogRequest)")
    public void myAdvice(){
        System.out.println("Executing myAdvice!!");
    }
}
