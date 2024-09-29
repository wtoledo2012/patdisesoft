package com.ups.operexp;

public class OperatorExpression implements IExpression {
    private String operation;

    public OperatorExpression(String token) {
        this.operation = token;
    }

    @Override
    public void interpret(Context context) {
        context.setOperation(operation);
    }
}