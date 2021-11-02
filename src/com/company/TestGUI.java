package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGUI extends JFrame {
    private JButton button = new JButton("Нажми");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Введите текст:");
    private JRadioButton radio1 = new JRadioButton("Выбрать это");
    private JRadioButton radio2 = new JRadioButton("Выбрать то");
    private JCheckBox check = new JCheckBox("Отметить", false);

    public TestGUI() {
        super("Наша форма");
        this.setBounds(100, 100, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Кнопка нажата\n";
            message += "Текст: " + input.getText() + "\n";
            message += (radio1.isSelected() ? "Точка №1" : "Точка №2") + " выбрана!\n";
            message += "Чекбокс " + ((check.isSelected())? "отмечен": "не отмечен");
            JOptionPane.showMessageDialog(null, message,"Результат",JOptionPane.PLAIN_MESSAGE);

        }
    }
}
