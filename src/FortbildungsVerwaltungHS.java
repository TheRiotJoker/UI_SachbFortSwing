import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.*;

public class FortbildungsVerwaltungHS {
    public static void main(String[] args) {
        //Erstellen von beispielaccounts
        SachbearbeiterErfassenK sErfassenO = new SachbearbeiterErfassenK();
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("DorisPeric","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("EmilNick","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("MarkoNotAdmin","markojurkic123", false);
        System.out.println(Arrays.toString(Sachbearbeiter.gibAlleNamen()));
        LoginAAS loginAAS = new LoginAAS();
        Fortbildung mt1 = new Fortbildung("Mathematik 1");
        Fortbildung mt2 = new Fortbildung("Mathematik 2");
        mt2.fuegeHinzuVoraussetzungen(mt1);
        JFrame frame = new JFrame("Hello World");


        //frame.setLayout(new GridBagLayout());
        JMenuBar menuBar = new JMenuBar();
        JMenu loginMenu = new JMenu("Login");
        JMenu beendenMenu = new JMenu("Beenden");
        JMenuItem loginMenuItem = new JMenuItem("Login");
        JMenuItem beendenMenuItem = new JMenuItem("Beenden");
        loginMenu.add(loginMenuItem);
        beendenMenu.add(beendenMenuItem);
        menuBar.add(loginMenu);
        menuBar.add(beendenMenu);
        frame.setJMenuBar(menuBar);
        AbstractAction beendenAction = new AbstractAction("Beenden") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };
        AbstractAction loginAction = new AbstractAction("Login") {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginAAS.oeffnen(frame);
            }
        };
        JButton loginButton = new JButton(loginAction);
        JButton abbruchButton = new JButton(beendenAction);

        JToolBar toolBar = new JToolBar();
        toolBar.add(loginButton);
        toolBar.add(abbruchButton);
        toolBar.setFloatable(false);
        frame.add(toolBar, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setResizable(true);
        frame.repaint();
        frame.revalidate();
        frame.setVisible(true);
    }
}