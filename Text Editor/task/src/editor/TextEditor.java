package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class TextEditor extends JFrame {
    private JTextArea textArea;
    private JTextField area;

    public TextEditor() {
        super("Text editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        Dimension d = new Dimension(150, 30);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.setName("MenuFile");
        JMenuItem loadMenuItem = new JMenuItem("Load");
        loadMenuItem.setName("MenuLoad");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        saveMenuItem.setName("MenuSave");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setName("MenuExit");

        saveMenuItem.addActionListener(actionEvent -> {
            save();
        });

        loadMenuItem.addActionListener(actionEvent -> {
            load();
        });

        exitMenuItem.addActionListener(actionEvent -> {
            System.exit(0);
        });

        fileMenu.add(loadMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

        JPanel panel = new JPanel();
        add(panel, BorderLayout.PAGE_START);

        area = new JTextField();
        area.setName("FilenameField");
        area.setMinimumSize(d);
        area.setMaximumSize(d);
        area.setPreferredSize(d);
        panel.add(area);

        JButton saveButton = new JButton();
        saveButton.setText("Save");
        saveButton.setName("SaveButton");
        saveButton.setMinimumSize(d);
        saveButton.setMaximumSize(d);
        saveButton.setPreferredSize(d);
        panel.add(saveButton);

        JButton loadButton = new JButton();
        loadButton.setText("Load");
        loadButton.setName("LoadButton");
        loadButton.setMinimumSize(d);
        loadButton.setMaximumSize(d);
        loadButton.setPreferredSize(d);
        panel.add(loadButton);

        textArea = new JTextArea();
        textArea.setName("TextArea");

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setName("ScrollPane");
        d = new Dimension(250, 200);
        scrollPane.setMinimumSize(d);
        scrollPane.setMaximumSize(d);
        scrollPane.setPreferredSize(d);
        add(scrollPane, BorderLayout.CENTER);

        loadButton.addActionListener(actionEvent -> {
            load();
        });

       saveButton.addActionListener(actionEvent -> {
           save();
       });
       setVisible(true);
    }

    public void load() {
        String path = "C:/Users/Javan/IdeaProjects/Text Editor/Text Editor/task/src/" + area.getText();
        try {
            String text = new String(Files.readAllBytes(Paths.get(path)));
            textArea.setText(null);
            textArea.setText(text);
        } catch (Exception ex) {
            System.out.println(ex);
            textArea.setText(null);
        }
    }

    public void save(){
        String path = "C:/Users/Javan/IdeaProjects/Text Editor/Text Editor/task/src/" + area.getText();
        File file = new File(path);
        try (PrintWriter writer = new PrintWriter(file)){
            String text = textArea.getText();
            writer.print(text);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}
