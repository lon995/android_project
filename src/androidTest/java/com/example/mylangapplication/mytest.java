package com.example.mylangapplication;

import static org.junit.Assert.assertEquals;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class mytest{



    public void test(){
        //arrange
        String name ="test123";
        String password = "123";
        boolean result ;

        LoginActivity myTest = new LoginActivity();

        //act
        result = myTest.login(name, password );

        //assert
        assertEquals(true, result);

    }

}
