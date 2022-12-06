import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SachbearbeiterBearbeitenAS {
    private final SachbearbeiterS sachbearbeiterSicht;
    private final FortbildungsZuordnungAnzeigenAAS fzAAS;
    private  JList<String> list;
    public SachbearbeiterBearbeitenAS() {
        sachbearbeiterSicht = new SachbearbeiterS();
        fzAAS = new FortbildungsZuordnungAnzeigenAAS();
    }
    public String getBenutzername() {
        return sachbearbeiterSicht.getBenutzernameInput();
    }
    public String getPasswort() {
        return sachbearbeiterSicht.getPasswortField();
    }
    public boolean isAdmin() {
        return sachbearbeiterSicht.isAdminSelected();
    }
    public JPanel sachbearbeiterEditieren(boolean editierbar) {
        JPanel panel;
        String ueberschrift;
        if(editierbar) {
            ueberschrift = "Sachbearbeiter Bearbeiten - Administrator";
        } else {
            ueberschrift = "Sachbearbeiter Bearbeiten - Normal";
        }
        panel = sachbearbeiterSicht.gibSachbearbeiterPanel(ueberschrift, "MarkoJurkic", "markojurkic123");
        SachbearbeiterAuswaehlenAAS saAAS = new SachbearbeiterAuswaehlenAAS();
        JComboBox<String> comboBox = saAAS.oeffnen();
        GridBagConstraints c = new GridBagConstraints();
        list = fzAAS.oeffnen(sachbearbeiterSicht.getBenutzernameInput());
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.gridy = 6;
        panel.add(new JLabel("Fortbildungen"), c);
        c.gridx = 3;
        panel.add(list, c);
        c.gridy = 5;
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 3;
        panel.add(comboBox, c);
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                c.gridx = 3;
                c.gridy = 6;
                updateList(comboBox, panel, c);
            }
        });
        return panel;
    }
    private void updateList(JComboBox<String> comboBox, JPanel panel, GridBagConstraints c) {
        panel.remove(list);
        list = fzAAS.oeffnen((String)comboBox.getSelectedItem());
        panel.add(list, c);
        panel.revalidate();
        panel.repaint();
    }
}
