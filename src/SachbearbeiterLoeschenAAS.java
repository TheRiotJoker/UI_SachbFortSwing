import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SachbearbeiterLoeschenAAS {
    private final SachbearbeiterLoeschenK sblK;
    private final SachbearbeiterAuswaehlenAAS saAAS;
    public SachbearbeiterLoeschenAAS() {
        sblK = new SachbearbeiterLoeschenK();
        saAAS = new SachbearbeiterAuswaehlenAAS();
    }
    public JPanel oeffnen(AdminAS adminAS) {
        JPanel returnPanel = new JPanel();
        returnPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.WEST;
        c.gridx = 0;
        c.weightx = 1.0;
        c.insets = new Insets(25,25,25,25);
        c.gridy = 0;
        JLabel label = new JLabel("Sachbearbeiter Löschen");
        returnPanel.add(label,c);
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        returnPanel.add(saAAS.oeffnen(), c);
        JButton okButton = new JButton("Löschen");
        JButton abbruchButton = new JButton("Abbruch");
        c.gridy = 2;
        returnPanel.add(okButton,c);
        c.gridx = 1;
        returnPanel.add(abbruchButton,c);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sblK.loescheSachbearbeiter(saAAS.getItem());
                    adminAS.adminSachbearbeiterLoeschenAbschliessen(returnPanel);
                } catch(IllegalArgumentException ex) {
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
