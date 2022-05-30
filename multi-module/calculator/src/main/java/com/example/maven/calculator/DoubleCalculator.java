package com.example.maven.calculator;

public class DoubleCalculator implements Calculator<Double> {

    @Override
    public Double sum(Double aDouble, Double t1) {
        return aDouble + t1;
    }

    @Override
    public Double difference(Double aDouble, Double t1) {
        return aDouble - t1;
    }

    @Override
    public Double product(Double aDouble, Double t1) {
        return aDouble * t1;
    }

    @Override
    public Double quotient(Double aDouble, Double t1) {
        return aDouble / t1;
    }
}
