package com.ups.operexp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        String[] tree;
        Context context = new Context();
        List<IExpression> expressions = new ArrayList<>();
        System.out.println("Ingrese la operación en letras: ");
        
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        tree = val.split(" ");
        
        IExpression exp;
        for (String t : tree) {
            if (context.getInteger(t) >= 0) {
                exp = new NumericExpression(t);
            } else {
                exp = new OperatorExpression(t);
            }
            exp.interpret(context);
        }

        System.out.println("El resultado para '" + val + "' es " + context.getResult());
        scanner.close();
    }
}