import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.util.Objects;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, minusButton, multiplyButton, divisionButton;
    JButton decimalButton, equalsButton, deleteButton, clearButton, negButton;
    JPanel panel;

    Font myFont = new Font("Dialog Input", Font.TRUETYPE_FONT, 28);
    double num1 = 0;
    double num2 = 0;
    double result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(420, 550);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(new Color(0x2C3033));
        textfield.setForeground(Color.white);
        textfield.setHorizontalAlignment(SwingConstants.RIGHT);
        textfield.setBorder(null);

        addButton = new JButton("+");
        minusButton = new JButton("-");
        multiplyButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalsButton = new JButton("=");
        deleteButton = new JButton("DEL");
        clearButton = new JButton("AC");
        negButton = new JButton("NEG");

        functionButtons[0] = addButton;
        functionButtons[1] = minusButton;
        functionButtons[2] = multiplyButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalsButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(new Color(0x202125));
            functionButtons[i].setForeground(new Color(0x90B3ED));
            functionButtons[i].setBorderPainted(false);
        }

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(new Color(0x202125));
            numberButtons[i].setForeground(new Color(0xE5E6EA));
            numberButtons[i].setBorderPainted(false);
        }

        negButton.setBounds(50, 400, 100, 50);
        deleteButton.setBounds(150, 400, 100, 50);
        clearButton.setBounds(250, 400, 100, 50);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(new Color(0x202125));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(minusButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalsButton);
        panel.add(divisionButton);

        frame.getContentPane().setBackground(new Color(0x202125));
        frame.add(panel);
        frame.add(negButton);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(textfield);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decimalButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
        }
        if (e.getSource() == minusButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
        }
        if (e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
        }
        if (e.getSource() == divisionButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
        }
        if (e.getSource() == equalsButton) {
            num2 = Double.parseDouble(textfield.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1 = result;
            if (result < 0) {
                textfield.setBackground(new Color(224, 16, 16));
            } else {
                textfield.setBackground(new Color(30, 155, 31));
            }
        }
        if (e.getSource() == clearButton) {
            textfield.setText("");
        }
        if (e.getSource() == deleteButton) {
            String string = textfield.getText();
            textfield.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        if (e.getSource() == negButton) {
            String string = textfield.getText();
            if (!string.isEmpty()) {
                double number = Double.parseDouble(string);
                number = -number;
                textfield.setText(Double.toString(number));
            }
        }
    }
}
