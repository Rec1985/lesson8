import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {
    public final JTextField textField;

    public DigitButtonListener(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        StringBuilder sb = new StringBuilder(textField.getText());
        sb.append(button.getText());

        textField.setText(sb.toString());
    }
}

//Калькулятор
//        1. Доделать кнопку "С" - очищение строки
//        2. Доделать кнопку "Submit", она же равно "=". По нажатию кнопки должно выполняться вычисление выражения.
//        3. Реализовать вычисление выражения только для операций сложения и вычитания
//        4. ** Попробовать применить ScriptEngine для вычисления математических выражений. ВАЖНО! Для корректного запуска использовать Java 11-13.
//        5. ** На основании задания №4, расширить добавить к списку операций умножение и деление