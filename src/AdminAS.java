import javax.swing.*;
import java.awt.event.ActionEvent;

public class AdminAS extends Schnittstellenklasse {
    public void oeffnen(JFrame frame, JToolBar toolBar) {
        this.frame = frame;
        frame.setTitle("Sachbearbeiter Verwaltung - Administrator");
        AbstractAction sBearbeitenAction = new AbstractAction("Sachbearbeiter Bearbeiten") {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame(sachbearbeiterBearbeiten());
            }
        };
        AbstractAction sErfassenAction = new AbstractAction("Sachbearbeiter Erfassen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame(sachbearbeiterErfassen());
            }
        };
        AbstractAction sLoeschenAction = new AbstractAction("Sachbearbeiter Löschen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame(sachbearbeiterLoeschen());
            }
        };
        AbstractAction fZuordnenAction = new AbstractAction("Fortbildung Zuordnen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame(fortbildungZuordnen());
            }
        };
        AbstractAction fZuordnungLoeschenAction = new AbstractAction("Fortbildungszuordnung Löschen") {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame(fortbildungsZuordnungLoeschen());
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

    protected void updateFrame(JPanel panel) {
        super.updateFrame(panel);
        frame.setTitle("Admin Panel");
    }
    private JPanel sachbearbeiterBearbeiten() {
        AdminSachbearbeiterBearbeitenAAS asbASS = new AdminSachbearbeiterBearbeitenAAS();
        return asbASS.adminSachbearbeiterEditieren(this);
    }


    private JPanel sachbearbeiterErfassen() {
        SachbearbeiterErfassenAAS seAAS = new SachbearbeiterErfassenAAS();
        frame.setTitle("Sachbearbeiter Erfassen");
        return seAAS.oeffne(this);
    }
    private JPanel sachbearbeiterLoeschen() {
        SachbearbeiterLoeschenAAS slAAS = new SachbearbeiterLoeschenAAS();
        return slAAS.oeffnen(this);
    }
    private JPanel fortbildungZuordnen() {
        FortbildungZuordnenAAS fzAAS = new FortbildungZuordnenAAS();
        return fzAAS.oeffnen(this);
    }
    private JPanel fortbildungsZuordnungLoeschen() {
        FortbildungsZuordnungLoeschenAAS fzlAAS = new FortbildungsZuordnungLoeschenAAS();
        return fzlAAS.oeffnen(this);
    }




    public void adminSachbearbeiterErfassenAbschliessen(JPanel panel) {
        JOptionPane.showMessageDialog(frame, "Der Sachbearbeiter wurde erfasst!");
        frame.remove(panel);
        refreshFrame();
    }

    public void adminSachbearbeiterLoeschenAbschliessen(JPanel panel) {
        JOptionPane.showMessageDialog(frame, "Der Sachbearbeiter wurde gelöscht!");
        frame.remove(panel);
        refreshFrame();
    }


}
