import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NormalSachbearbeiterBearbeitenAAS {
    private final SachbearbeiterBearbeitenK sbK;
    private final SachbearbeiterBearbeitenAS sbAS;
    private final SachbearbeiterAuswaehlenAAS saAAS;
    public NormalSachbearbeiterBearbeitenAAS() {
        sbK = new SachbearbeiterBearbeitenK();
        sbAS = new SachbearbeiterBearbeitenAS();
        saAAS = new SachbearbeiterAuswaehlenAAS();
    }

    public JPanel oeffnen(NormalAS as) {
        JPanel panel = sbAS.sachbearbeiterEditieren(false);
        JLabel auswahlLabel = new JLabel("Sachbearbeiterauswahl:");
        JButton okButton = new JButton("OK");
        JButton abbruchButton = new JButton("Abbruch");
        JComboBox<String> comboBox = saAAS.oeffnen();
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.WEST;
        panel.add(auswahlLabel, c);
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 7;
        c.insets = new Insets(75,25,0,25);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sbK.schreibeSachbearbeiter(saAAS.getItem(), sbAS.getBenutzername(), sbAS.getPasswort());
                    as.sachbearbeiterEditierenAbschliessen(panel);
                } catch(IllegalArgumentException exc) {
                    as.zeigeFehlermeldung(exc.getMessage());
                }
            }
        });
        abbruchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                as.abbrechen(panel);
            }
        });
        panel.add(okButton, c);
        c.gridx = 1;
        panel.add(abbruchButton, c);
        return panel;

    }
    private void praesentiereSachbearbeiter() {
    }
}
