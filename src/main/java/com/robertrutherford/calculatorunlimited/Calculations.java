package com.robertrutherford.calculatorunlimited;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculations {
    //    testing functions
    public static void main(String[] args) {
        System.out.println(Arrays.toString(seperateFormula("45+3.85")));
        System.out.println();
        System.out.println(Arrays.toString(seperateFormula("(45+3.85)/(23-1)")));
        System.out.println();
    }

    private String calculateFunction(String formula) {

        if (!validFunction(formula).equalsIgnoreCase("true")) {
            return validFunction(formula);
        }

        String[] divFormula = seperateFormula(formula);

//        find function order
//        seperate into sub formulas
//        calc sub problems
//        find total

//      return total;
        return "";
    }

    private String validFunction(String formula) {

        if (!bracketLogic(formula)) {
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

    private static String[] seperateFormula(String formula) {

        String number = "";
        int index = 0;
        String[] builderList = new String[formula.length()];
        boolean numberGroup = false;

        for (int i = 0; i < formula.length(); i++) {
            boolean numberDouble = Character.isDigit(formula.charAt(i)) || formula.charAt(i) == '.';
            if (numberDouble) {
                if (!numberGroup) {
                    numberGroup = true;
                }
                number = number + formula.charAt(i);
            } else {
//              for simple math systems no sin, cos, tan functions yet
                if (numberGroup) {
                    builderList[index] = number;
                    index++;
                    number = "";
                }
                number = number + formula.charAt(i);
                builderList[index] = number;
                index++;
                number = "";
                numberGroup = false;
            }
        }
        if (numberGroup) {
            builderList[index] = number;
        }

        List<String> listCleaner = new ArrayList<String>();
        for (String str : builderList) {
            if (str != null) {
                listCleaner.add(str);
            }
        }

//        String[] splitFormula = listCleaner.toArray(new String[listCleaner.size()]);

        return Arrays.stream(builderList)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
    }

}
