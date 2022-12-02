import javax.swing.*;
import java.awt.event.ActionEvent;

public class AdminAS {
    private JFrame frame;
    public void oeffnen(JFrame frame, JToolBar toolBar) {
        this.frame = frame;
        frame.setTitle("Sachbearbeiter Verwaltung - Administrator");
        AbstractAction sBearbeitenAction = new AbstractAction("Sachbearbeiter Bearbeiten") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.add(sachbearbeiterBearbeiten());
                frame.setTitle("Admin Sachbearbeiter Bearbeiten");
                frame.repaint();
                frame.revalidate();
            }
        };
        AbstractAction sErfassenAction = new AbstractAction("Sachbearbeiter Erfassen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                sachbearbeiterErfassen(frame);
            }
        };
        AbstractAction sLoeschenAction = new AbstractAction("Sachbearbeiter Löschen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sloeschen");
            }
        };
        AbstractAction fZuordnenAction = new AbstractAction("Fortbildung Zuordnen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("fzuordnen");
            }
        };
        AbstractAction fZuordnungLoeschenAction = new AbstractAction("Fortbildungszuordnung Löschen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("fzuordnungloeschen");
            }
        };
        AbstractAction zurueckAction = new AbstractAction("Zurück") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("zurueck");
            }
        };
        JButton sBearbeiten = new JButton(sBearbeitenAction);
        JButton sErfassen = new JButton(sErfassenAction);
        JButton sLoeschen = new JButton(sLoeschenAction);
        JButton fZuordnen = new JButton(fZuordnenAction);
        JButton fZuordnungLoeschen = new JButton(fZuordnungLoeschenAction);
        JButton zurueck = new JButton(zurueckAction);
        JMenu sachbearbeiterMenu = new JMenu("Sachbearbeiter");
        JMenu zurueckMenu = new JMenu("Zurück");
        JMenuItem sBearbeitenItem = new JMenuItem(sBearbeitenAction);
        JMenuItem sErfassenItem = new JMenuItem(sErfassenAction);
        JMenuItem sLoeschenItem = new JMenuItem(sLoeschenAction);
        JMenuItem fZuordnenItem = new JMenuItem(fZuordnenAction);
        JMenuItem fZuordnungLoeschenItem = new JMenuItem(fZuordnungLoeschenAction);
        JMenuItem zurueckItem = new JMenuItem(zurueckAction);
        sachbearbeiterMenu.add(sBearbeitenItem);
        sachbearbeiterMenu.add(sErfassenItem);
        sachbearbeiterMenu.add(sLoeschenItem);
        sachbearbeiterMenu.add(fZuordnenItem);
        sachbearbeiterMenu.add(fZuordnungLoeschenItem);
        zurueckMenu.add(zurueckItem);
        JMenuBar menuBar = frame.getJMenuBar();
        menuBar.add(sachbearbeiterMenu);
        menuBar.add(zurueckMenu);

        toolBar.add(sBearbeiten);
        toolBar.add(sErfassen);
        toolBar.add(sLoeschen);
        toolBar.add(fZuordnen);
        toolBar.add(fZuordnungLoeschen);
        toolBar.add(zurueck);
        frame.revalidate();
        frame.repaint();
    }
    private JPanel sachbearbeiterBearbeiten() {
        AdminSachbearbeiterBearbeitenAAS asbASS = new AdminSachbearbeiterBearbeitenAAS();
        return asbASS.adminSachbearbeiterEditieren(this);
    }

    public void zeigeFehlermeldung(String message) {
        JOptionPane.showMessageDialog(frame, message, "Fehler", JOptionPane.ERROR_MESSAGE );
    }
    private void sachbearbeiterErfassen(JFrame frame) {
        SachbearbeiterErfassenAAS seAAS = new SachbearbeiterErfassenAAS();
        seAAS.oeffne(frame);
    }
    private void sachbearbeiterLoeschen() {
        SachbearbeiterLoeschenAAS slAAS = new SachbearbeiterLoeschenAAS();
        slAAS.oeffnen();
    }
    private void fortbildungZuordnen() {
        FortbildungZuordnenAAS fzAAS = new FortbildungZuordnenAAS();
        fzAAS.oeffnen();
    }
    private void fortbildungsZuordnungLoeschen() {
        FortbildungsZuordnungLoeschenAAS fzlAAS = new FortbildungsZuordnungLoeschenAAS();
        fzlAAS.oeffnen();

    }
    private void fortbildungsZuordnungAnzeigen() {
        FortbildungsZuordnungAnzeigenAAS fzaAAS = new FortbildungsZuordnungAnzeigenAAS();
        fzaAAS.oeffnen();
    }

    public void adminSachbearbeiterEditierenAbschliessen(JPanel panel) {
        JOptionPane.showMessageDialog(frame, "Der Sachbearbeiter wurde erfolgreich bearbeitet!");
        frame.remove(panel);
        frame.revalidate();
        frame.repaint();
    }
}
