package com.example.maven.calculator;
import static org.junit.Assert.*;

import java.lang.reflect.ParameterizedType;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;
import org.reflections.Reflections;

public class IntegerCalculatorTest {

    private static Calculator<Integer> calculator;

    @BeforeClass
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void setup() throws IllegalAccessException, InstantiationException {
        Reflections reflections = new Reflections("com.example.maven.calculator");        
		Set<Class<? extends Calculator>> subTypesOf = reflections.getSubTypesOf(Calculator.class);
        for (Class<? extends Calculator> c: subTypesOf) {        	      
        	Class<?> genericType = (Class<?>) ((ParameterizedType) c.getGenericInterfaces()[0]).getActualTypeArguments()[0];
        	System.out.println(genericType.getCanonicalName());
        	if (genericType.getCanonicalName().equals(Integer.class.getCanonicalName())) {
        		calculator = (Calculator<Integer>) c.newInstance();
        		return;
        	}
        }
        fail("No suitable class found");
    }

    @Test
    public void shouldAddTwoDoubleNumbers() {
        assertEquals(Integer.valueOf("5"),
                calculator.sum(Integer.valueOf("2"), Integer.valueOf("3")));
    }
    
    @Test
    public void shouldSubtractTwoDoubleNumbers() {
        assertEquals(Integer.valueOf("-1"),
                calculator.difference(Integer.valueOf("2"), Integer.valueOf("3")));
    }

    
    @Test
    public void shouldMultiplyTwoDoubleNumbers() {
        assertEquals(Integer.valueOf("6"),
                calculator.product(Integer.valueOf("2"), Integer.valueOf("3")));
    }
    
    @Test
    public void shouldDivideTwoDoubleNumbers() {
        assertEquals(Double.valueOf("0.666"),
                calculator.quotient(Integer.valueOf("2"), Integer.valueOf("3")), 0.001d);
    }

}
