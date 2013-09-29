package chelintutorials;

import java.awt.Container;
import javax.swing.*;

public class MyFrame37 extends JFrame {

    public MyFrame37() {
        setTitle("Primera Ventana");
        setBounds(300, 100, 300, 100);
        Container contentpane = getContentPane();
        JLabel text1=new JLabel ("Hola Mundo");
        contentpane.add(text1);
    }
}
