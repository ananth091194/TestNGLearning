package org.testng;

import org.testng.annotations.Test;

public class MainTest {

    @Test
    public void testMethod(){
        System.out.println("in main test file");
    }

    @Test
    public void firstMethod(){
        System.out.println("first test method");
    }
}
