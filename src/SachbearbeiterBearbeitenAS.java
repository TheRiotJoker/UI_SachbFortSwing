import javax.swing.*;

public class SachbearbeiterBearbeitenAS {
    private final SachbearbeiterS sachbearbeiterSicht;
    public SachbearbeiterBearbeitenAS() {
        sachbearbeiterSicht = new SachbearbeiterS();
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
        return panel;
    }
}
