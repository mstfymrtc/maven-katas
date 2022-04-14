package com.example.maven.calculator;

public interface Calculator<T extends Number> {

    public T sum(T summand1, T summand2);
    public T difference(T minuend, T subtrahend);
    public T product(T multiplicand1, T multiplicand2);
    public Double quotient(T dividend, T divisor);

}
