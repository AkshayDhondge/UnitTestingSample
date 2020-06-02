package com.example.unittestingsample

import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MyTest {

    private val mainActivity = MainActivity()
    @Test
    fun testsWork() {
        assertTrue(true)
    }

    @Test
    fun testAdditionFunction(){
        val sum = mainActivity.doAddition(10,30)
        assertEquals(sum,40)
    }

    @Test
    fun testEmptyLoginCredentials(){
        val result = mainActivity.loginValidations("","")
        assertEquals(result,false)
    }

    @Test
    fun testEmptyLoginEmail(){
        val result = mainActivity.loginValidations("","12345")
        assertEquals(result,false)
    }

    @Test
    fun testEmptyLoginPassword(){
        val result = mainActivity.loginValidations("abc@gmail.com","")
        assertEquals(result,false)
    }

    @Test
    fun testValidLoginCredentials(){
        val result = mainActivity.loginValidations("abc@gmail.com","12345")
        assertEquals(result,true)
    }

    @Test
    fun testEmptyEmail(){
        val result = mainActivity.isEmailValid("")
        assertEquals(result,false)
    }

    @Test
    fun testInValidEmail(){
        val result = mainActivity.isEmailValid("aaaaaaa")
        assertEquals(result,false)
    }

    @Test
    fun testValidEmail(){
        val result = mainActivity.isEmailValid("aaaaaaa@gmail.com")
        assertEquals(result,true)

    }
}