package com.robertrutherford.calculatorunlimited;

public class Calculations {
//    testing functions
    public static void main(String[] args) {

    }

    private String calculateFunction(String formula){

        if (!validFunction(formula).equalsIgnoreCase("true")){
            return validFunction(formula);
        }

        char[] divFormula;



        return "";
    }

    private String validFunction(String formula){

        if (!bracketLogic(formula)){
            return "Error: bracket conflict";
        }

        return "true";
    }

    private boolean bracketLogic(String xp) {
        char[] startBrackets = {'(', '[', '{', '<'};
        char[] endBrackets = {')', ']', '}', '>'};
        int priorityIndex = 0;
        char[] currentStack = new char[10];
        for (int i = 0; i < xp.length(); i++) {
//            open bracket case
            boolean contains = false;
            for (char c : startBrackets) {
                if (c == xp.charAt(i)) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                currentStack[priorityIndex] = xp.charAt(i);
                priorityIndex++;
            }

//            close bracket case
            for (char c : endBrackets) {
                if (c == xp.charAt(i)) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                if (priorityIndex == 0) {
                    return false;
                }
                if (xp.charAt(i) == ')') {
                    if (currentStack[priorityIndex - 1] != '(') {
                        return false;
                    } else {
                        priorityIndex--;
                    }
                }
                if (xp.charAt(i) == ']') {
                    if (currentStack[priorityIndex - 1] != '[') {
                        return false;
                    } else {
                        priorityIndex--;
                    }
                }
                if (xp.charAt(i) == '}') {
                    if (currentStack[priorityIndex - 1] != '{') {
                        return false;
                    } else {
                        priorityIndex--;
                    }
                }
                if (xp.charAt(i) == '>') {
                    if (currentStack[priorityIndex - 1] != '<') {
                        return false;
                    } else {
                        priorityIndex--;
                    }
                }
            }

        }
        return priorityIndex == 0;
    }

    private char[] seperateFormula(String formula){
        char[] splitFormula;




        return splitFormula;
    }


}
