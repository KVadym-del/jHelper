package interfaces;

import javax.swing.*;

public interface WindowInterface {
    void createButton(String Name);
    void createButton(String Name, int X, int Y, int Width, int Height);
    void createLabel(String Name);
    void createLabel(String Name, int X, int Y, int Width, int Height);
    void createTextBox(String Name);
    void createTextBox(String Name, int X, int Y, int Width, int Height);
    void onClickButtonEvent(String ButtonName, ButtonClickInterface buttonClickInterface);


    void newLine();

    <T> T getComponent(String Name, Class<T> type);

    void setVisibility();

    @FunctionalInterface
    interface ButtonClickInterface {
        void event();
    }
}
