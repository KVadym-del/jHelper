package test;

import static javax.swing.JOptionPane.showMessageDialog;

import main.Window;

public class Test {
    public static void main(String[] args) {
        Window window = new Window();

        window.createButton("My button1");
        window.createButton("My button2");


        window.setVisibility();

        window.onClickButtonEvent("My button", () -> {
            showMessageDialog(null, "Hello world!1");
        });

        window.onClickButtonEvent("My button2", () -> {
           showMessageDialog(null, "Hello world!2");
        });
    }
}