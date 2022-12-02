import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SachbearbeiterAuswaehlenAAS {
    private final SachbearbeiterAuswaehlenK saK;
    private JComboBox<String> jComboBox;
    public SachbearbeiterAuswaehlenAAS() {
        saK = new SachbearbeiterAuswaehlenK();
    }
    public JComboBox oeffnen() {
        jComboBox = new JComboBox<>();
        String[] alleSachbearbeiter = saK.gibSachbearbeiterNamen();
        for(String s : alleSachbearbeiter) {
            jComboBox.addItem(s);
        }
        return jComboBox;
    }

    public String getItem() {
        return ((String)jComboBox.getSelectedItem());
    }
}
