package com.example.mylangapplication;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test


    public void test(){
        //arrange
        String name ="test123";
        String password = "123";
        boolean result ;

        LoginActivity myTest = new LoginActivity();

        //act
        result = myTest.login(name, password );

        //assert
        assertFalse(result);

    }
}