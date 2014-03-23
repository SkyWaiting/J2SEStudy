package com.example.security.classloader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * User: guorui
 * Date: 14-1-9
 * Time: 下午10:04
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        JFrame frame = new ClassLoaderFrame();
    }

}

/**
 * This frame contains two text fields for the name of the class
 * to load and the decryption key.
 */
class ClassLoaderFrame extends JFrame{
    private JTextField keyField = new JTextField("3",4);
    private JTextField nameField = new JTextField(30);
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ClassLoaderFrame(){
        setTitle("ClassLoaderTest");
        setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
        setLayout(new GridBagLayout());

    }
}
