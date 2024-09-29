package com.ups.operexp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class InterpreterUI {
    private JFrame frame;
    private JTextField inputField;
    private JTextArea outputArea;

    public InterpreterUI() {
        frame = new JFrame("Interpreter Pattern Example");
        inputField = new JTextField(20);
        outputArea = new JTextArea(5, 30);
        outputArea.setEditable(false);

        JButton interpretButton = new JButton("Interpretar");

        interpretButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interpretInput();
            }
        });

        JPanel panel = new JPanel();
        panel.add(new JLabel("Ingrese la operación en letras:"));
        panel.add(inputField);
        panel.add(interpretButton);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(new JScrollPane(outputArea));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    private void interpretInput() {
        String val = inputField.getText();
        String[] tree = val.split(" ");
        Context context = new Context();
        List<IExpression> expressions = new ArrayList<>();

        IExpression exp;
        for (String t : tree) {
            if (context.getInteger(t) >= 0) {
                exp = new NumericExpression(t);
            } else {
                exp = new OperatorExpression(t);
            }
            exp.interpret(context);
        }

        outputArea.setText("El resultado para '" + val + "' es " + context.getResult());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InterpreterUI::new);
    }
}