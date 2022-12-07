import javax.swing.*;
import java.util.Arrays;

public class Schnittstellenklasse {
    protected JFrame frame;
    public void fortbildungZurodnenAbgeschlossen(JPanel panel) {
        JOptionPane.showMessageDialog(frame, "Fortbildung erfolgreich zugeordnet!");
        frame.remove(panel);
        refreshFrame();
    }

    public void fortbildungsZuordnungLoeschenAbschliessen(JPanel panel) {
        JOptionPane.showMessageDialog(frame, "Fortbildungszuordnung erfolgreich gelöscht!");
        frame.remove(panel);
        refreshFrame();
    }

    void refreshFrame() {
        frame.revalidate();
        frame.repaint();
    }
    public void abbrechen(JPanel panel) {
        JOptionPane.showMessageDialog(frame, "Der Vorgang wurde abgebrochen.");
        frame.remove(panel);
        refreshFrame();
    }
    public void sachbearbeiterEditierenAbschliessen(JPanel panel) {
        JOptionPane.showMessageDialog(frame, "Sachbearbeiter wurde erfolgreich editiert!");
        frame.remove(panel);
        refreshFrame();
    }
    protected void updateFrame(JPanel panel) {
        frame.add(panel);
        frame.setTitle("Admin Panel");
        frame.repaint();
        frame.revalidate();
    }
    protected void zeigeFehlermeldung(String message) {
        JOptionPane.showMessageDialog(frame, message, "Fehler", JOptionPane.ERROR_MESSAGE );
    }
}
