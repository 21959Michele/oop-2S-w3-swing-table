package com.company;



import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

   public class Main extends JPanel {

    private static boolean DEBUG = true;


    public static void main(String[] args) {
        // write your code here

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public Main() {
        super(new GridLayout(1, 0));


        String[] columnNames = {"First Name", "Last Name", "SuperHero Name", "Company", "Imortal"};

        Object[][] date = {
                {"Clark", "Kent", "Superman", "Marvel", false},
                {"Bruce", "Wayne", "Batman", "Marvel", false},
                {"Diana", "Prince", "Wonder Woman", "Marvel", false},
                {"Thoe", "Odinson", "Thor", "Marvel", false},
                {"Bruce", "Banner", "Hulk", "Marvel", false},

        };


        final JTable table = new JTable(date, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(600, 80));
        table.setFillsViewportHeight(true);

        if (DEBUG) {

            table.addMouseListener(new MouseAdapter() {

                public void mouseClicked(MouseEvent e) {

                }
            });
        }

        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
    }

    private static void createAndShowGUI() {
        if (DEBUG) {
            System.out.println();

        }

        JFrame frame = new JFrame("Super Heroes and their Powers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Main newContentPane = new Main();

        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);

    }

    private void printDebugDta(JTable table) {
        System.out.println("Mouse is clicked");

        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();


        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");

        for (int i = 0; i < numRows; i++) {
            System.out.println(" row " + i + ":");
            for (int j = 0; j < numCols; i++) {
                System.out.println("   " + model.getValueAt(i, j) + ":");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }
}

