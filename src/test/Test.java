package test;

import static javax.swing.JOptionPane.showMessageDialog;

import main.Window;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        Window window = new Window();

        window.createButton("My button1");
        window.createButton("My button1");
        window.createLabel("Hello");
        window.createTextField("My text Box");


        window.setVisibility();

        window.onClickButtonEvent("My button1", () -> {
            showMessageDialog(null, "Hello world!1");
        });

        window.onClickButtonEvent("My button2", () -> {
            window.getComponent("Hello", JLabel.class).setText(window.getComponent("My text Box", JTextField.class).getText());
        });
    }
}
