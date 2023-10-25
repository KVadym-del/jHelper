package Test;

import Main.Window;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        Window window = new Window();

        window.createButton("My button1");
        window.createLabel("My Label");
        window.createTextField("My text Box");
        window.createCheckBox("My check box");

        window.setVisibility();


        window.onClickButtonEvent("My button1", () -> {
            if (window.getComponent("My check box", JCheckBox.class).isSelected())
                window.getComponent("My Label", JLabel.class).setText(window.getComponent("My text Box", JTextField.class).getText());
        });
    }
}
