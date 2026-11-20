import javax.swing.SwingUtilities;

public class SLRunner {
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> new SLFrame().setVisible(true));
    }
}
