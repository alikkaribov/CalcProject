package com.test.calculator;
import com.test.calculator.language.Arabic;
import com.test.calculator.language.Roman;
import com.test.calculator.operation.Operation;

import java.util.Scanner;

public class Main {
    private static boolean arabic_numbers = true;

    private static String[] pars(String input) {
        String[] parser_input = input.split(" ");
        if (parser_input.length != 3) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Неверный формат ввода данных. Введите выражение, разделяя каждый символ пробелом.");
            input = sc.nextLine();
            return pars(input);
        } else {
            return parser_input;
        }

    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input: ");
        String input = sc.nextLine();
        Operation numbers;

        String[] parser_input = Main.pars(input);
        String operation = parser_input[1];
        int number1 = 0;
        int number2 = 0;

        try {
            number1 = Integer.parseInt(parser_input[0]);
            number2 = Integer.parseInt(parser_input[2]);
        } catch (NumberFormatException e) {
            arabic_numbers = false;
        }

        if (arabic_numbers) {
            if ((number1 < 1 || number1 > 10) || (number2 < 1 || number2 > 10)) {
                throw new Exception();
            }
            numbers = new Arabic(number1, number2);
        } else {

            numbers = new Roman(parser_input[0], parser_input[2]);
            if (((Roman) numbers).getRomanNumber1ToInt() < 1 || ((Roman) numbers).getRomanNumber2ToInt() > 10) {
                throw new Exception();
            } else if (((Roman) numbers).getRomanNumber1ToInt() < 1 || ((Roman) numbers).getRomanNumber1ToInt() > 10) {
                throw new Exception();
            }
             if ((((Roman) numbers).getRomanNumber1ToInt() - ((Roman) numbers).getRomanNumber2ToInt()) < 0 || ((((Roman) numbers).getRomanNumber1ToInt() / ((Roman) numbers).getRomanNumber2ToInt()) < 0)) {
                    throw new Exception("//т.к. в римской системе нет отрицательных чисел | невозможен вывод нуля ");
                 }
        }

        if (operation.equals("+")) {
            numbers.sum();
        } else if (operation.equals("-")) {
            numbers.sub();
        } else if (operation.equals("/")) {
            numbers.div();
        } else if (operation.equals("*")) {
            numbers.mul();
        }
        System.out.println();
        if (arabic_numbers) {
            System.out.println("Output: " + "\n" + numbers.getResult());
        } else {
            System.out.println("Output: " + "\n" + numbers.getStringResult());
        }
    }
}
