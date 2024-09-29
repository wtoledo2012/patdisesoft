package com.ups.operexp;

public class Context {
    private String nextOp = "";
    private int operator = 0;
    private int result = 0;

    public int getInteger(String input) {
        switch (input.toLowerCase()) {
            case "cero": return 0;
            case "uno": return 1;
            case "dos": return 2;
            case "tres": return 3;
            case "cuatro": return 4;
            case "cinco": return 5;
            case "seis": return 6;
            case "siete": return 7;
            case "ocho": return 8;
            case "nueve": return 9;
            default: return -1;
        }
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public void setOperation(String operation) {
        if (operation.toLowerCase().equals("mas")) {
            nextOp = "+";
        } else if (operation.toLowerCase().equals("menos")) {
            nextOp = "-";
        }
    }

    public void calculate() {
        if (nextOp.equals("+") || nextOp.equals("")) {
            result += operator;
        } else if (nextOp.equals("-")) {
            result -= operator;
        }
    }

    public int getResult() {
        return result;
    }
}
