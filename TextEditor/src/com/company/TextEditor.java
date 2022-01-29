package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextEditor extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JScrollPane scrollPane;

    private JSpinner fontSpinner;
    private JLabel fontLabel;

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem load;
    private JMenuItem save;
    private JMenuItem exit;

    private final ImageIcon loadIcon = new ImageIcon("D:\\Personal\\CodingPractice\\JavaCodes\\TextEditor\\load.png");
    private final ImageIcon saveIcon = new ImageIcon("D:\\Personal\\CodingPractice\\JavaCodes\\TextEditor\\save.png");
    private final ImageIcon exitIcon = new ImageIcon("D:\\Personal\\CodingPractice\\JavaCodes\\TextEditor\\cross.png");

    JButton fontColorBtn;
    JComboBox fontsBox;

    TextEditor(){
        // Textarea
        textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Scroll pane

        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(750,750));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        // Spinner for font

        /* ********** Sets the range for spinner ********** */
        SpinnerModel range = new SpinnerNumberModel(20,1,1000,1);
        fontSpinner = new JSpinner(range);

        fontSpinner.setPreferredSize(new Dimension(50,25));
        fontSpinner.addChangeListener(e -> {
            textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontSpinner.getValue()));
        });

        // Font Label
        fontLabel = new JLabel("Font size : ");

        // Menu and menu bar
        load = new JMenuItem("Load");
        save = new JMenuItem("Save");
        exit = new JMenuItem("Exit");

        load.setIcon(loadIcon);
        save.setIcon(saveIcon);
        exit.setIcon(exitIcon);

        load.addActionListener(this);
        save.addActionListener(this);
        exit.addActionListener(this);

        fileMenu = new JMenu("File");
        fileMenu.add(load);
        fileMenu.add(save);
        fileMenu.add(exit);

        menuBar = new JMenuBar();
        menuBar.add(fileMenu);

        // Color Button

        fontColorBtn = new JButton("Color");
        fontColorBtn.addActionListener(this);
        fontColorBtn.setFocusable(false);

        // Fonts
        String[] getFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        fontsBox = new JComboBox(getFonts);
        fontsBox.setSelectedItem("Arial");
        fontsBox.addActionListener(this);

        //============= Frame setup ==============
        this.setTitle("Text Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,870);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        //========== Adding to Frame =============
        this.setJMenuBar(menuBar);
        this.add(fontLabel);
        this.add(fontSpinner);
        this.add(fontColorBtn);
        this.add(fontsBox);
        this.add(scrollPane);
        this.setVisible(true);
    }

    private void loadFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
        chooser.setFileFilter(filter);                // Filter for opening files

        int response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){
            File openFile = new File(chooser.getSelectedFile().getAbsolutePath());
            Scanner fileIn = null;

            try {
                fileIn = new Scanner(openFile);
                if (openFile.isFile()){
                    while(fileIn.hasNextLine()){
                        String write = fileIn.nextLine() + "\n";
                        textArea.append(write);
                    }
                }
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            // ==== Setting up the title for Text Editor frame ====
            this.setTitle(openFile.getName() + " - Text Editor");
        }
    }

    private void saveFile(){
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));
        int response = chooser.showSaveDialog(null);

        if(response == JFileChooser.APPROVE_OPTION){
            File saveFile;
            PrintWriter saveText = null;

            saveFile = new File(chooser.getSelectedFile().getAbsolutePath());
            try {
                saveText = new PrintWriter(saveFile);
                saveText.println(textArea.getText());
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } finally {
                saveText.close();
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fontColorBtn){
            Color color = JColorChooser.showDialog(null,"Choose a Color",Color.BLACK);
            textArea.setForeground(color);
        }

        if(e.getSource() == fontsBox)
        {
            textArea.setFont( new Font((String) fontsBox.getSelectedItem(), Font.PLAIN, textArea.getFont().getSize()));
        }

        if(e.getSource() == load){
            loadFile();
        }

        if(e.getSource()== save){
            saveFile();
        }

        if (e.getSource() == exit){
            System.exit(0);
        }
    }
}
