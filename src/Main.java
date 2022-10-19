import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener{

    JFrame fr;
    JTextField text;
    JButton[] no_buttons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addBu, subBu, divBu, mulBu;
    JButton clearBu, delBut, decimalBUt, equalsBut, negaviveBUt;
    JPanel my_panel;

    Font my_font = new Font("Arial",Font.ITALIC,30);

    double number1=0,number2=0,result=0;
    char operators;
    Main(){
        fr = new JFrame("Java Calculator");
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setSize(420,550);
        fr.setLayout(null);

        text = new JTextField();
        text.setBounds(50,25,300,50);
        text.setFont(my_font);
        text.setEditable(false);

        addBu = new JButton("+");
        subBu = new JButton("-");
        mulBu = new JButton("X");
        divBu = new JButton("/");
        clearBu = new JButton("Cls");
        delBut = new JButton("DEL");
        decimalBUt = new JButton(".");
        equalsBut = new JButton("=");
        negaviveBUt = new JButton("(-)");

        functionButtons[0] = addBu;
        functionButtons[1] = subBu;
        functionButtons[2] = mulBu;
        functionButtons[3] = divBu;
        functionButtons[4] = decimalBUt;
        functionButtons[5] = equalsBut;
        functionButtons[6] = delBut;
        functionButtons[7] = clearBu;
        functionButtons[8] = negaviveBUt;


        for(int i =0;i<9;i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(my_font);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0;i<10;i++){
            no_buttons[i] = new JButton(String.valueOf(i));
            no_buttons[i].addActionListener(this);
            no_buttons[i].setFont(my_font);
            no_buttons[i].setFocusable(false);
        }

        negaviveBUt.setBounds(50,466,145,50);
        delBut.setBounds(50,410,145,50);
        clearBu.setBounds(205,430,145,50);

        my_panel = new JPanel();
        my_panel.setBounds(50,100,300,300);
        my_panel.setLayout(new GridLayout(4,4,10,10));
        my_panel.setBackground(Color.gray);

        my_panel.add(no_buttons[1]);
        my_panel.add(no_buttons[2]);
        my_panel.add(no_buttons[3]);
        my_panel.add(addBu);
        my_panel.add(no_buttons[4]);
        my_panel.add(no_buttons[5]);
        my_panel.add(no_buttons[6]);
        my_panel.add(subBu);
        my_panel.add(no_buttons[7]);
        my_panel.add(no_buttons[8]);
        my_panel.add(no_buttons[9]);
        my_panel.add(mulBu);
        my_panel.add(decimalBUt);
        fr.add(delBut);
        my_panel.add(no_buttons[0]);
        my_panel.add(equalsBut);
        my_panel.add(divBu);

        fr.add(my_panel);
        fr.add(negaviveBUt);
        fr.add(clearBu);
        fr.add(text);
        fr.setVisible(true);

    }
    public static void main(String[] args) {
        Main clc = new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i=0;i<10;i++){
            if (e.getSource() == no_buttons[i]){
                text.setText(text.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource()==decimalBUt){
            text.setText(text.getText().concat("."));
        }
        if (e.getSource()==addBu){
            number1 = Double.parseDouble(text.getText());
            operators = '+';
            text.setText("");
        }
        if (e.getSource()==subBu){
            number1 = Double.parseDouble(text.getText());
            operators = '-';
            text.setText("");
        }
        if (e.getSource()==mulBu){
            number1 = Double.parseDouble(text.getText());
            operators = 'X';
            text.setText("");
        }
        if (e.getSource()==divBu){
            number1 = Double.parseDouble(text.getText());
            operators = '/';
            text.setText("");
        }
        if (e.getSource()==equalsBut) {
            number2 = Double.parseDouble(text.getText());



            switch (operators){
                case '+':
                  result=number1+number2;
                  break;
                case '-':
                    result=number1-number2;
                    break;
                case 'X':
                    result=number1*number2;
                    break;
                case '/':
                    result=number1/number2;
                    break;
            }
            text.setText(String.valueOf(result));
            number1 = result;
        }
        if (e.getSource()==clearBu){
            text.setText("");
        }
        if (e.getSource()==delBut){
            String noname = text.getText();
            text.setText((""));
            for (int i = 0;i<noname.length()-1;i++){
                text.setText(text.getText()+noname.charAt(i));
            }
        }
        if(e.getSource()==negaviveBUt) {
            double a = Double.parseDouble(text.getText());
            a*=-1;
            text.setText(String.valueOf(a));
        }
    }
}