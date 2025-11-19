package org.testng;

import org.testng.annotations.*;

public class TrainingTest {

    static long start;

    @BeforeClass (groups="default")
    public static void browserLaunch(){
        System.out.println("browserlaunch");
    }

    @AfterClass (groups = "default")
    public static void browserQuit(){
        System.out.println("browserQuit");
    }

    @BeforeMethod (groups = "default")
    public void startTime(){
        start=System.currentTimeMillis();
        System.out.println("before method");
    }

    @AfterMethod (groups = "default")
    public void endTime(){
        long end = System.currentTimeMillis();
        System.out.println("Running time" +(end-start));
    }

    @Test (priority = 4, invocationCount = 2,groups = "default")
    public void login(){
        System.out.println("Login");
    }

    @Test (priority = 3 ,enabled = false,groups = "default")
    public void search(){
        System.out.println("Search");
    }

    @Test (priority = 2, invocationCount = 4,groups = "default")
    public void click(){
        System.out.println("Click");
    }
    @Test(priority=1,invocationCount = 2,groups = "default")
    public void addTOCart(){
        System.out.println("Add To Cart");
    }

}
