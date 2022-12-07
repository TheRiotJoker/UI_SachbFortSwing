import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class NormalAS extends Schnittstellenklasse {
    private final NormalSachbearbeiterBearbeitenAAS nsbAAS;
    public void oeffnen(JFrame frame, JToolBar toolBar) {
        this.frame = frame;
        frame.setTitle("Sachbearbeiter Verwaltung - Sachbearbeiter");
        AbstractAction sBearbeitenAction = new AbstractAction("Sachbearbeiter Bearbeiten") {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFrame(sachbearbeiterBearbeiten());
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
                System.out.println("Removed jpanel");
                for(Component c : frame.getContentPane().getComponents()) {
                    System.out.println(c);
                    if(c instanceof JPanel) {
                        frame.remove(c);
                        refreshFrame();
                    }
                }
            }
        };
        JButton sBearbeiten = new JButton(sBearbeitenAction);
        JButton fZuordnen = new JButton(fZuordnenAction);
        JButton fZuordnungLoeschen = new JButton(fZuordnungLoeschenAction);
        JButton zurueck = new JButton(zurueckAction);
        JMenu sachbearbeiterMenu = new JMenu("Sachbearbeiter");
        JMenu zurueckMenu = new JMenu("Zurück");
        JMenuItem sBearbeitenItem = new JMenuItem(sBearbeitenAction);
        JMenuItem fZuordnenItem = new JMenuItem(fZuordnenAction);
        JMenuItem fZuordnungLoeschenItem = new JMenuItem(fZuordnungLoeschenAction);
        JMenuItem zurueckItem = new JMenuItem(zurueckAction);
        sachbearbeiterMenu.add(sBearbeitenItem);
        sachbearbeiterMenu.add(fZuordnenItem);
        sachbearbeiterMenu.add(fZuordnungLoeschenItem);
        zurueckMenu.add(zurueckItem);
        JMenuBar menuBar = frame.getJMenuBar();
        menuBar.add(sachbearbeiterMenu);
        menuBar.add(zurueckMenu);
        toolBar.add(sBearbeiten);
        toolBar.add(fZuordnen);
        toolBar.add(fZuordnungLoeschen);
        toolBar.add(zurueck);
        frame.revalidate();
        frame.repaint();
    }
    public NormalAS() {
        nsbAAS = new NormalSachbearbeiterBearbeitenAAS();
    }
    private JPanel sachbearbeiterBearbeiten() {
        return nsbAAS.oeffnen(this);
    }
    private JPanel fortbildungZuordnen() {
        FortbildungZuordnenAAS fzAAS = new FortbildungZuordnenAAS();
        return fzAAS.oeffnen(this);
    }
    private JPanel fortbildungsZuordnungLoeschen() {
        FortbildungsZuordnungLoeschenAAS fzlAAS = new FortbildungsZuordnungLoeschenAAS();
        return fzlAAS.oeffnen(this);

    }
}
