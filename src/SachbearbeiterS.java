import javax.swing.*;
import java.awt.*;
public class SachbearbeiterS {
    private JTextField nameField;
    private JTextField passwortField;
    private JRadioButton admin;
    private JRadioButton normal;
    public String getBenutzernameInput() {
        return nameField.getText();
    }
    public String getPasswortField() {
        return passwortField.getText();
    }
    //es tut mir nicht leid, englische begriffe benutzt zu haben, bin gerade so am verzweiflen an der aufgabenstellung, die ist so dermaßen komisch geschrieben
    public boolean isAnythingSelected() {
        return normal.isSelected() || admin.isSelected();
    }
    public boolean isAdminSelected() {
        return admin.isSelected();
    }
    public JPanel gibSachbearbeiterPanel(String ueberschrift, String defaultBenutzername, String defaultPasswort) {
        JPanel panel = new JPanel();
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        panel.setLayout(layout);

        JLabel hauptLabel = new JLabel(ueberschrift);
        JLabel benutznameLabel = new JLabel("Benutzername:");
        JLabel passwortLabel = new JLabel("Passwort:");
        JLabel berechtigungLabel = new JLabel("Berechtigung:");

        nameField = new JTextField(defaultBenutzername);
        passwortField = new JTextField(defaultPasswort);
        normal = new JRadioButton("Sachbearbeiter");
        admin = new JRadioButton("Administrator");


        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(normal);
        radioGroup.add(admin);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 75;
        c.weightx = 1;
        c.weighty = 1;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        panel.add(hauptLabel, c);
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
        if(!ueberschrift.equals("Sachbearbeiter Bearbeiten - Normal")) {
            c.gridx = 3;
            c.gridy = 3;
            c.fill = GridBagConstraints.NONE;
            panel.add(normal, c);
            c.gridx = 3;
            c.gridy = 4;
            panel.add(admin, c);
        }
        return panel;
    }
}
