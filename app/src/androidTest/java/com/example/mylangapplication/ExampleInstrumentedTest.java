package com.example.mylangapplication;

import android.content.ContentValues;
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

    // Create method
        User myTest = new User();
        // get user
        User a=new User();


        //check user is not empty?
        assertEquals(false,myTest.getUserValues(a).isEmpty());

    }
}