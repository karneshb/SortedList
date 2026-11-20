import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class SLFrame extends JFrame {
    private final SLSorter sortedList = new SLSorter();
    private JTextField textAdd;
    private JTextField textSearch;
    private JTextArea areaDisplay;

    public SLFrame(){
        setTitle("Binary Search - Sorted List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pnlMain = new JPanel(new BorderLayout(8, 8));
        pnlMain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlMain.add(createInput(), BorderLayout.NORTH);
        pnlMain.add(createDisplay(), BorderLayout.CENTER);
        pnlMain.add(createControl(), BorderLayout.SOUTH);
        add(pnlMain);
        setSize(640,640);
        setLocationRelativeTo(null);
    }

    private JPanel createInput(){
        JPanel pnlInput = new JPanel(new GridLayout(2,1,5,5));

        JPanel pnlAdd = new JPanel(new BorderLayout(5,5));
        pnlAdd.setBorder(BorderFactory.createTitledBorder("Add to List"));
        textAdd = new JTextField();
        JButton btnAdd = new JButton("Add");

        btnAdd.addActionListener(e -> {itemAdd();});
        textAdd.addActionListener(e -> {itemAdd();});
        pnlAdd.add(textAdd, BorderLayout.CENTER);
        pnlAdd.add(btnAdd, BorderLayout.EAST);

        JPanel pnlSearch = new JPanel(new BorderLayout(5,5));
        pnlSearch.setBorder(BorderFactory.createTitledBorder("Search List"));
        textSearch = new JTextField();
        JButton btnSearch = new JButton("Search");

        btnSearch.addActionListener(e -> {itemSearch();});
        textSearch.addActionListener(e -> {itemSearch();});
        pnlSearch.add(textSearch, BorderLayout.CENTER);
        pnlSearch.add(btnSearch, BorderLayout.EAST);

        pnlInput.add(pnlAdd);
        pnlInput.add(pnlSearch);
        return pnlInput;
    }

    private JScrollPane createDisplay(){
        areaDisplay = new JTextArea();
        areaDisplay.setEditable(false);
        areaDisplay.setFont(new Font("Cosmic Sans", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(areaDisplay);
        scroll.setBorder(BorderFactory.createTitledBorder("Display"));
        return scroll;
    }

    private JPanel createControl(){
        JPanel pnlControl = new JPanel(new GridLayout(1,2,5,5));
        JButton btnClear = new JButton("Clear Field");
        JButton btnQuit = new JButton("Quit");

        btnClear.addActionListener(e -> {sortedList.clear(); areaDisplay.setText(""); textAdd.setText(""); textSearch.setText(""); textAdd.requestFocusInWindow();});
        btnQuit.addActionListener(e -> {System.exit(0);});

        pnlControl.add(btnClear);
        pnlControl.add(btnQuit);
        return pnlControl;
    }

    private void itemAdd(){
        String text = textAdd.getText().trim().toUpperCase(Locale.ROOT);
        if(text.isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter string to add to list", "No addtional text", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int i = sortedList.add(text);
        areaDisplay.append("Added: " + text + " at index " + i + "\n");
        listDisplay();
        textAdd.setText("");
        textAdd.requestFocusInWindow();
    }

    private void itemSearch() {
        String targetText = textSearch.getText().trim().toUpperCase(Locale.ROOT);
        if (targetText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter string to search in list", "No search", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int i = sortedList.locationOf(targetText);
        if (sortedList.contains(targetText)) {
            areaDisplay.append("Search \"" + targetText + "\" FOUND at index " + i + "\n");
        } else {
            areaDisplay.append("Search \"" + targetText + "\" NOT FOUND It would be at index " + i + "\n");
        }

        areaDisplay.setCaretPosition(areaDisplay.getDocument().getLength());
        textSearch.setText("");
        textSearch.requestFocusInWindow();
    }

    private void listDisplay(){
        areaDisplay.append("List (" + sortedList.size() + " items): \n");
        areaDisplay.append(sortedList.toString());
        areaDisplay.append("\n");
        areaDisplay.setCaretPosition(areaDisplay.getDocument().getLength());
    }

}
