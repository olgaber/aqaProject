package com.provectus.tests;

import org.testng.annotations.Test;

public class TestEX {

    @Test
    public void testExample(){
        System.out.println("I'm TEST");

        System.out.println("Running test on " + System.getProperty("url"));
    }
}
