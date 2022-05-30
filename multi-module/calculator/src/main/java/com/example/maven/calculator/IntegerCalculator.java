package com.example.maven.calculator;

public class IntegerCalculator implements Calculator<Integer> {


    @Override
    public Integer sum(Integer aInteger, Integer t1) {
        return aInteger + t1;
    }

    @Override
    public Integer difference(Integer aInteger, Integer t1) {
        return aInteger - t1;
    }

    @Override
    public Integer product(Integer aInteger, Integer t1) {
        return aInteger * t1;
    }

    @Override
    public Integer quotient(Integer aInteger, Integer t1) {
        return aInteger / t1;
    }
}
