package UI;

import Logica.Pila;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceadaGUI {
    private JPanel BalanceadaGUI;
    private JTextField textField1;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton pushButton;
    private JButton balanceadaButton;
    private JButton restartButton;
    private Pila pila = new Pila();
    private Pila pila2 = new Pila();
    private char[] charBalance;

    public BalanceadaGUI() {
        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                charBalance = textField1.getText().toCharArray();
                for (int i = charBalance.length - 1; i >= 0; i--) {

                    if(charBalance[i] == ']' || charBalance[i] == '[' || charBalance[i] == '{' || charBalance[i] == '}' || charBalance[i] == '(' || charBalance[i] == ')') {

                        pila.push(charBalance[i], textArea1);
                    }
                }
                textField1.setText("");
            }
        });

        balanceadaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean isBalanced;

                pila.revertStack(pila2, textArea1, textArea2);
                isBalanced = pila.isBalanced(pila2);

                if(isBalanced) {

                    JOptionPane.showMessageDialog(BalanceadaGUI, "Balanceada");
                }else{

                    JOptionPane.showMessageDialog(BalanceadaGUI, "No Balanceada");
                }
            }
        });
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pila = new Pila();
                pila2 = new Pila();
                textArea1.setText("");
                textArea2.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BalanceadaGUI");
        frame.setContentPane(new BalanceadaGUI().BalanceadaGUI);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
