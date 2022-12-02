import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SachbearbeiterErfassenAAS {
    private final SachbearbeiterErfassenK seK;
    public SachbearbeiterErfassenAAS() {
        seK = new SachbearbeiterErfassenK();
    }
    public void oeffne(JFrame frame) {
        frame.setTitle("Sachbearbeiter Erstellen");
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(layout);

        JLabel aasNameLabel = new JLabel("Sachbearbeiter Erfassen");
        JLabel benutznameLabel = new JLabel("Benutzername:");
        JLabel passwortLabel = new JLabel("Passwort:");
        JLabel berechtigungLabel = new JLabel("Berechtigung:");

        JTextField nameField = new JTextField();
        JTextField passwortField = new JTextField();
        JRadioButton normal = new JRadioButton("Sachbearbeiter");
        JRadioButton admin = new JRadioButton("Administrator");


        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(normal);
        radioGroup.add(admin);

        JButton abbruchButton = new JButton("Abbruch");
        JButton okButton = new JButton("OK");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 75;
        c.weightx = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(aasNameLabel, c);
        c.gridy = 1;
        panel.add(benutznameLabel,c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(passwortLabel, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(berechtigungLabel,c );
        c.ipady = 0;
        c.gridx = 3;
        c.gridy = 1;
        c.anchor = GridBagConstraints.WEST;
        panel.add(nameField, c);
        c.gridx = 3;
        c.gridy = 2;
        panel.add(passwortField, c);
        c.gridx = 3;
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        panel.add(normal, c);
        c.gridx = 3;
        c.gridy = 4;
        panel.add(admin, c);
        c.anchor = GridBagConstraints.CENTER;
        c.gridx = 0;
        c.gridy = 5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(75,25,0,25);
        panel.add(abbruchButton, c);
        c.gridx = 1;
        panel.add(okButton, c);
        frame.add(panel);
        frame.revalidate();
        frame.setVisible(true);
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SachbearbeiterErfassenK seK = new SachbearbeiterErfassenK();
                if(!admin.isSelected() && !normal.isSelected()) {
                    JOptionPane.showMessageDialog(frame, "Bitte wählen Sie die Rechte aus!", "Fehler", JOptionPane.ERROR_MESSAGE);
                } else {
                    boolean erfolg = seK.erfasseSachbearbeiter(nameField.getText(), passwortField.getText(), admin.isSelected());
                    if(!erfolg) {
                        JOptionPane.showMessageDialog(frame, "Das Passwort/Der Benutzername ist ungültig, oder der Benutzername ist bereits in Verwendung", "Fehler", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        abbruchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

    }
}
