package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameClass extends JFrame{
    public JFrameClass(){
        setTitle("Какое-то Окно");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 240);
        JPanel grid = new JPanel(new GridLayout(1, 2, 5, 0));
        JButton jButtonExit1Left = new JButton("Выход");

        grid.add(jButtonExit1Left);
        jButtonExit1Left.setContentAreaFilled(false);
        jButtonExit1Left.setFocusPainted(false);
        jButtonExit1Left.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jButtonExit1Left.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                dispose();
                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                System.out.println("THE END");
            }
        });

        JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        flow.add(grid);
        Container container = getContentPane();
        // Размещение панели с кнопкой внизу справа
        container.add(flow, BorderLayout.SOUTH);
        setVisible(true);

    }
}
