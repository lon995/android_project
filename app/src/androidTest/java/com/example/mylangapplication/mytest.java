package com.example.mylangapplication;

import static org.junit.Assert.assertEquals;

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
