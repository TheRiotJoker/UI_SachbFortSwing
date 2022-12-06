import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SachbearbeiterErfassenAAS {
    private final SachbearbeiterErfassenK seK;
    private final SachbearbeiterS sachbearbeiterSicht;
    public SachbearbeiterErfassenAAS() {
        seK = new SachbearbeiterErfassenK();
        sachbearbeiterSicht = new SachbearbeiterS();
    }
    public JPanel oeffne(AdminAS adminAS) {
        JPanel returnPanel = sachbearbeiterSicht.gibSachbearbeiterPanel("Sachbearbeiter Erfassen", "NeuerName","NeuesPasswort");
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.weightx = 1;
        c.gridy = 6;
        c.insets = new Insets(75,25,0,25);
        c.anchor = GridBagConstraints.CENTER;
        c.fill = GridBagConstraints.HORIZONTAL;
        JButton okButton = new JButton("OK");
        returnPanel.add(okButton, c);
        JButton abbruchButton = new JButton("Abbruch");
        c.gridx = 1;
        returnPanel.add(abbruchButton, c);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    seK.erfasseSachbearbeiter(sachbearbeiterSicht.getBenutzernameInput(),sachbearbeiterSicht.getPasswortField(),sachbearbeiterSicht.isAdminSelected());
                    adminAS.adminSachbearbeiterErfassenAbschliessen(returnPanel);
                }catch(IllegalArgumentException ex) {
                    adminAS.zeigeFehlermeldung(ex.getMessage());
                }
            }
        });
        abbruchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminAS.abbrechen(returnPanel);
            }
        });
        return returnPanel;
    }
}
