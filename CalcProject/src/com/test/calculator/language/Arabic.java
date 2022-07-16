package com.test.calculator.language;
import com.test.calculator.operation.Operation;

public class Arabic extends Operation{
    private int number1;
    private int number2;
    private int result;

    public Arabic(int number1, int number2){
        this.number1 = number1;
        this.number2 = number2;
    }
    @Override
    public void sum() {
        this.result = number1 + number2;
    }
    @Override
    public void sub() {
        this.result = number1 - number2;
    }
    @Override
    public void mul() {
        this.result = number1 * number2;
    }
    @Override
    public void div() {
        this.result = number1 / number2;
    }
    @Override
    public int getResult() {
        return result;
    }
    @Override
    public String getStringResult() {
        return "" + result;
    }
}