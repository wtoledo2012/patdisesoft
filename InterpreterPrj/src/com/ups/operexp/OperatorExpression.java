package com.ups.operexp;

public class OperatorExpression implements IExpression {
    private String operation;

    public OperatorExpression(String operation) {
        this.operation = operation;
    }

    @Override
    public void interpret(Context context) {
        context.setOperation(operation);
    }
}
