import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginAAS {
    private final LoginK loginK;
    public LoginAAS() {
        loginK = new LoginK();

    }
    public void oeffnen(JFrame frame, FortbildungsVerwaltungHS hs) {
        SachbearbeiterS sachbearbeiterSicht = new SachbearbeiterS();
        JPanel panel = sachbearbeiterSicht.gibSachbearbeiterPanel("Login", "MarkoJurkic", "markojurkic123");
        GridBagConstraints c = new GridBagConstraints();
        JButton okButton = new JButton("OK");
        JButton abbruchButton = new JButton("Abbruch");
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 5;
        c.insets = new Insets(75,25,0,25);
        c.fill = GridBagConstraints.HORIZONTAL;
        panel.add(abbruchButton, c);
        c.gridx = 1;
        panel.add(okButton, c);
        frame.add(panel);
        frame.revalidate();
        frame.setVisible(true);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sachbearbeiterSicht.isAnythingSelected()) {
                    JOptionPane.showMessageDialog(frame, "Bitte wählen Sie ihre Rechte aus!", "Fehler", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean erfolg = loginK.pruefeLogin(sachbearbeiterSicht.getBenutzernameInput(), sachbearbeiterSicht.getPasswortField(), sachbearbeiterSicht.isAdminSelected());
                    if(!erfolg) {
                        JOptionPane.showMessageDialog(frame, "Nutzer, Passwort oder Berechtigung ist/sind nicht korrekt, bitte versuchen Sie es nochmal!", "Fehler", JOptionPane.ERROR_MESSAGE);
                    } else {
                        int retVal;
                        retVal = sachbearbeiterSicht.isAdminSelected() ? 0 : 1;
                        hs.loginBeenden(retVal, panel);
                    }
                }
            }
        });
        abbruchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(panel);
                hs.loginAbbruch();
            }
        });
    }
}
