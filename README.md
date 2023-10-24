# jHelper
It's a java Class/Interface project what supposed to help in using **Swing** java framework. 

# How to use 
First step to use this project, is to install it on your machin, after which you can import it to your own project.

Second stap is to create an object of class **Window**:
```java
Window window = new Window();
```

or

```java
Window window = new Window(windowSize...);
```

Third step to add to the window some components like: Button, Label, TextField ... for example:
```java
 window.createButton(someName);
```

or

```java
 window.createButton(someName, position, size);
```

the last step is to show the components on window, to do it you need to use:
```java
window.setVisibility();
```

# How to add an event after clicking a button
To do it what you need to do is just call the function **onClickButtonEvent** and put there as arguments a name of component(Button) and an event using lambda expression

# How to get the component object
To do this, you just need to call the **getComponent** function and add the name of the component(Button) and the class of the component from the swing library as arguments, for example:
```java
window.getComponent("My Label", JLabel.class).setText("My new Label");
```
