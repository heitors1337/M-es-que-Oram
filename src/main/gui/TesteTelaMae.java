import javax.swing.SwingUtilities;
import gui.TelaMae;

public class TesteTelaMae {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaMae();
        });
    }
}
