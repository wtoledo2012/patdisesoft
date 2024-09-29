package com.ups.operexp;

public class NumericExpression implements IExpression {
    private String value;

    public NumericExpression(String value) {
        this.value = value;
    }

    @Override
    public void interpret(Context context) {
        context.setOperator(context.getInteger(value));
        context.calculate();
    }
    
}
