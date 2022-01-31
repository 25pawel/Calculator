import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class App implements ActionListener {

    JFrame frame;
    JTextField textFieldDown, textFieldUp;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("ink Free", Font.BOLD, 30);

    double number_1 = 0, number_2 = 0, result = 0;
    char operator;

    App() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 650);
        frame.setLayout(null);

        textFieldUp = new JTextField();
        textFieldUp.setBounds(50, 25, 300, 50);
        textFieldUp.setFont(myFont);
        textFieldUp.setEditable(false);

        textFieldDown = new JTextField();
        textFieldDown.setBounds(50, 125, 300, 50);
        textFieldDown.setFont(myFont);
        textFieldDown.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("<-");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }

        negButton.setBounds(50,530,80,50);
        delButton.setBounds(130,530,110,50);
        clrButton.setBounds(240,530,110,50);

        panel = new JPanel();
        panel.setBounds(50,200,300,300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(numberButtons[0]);
        panel.add(decButton);
        panel.add(equButton);
        panel.add(divButton);

        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textFieldUp);
        frame.add(textFieldDown);
        frame.setVisible(true);
    }
    public static void main(String[] args) {

        App Calculator = new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < 10; i++){
            if(e.getSource() == numberButtons[i]){
                textFieldDown.setText(textFieldDown.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == decButton && !textFieldDown.getText().contains(".")){
            textFieldDown.setText(textFieldDown.getText().concat("."));
        }
        if(e.getSource() == addButton){
            number_1 = Double.parseDouble(textFieldDown.getText());
            operator = '+';
            textFieldDown.setText("");
        }
        if(e.getSource() == subButton){
            number_1 = Double.parseDouble(textFieldDown.getText());
            operator = '-';
            textFieldDown.setText("");
        }
        if(e.getSource() == mulButton){
            number_1 = Double.parseDouble(textFieldDown.getText());
            operator = '*';
            textFieldDown.setText("");
        }
        if(e.getSource() == divButton){
            number_1 = Double.parseDouble(textFieldDown.getText());
            operator = '/';
            textFieldDown.setText("");
        }
        if(e.getSource() == equButton){
            number_2 = Double.parseDouble(textFieldDown.getText());
            switch(operator){
                case '+':
                    result = round(number_1 + number_2,5);
                    break;
                case '-':
                    result = round(number_1 - number_2, 5);
                    break;
                case '*':
                    result = round(number_1 * number_2, 5);
                    break;
                case '/':
                    result = round(number_1 / number_2, 5);
                    break;
            }
            String stringForUpTextField = String.valueOf(number_1) + operator + String.valueOf(number_2) + "=" +
                    String.valueOf(result);
            textFieldUp.setText(stringForUpTextField);
            textFieldDown.setText(String.valueOf(result));
            number_1 = result;
        }
        if(e.getSource() == clrButton){
            textFieldDown.setText("");
        }
        if(e.getSource() == delButton){
            String string = textFieldDown.getText();
            textFieldDown.setText("");
            for(int i = 0; i < string.length()-1; i++){
            textFieldDown.setText(textFieldDown.getText() + string.charAt(i));
            }
        }
        if(e.getSource() == negButton){
            double temp = Double.parseDouble(textFieldDown.getText());
            temp *= -1;
            textFieldDown.setText(String.valueOf(temp));
        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
