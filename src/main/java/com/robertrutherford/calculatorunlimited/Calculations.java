package com.robertrutherford.calculatorunlimited;

public class Calculations {
//    testing functions
    public static void main(String[] args) {

    }

    private String calculateFunction(String formula){

        if (!validFunction(formula).equalsIgnoreCase("true")){
            return validFunction(formula);
        }



        return "";
    }

    private String validFunction(String formula){

        return "true";
    }




}
