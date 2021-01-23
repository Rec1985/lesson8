import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator");
        setBounds(1200,50,500,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        inputField.setEditable(false); // запрещаем ввод.
        top.add(inputField,BorderLayout.CENTER);



        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(5,3));

        add(top,BorderLayout.NORTH);
        add(bottom, BorderLayout.CENTER);

        DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);


        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(digitButtonListener);
            bottom.add(button);

        }

        JButton add = new JButton("+");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton button = (JButton) e.getSource();

                StringBuilder sb = new StringBuilder(inputField.getText());
                sb.append(button.getText());

                inputField.setText(sb.toString());
            }
        });
        bottom.add(add);

        JButton minus = new JButton("-");
        bottom.add(minus);

        JButton sqrt = new JButton("SQRT");
        bottom.add(sqrt);

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inputField.setText("");
            }
        });
        bottom.add(clear);

        JButton calc = new JButton("=");
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] values = inputField.getText().split("\\+");
                int sum = Integer.parseInt(values[0]) + Integer.parseInt(values[1]);
                inputField.setText(String.valueOf(sum));
            }
        });
        bottom.add(calc);


        setVisible(true);


    }
}

//Калькулятор
//        1. Доделать кнопку "С" - очищение строки
//        2. Доделать кнопку "Submit", она же равно "=". По нажатию кнопки должно выполняться вычисление выражения.
//        3. Реализовать вычисление выражения только для операций сложения и вычитания
//        4. ** Попробовать применить ScriptEngine для вычисления математических выражений. ВАЖНО! Для корректного запуска использовать Java 11-13.
//        5. ** На основании задания №4, расширить добавить к списку операций умножение и деление