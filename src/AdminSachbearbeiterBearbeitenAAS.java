import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSachbearbeiterBearbeitenAAS {
    private final SachbearbeiterBearbeitenK sbK;
    private final SachbearbeiterAuswaehlenAAS saAAS;
    private final SachbearbeiterBearbeitenAAS sbAAS;
    private final SachbearbeiterBearbeitenAS sbAS;
    public AdminSachbearbeiterBearbeitenAAS() {
        saAAS = new SachbearbeiterAuswaehlenAAS();
        sbAS = new SachbearbeiterBearbeitenAS();
        sbK = new SachbearbeiterBearbeitenK();
        sbAAS = new SachbearbeiterBearbeitenAAS();
    }

    public JPanel adminSachbearbeiterEditieren(AdminAS adminAS) {
        JPanel panel = sbAS.sachbearbeiterEditieren(true);
        JLabel auswahlLabel = new JLabel("Sachbearbeiterauswahl:");
        JButton okButton = new JButton("OK");
        JButton abbruchButton = new JButton("Abbruch");
        Component component = saAAS.oeffnen();
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.WEST;
        panel.add(auswahlLabel, c);
        c.gridx = 3;
        panel.add(component, c);
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 6;
        c.insets = new Insets(75,25,0,25);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sbK.schreibeSachbearbeiter(saAAS.getItem(), sbAS.getBenutzername(), sbAS.getPasswort(), sbAS.isAdmin());
                    adminAS.adminSachbearbeiterEditierenAbschliessen(panel);
                } catch(IllegalArgumentException exc) {
                    adminAS.zeigeFehlermeldung(exc.getMessage());
                }
            }
        });
        panel.add(okButton, c);
        c.gridx = 1;
        panel.add(abbruchButton, c);
        return panel;
    }
    public String getChosenItem() {
        return saAAS.getItem();
    }
}
