package com.austin.unittest.source.test;

import com.austin.unittest.source.MainClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainClassTest {

    private MainClass mainClass;
    @Before
    public void setUp() throws Exception {
        mainClass = new MainClass();

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testAdd() throws Exception {
        System.out.println(mainClass.add(3, 6));

    }

    @Test
    public void testDevide() throws Exception {

    }
}