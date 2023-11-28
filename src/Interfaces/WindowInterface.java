package Interfaces;

public interface WindowInterface {
    void createButton(String Name);
    void createButton(String Name, int X, int Y, int Width, int Height);

    void createLabel(String Name);
    void createLabel(String Name, int X, int Y, int Width, int Height);

    void createTextField(String Name);
    void createTextField(String Name, int X, int Y, int Width, int Height);

    void createCheckBox(String Name);


    void createPanel(String Name, int X, int Y);

    void onClickButtonEvent(String ButtonName, ButtonClickInterface buttonClickInterface);

    void addComponentToPanel(String PanelName, String ComponentName);

    void newLine();

    <T> T getComponent(String Name, Class<T> type);

    void setVisibility(Boolean Visibility);
    void setVisibility(String Name, Boolean Visibility);

    void nameCheck(String name, CopyVerifyInterface copyVerifyInterface);

    @FunctionalInterface
    interface ButtonClickInterface {
        void event();
    }
    @FunctionalInterface
    interface CopyVerifyInterface {
        void event(String name);
    }
}
