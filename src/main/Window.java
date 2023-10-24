package main;

import interfaces.WindowInterface;

import javax.swing.*;
import javax.swing.border.LineBorder;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Map;
import java.util.HashMap;

public class Window implements WindowInterface {
    public Window()
    {
        frame = new JFrame("main.Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(600, 400));

        components = new HashMap<String, JComponent>();
    }
    public Window(int Width, int Height)
    {
        frame = new JFrame("main.Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Width, Height);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(600, 400));

        components = new HashMap<String, JComponent>();
    }
    @Override
    public void createButton(String Name)
    {
        nameCheck(Name, (String name) -> {
            JButton button = new JButton(Name);
            button.setBounds(futureComponentX, futureComponentY, 120, 50);
            if ((futureComponentX + 160) >= frame.getSize().width) {
                futureComponentY += (50 + 10);
                futureComponentX = 30;
            } else {
                futureComponentX += 160;
            }
            button.setVisible(false);

            frame.add(button);

            components.put(Name, button);
        });
    }

    @Override
    public void createButton(String Name, int X, int Y, int Width, int Height)
    {
        nameCheck(Name, (String name) -> {
            JButton button = new JButton(Name);
            button.setBounds(X, Y, Width, Height);
            button.setVisible(false);

            frame.add(button);

            components.put(Name, button);
        });
    }

    @Override
    public void createLabel(String Name)
    {
        nameCheck(Name, (String name) -> {
            JLabel label = new JLabel(Name);
            label.setBounds(futureComponentX, futureComponentY, 100, 50);
            if ((futureComponentX + 140) >= frame.getSize().width) {
                futureComponentY += (50 + 10);
                futureComponentX = 30;
            } else {
                futureComponentX += 140;
            }
            label.setVisible(false);

            frame.add(label);

            components.put(Name, label);
        });
    }

    @Override
    public void createLabel(String Name, int X, int Y, int Width, int Height) {
        nameCheck(Name, (String name) -> {
            JLabel label = new JLabel(Name);
            label.setBounds(X, Y, Width, Height);
            label.setVisible(false);

            frame.add(label);

            components.put(Name, label);
        });
    }

    @Override
    public void createTextBox(String Name)
    {
        nameCheck(Name, (String name) -> {
            JTextField textField = new JTextField(Name);
            textField.setBounds(futureComponentX, futureComponentY, 200, 150);
            if ((futureComponentX + 240) >= frame.getSize().width) {
                futureComponentY += (150 + 10);
                futureComponentX = 30;
            } else {
                futureComponentX += 240;
            }
            textField.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    textField.setText("");
                }

                public void focusLost(FocusEvent e) {
                    // nothing
                }
            });
            textField.setBorder(new LineBorder(Color.BLACK, 1));
            textField.setVisible(false);

            frame.add(textField);

            components.put(Name, textField);
        });
    }

    @Override
    public void createTextBox(String Name, int X, int Y, int Width, int Height) {
        nameCheck(Name, (String name) -> {
            JTextField textField = new JTextField(Name);
            textField.setBounds(X, Y, Width, Height);
            textField.addFocusListener(new FocusListener() {
                public void focusGained(FocusEvent e) {
                    textField.setText("");
                }

                public void focusLost(FocusEvent e) {
                    // nothing
                }
            });
            textField.setBorder(new LineBorder(Color.BLACK, 1));
            textField.setVisible(false);

            frame.add(textField);

            components.put(Name, textField);
        });
    }

    @Override
    public void onClickButtonEvent(String ButtonName, WindowInterface.ButtonClickInterface buttonClickInterface)
    {
        getComponent(ButtonName, JButton.class).addActionListener(e -> buttonClickInterface.event());
    }

    @Override @Deprecated
    public void newLine()
    { //TODO: implement dynamic layout
        futureComponentY += 10;
        futureComponentX = 30;
    }

    @Override
    public <T> T getComponent(String Name, Class<T> type) {
        if (components.get(Name) != null)
            return type.cast(components.get(Name));
        else {
            frame.setVisible(false);
            JOptionPane.showMessageDialog(new JFrame(), "Component with this name (" + Name + ") is not a JComponent or does not exist", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            frame.dispose();
        }
        return null;
    }

    @Override
    public void setVisibility()
    {
        for (Map.Entry<String, JComponent> entry : components.entrySet()) {
            entry.getValue().setVisible(true);
        }
    }

    @Override
    public void nameCheck(String name, CopyVerifyInterface copyVerifyInterface) {
        if (components.computeIfPresent(name, (k, v) -> v) != null) {
            frame.setVisible(false);
            JOptionPane.showMessageDialog(new JFrame(), "Component with this name already exists", "Dialog",
                    JOptionPane.ERROR_MESSAGE);
            frame.dispose();
        } else {
            copyVerifyInterface.event(name);
        }
    }


    private final JFrame frame;
    private static Map<String, JComponent> components;

    private int futureComponentX = 30;
    private int futureComponentY = 30;
    private final int lastHighestInARow = 0;
}
