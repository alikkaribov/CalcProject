package com.test.calculator.language;
import com.test.calculator.operation.Operation;
public class Roman extends Operation{
    private String romanNumber1;
    private String romanNumber2;
    int romanNumber1ToInt;
    int romanNumber2ToInt;
    private int intResult;
    private String StringResult;

    public Roman(String number1, String number2) {
        this.romanNumber1 = number1;
        this.romanNumber2 = number2;
        this.romanNumber1ToInt = convert_to_int(romanNumber1);
        this.romanNumber2ToInt = convert_to_int(romanNumber2);
    }

    private String convert_result_to_Romans(int intResult) {
        String str = "";
        if (intResult < 0){
            str="-";
            intResult *= -1;
        }
        while (intResult >= 100) {
            str += "C";
            intResult -= 100;
        }
        while (intResult >= 50) {
            str += "L";
            intResult -= 50;
        }
        while (intResult >= 10) {
            str += "X";
            intResult -= 10;
        }
        while (intResult >= 9) {
            str += "IX";
            intResult -= 9;
        }
        while (intResult >= 5) {
            str += "V";
            intResult -= 5;
        }
        while (intResult >= 4) {
            str += "IV";
            intResult -= 4;
        }
        while (intResult >= 1) {
            str += "I";
            intResult -= 1;
        }
        return str;
    }

    @Override
    public void sum() {
        intResult = romanNumber1ToInt + romanNumber2ToInt;
        StringResult = convert_result_to_Romans(intResult);
    }

    @Override
    public void sub() {
        intResult = romanNumber1ToInt - romanNumber2ToInt;
        StringResult = convert_result_to_Romans(intResult);
    }

    @Override
    public void mul() {
        intResult = romanNumber1ToInt * romanNumber2ToInt;
        StringResult = convert_result_to_Romans(intResult);
    }

    @Override
    public void div() {
        try {
            intResult = romanNumber1ToInt / romanNumber2ToInt;
            StringResult = convert_result_to_Romans(intResult);
        } catch (Exception e) {
            System.out.println("Проверьте правильность ввода римских цифр. Вероятно введены и арабские и римские одновременно.");
        }
    }

    @Override
    public int getResult() {
        return intResult;
    }

    @Override
    public String getStringResult() {
        return StringResult;
    }

    private int convert_to_int(String romanNumber) {
        char[] charArr = romanNumber.toCharArray();
        int[] intArr = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            switch (charArr[i]) {
                case 'I':
                    intArr[i] = 1;
                    break;
                case 'V':
                    intArr[i] = 5;
                    break;
                case 'X':
                    intArr[i] = 10;
                    break;

                default:
                    System.out.println("Содержится неверный символ.");
                    break;
            }
        }
        int result = intArr[0];
        for (int i = 0; i < intArr.length && intArr.length > i + 1; i++) {
            if (intArr[i] >= intArr[i+1]) {
                result += intArr[i+1];
            } else if (intArr[i] < intArr[i+1]) {
                result = result + intArr[i+1] - 2;
            }
        }
        return result;
    }

    public String getRomanNumber1() {
        return romanNumber1;
    }

    public String getRomanNumber2() {
        return romanNumber2;
    }

    public void setRomanNumber1(String romanNumber1) {
        this.romanNumber1 = romanNumber1;
    }

    public void setRomanNumber2(String romanNumber2) {
        this.romanNumber2 = romanNumber2;
    }

    public int getRomanNumber1ToInt() {
        return romanNumber1ToInt;
    }

    public int getRomanNumber2ToInt() {
        return romanNumber2ToInt;
    }

    public void setRomanNumber1ToInt(int romanNumber1ToInt) {
        this.romanNumber1ToInt = romanNumber1ToInt;
    }

    public void setRomanNumber2ToInt(int romanNumber2ToInt) {
        this.romanNumber2ToInt = romanNumber2ToInt;
    }
}