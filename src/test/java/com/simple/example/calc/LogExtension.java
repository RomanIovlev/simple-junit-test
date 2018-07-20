package com.simple.example.calc;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.ExtensionContext.*;

import java.lang.reflect.Method;

import static java.lang.String.format;

public class LogExtension implements BeforeTestExecutionCallback, AfterTestExecutionCallback
    // ADD BeforeStepExecutionCallback, AfterStepExecutionCallback
    // ADD BeforeAssertExecutionCallback, AfterAssertExecutionCallback
{

    private static final String START_TIME = "start time";
    // ADD
    /*
    @Override
    public void beforeStepExecution(StepContext step) {
        System.out.println("Step: " + step.name());
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }

    @Override
    public void afterStepExecution(StepContext step) {
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;

        System.out.println(format("Step %s END (%s ms.)", step.getName(), duration));
    }
    */
    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println("### TEST: " + context.getDisplayName() + " ###");
        getStore(context).put(START_TIME, System.currentTimeMillis());
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        Method testMethod = context.getRequiredTestMethod();
        long startTime = getStore(context).remove(START_TIME, long.class);
        long duration = System.currentTimeMillis() - startTime;

        System.out.println(format("Method [%s] took %s ms.", testMethod.getName(), duration));
    }

    private Store getStore(ExtensionContext context) {
        return context.getStore(Namespace.create(getClass(), context.getRequiredTestMethod()));
    }

}
