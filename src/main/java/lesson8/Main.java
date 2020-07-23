package lesson8;

/*
* Создайте оконное приложение с кнопкой. По нажатию кнопки приложение должно закрываться
* */


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JLabel label = new JLabel("Для ВЫХОДА нажмите ВЫХОД");
        JFrameClass jframeClass = new JFrameClass();
        JPanel panel = new JPanel();
        jframeClass.add(panel);
        panel.setLayout(new SpringLayout());
        label.setPreferredSize(new Dimension(464, 165));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        panel.add(label);
        jframeClass.setAlwaysOnTop(true);
        jframeClass.setResizable(false);
    }

}
