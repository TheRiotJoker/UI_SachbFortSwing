import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import javax.swing.*;

public class FortbildungsVerwaltungHS {
    private JToolBar toolBar;
    private JMenuBar menuBar;
    private LoginAAS loginAAS;
    private JFrame frame;
    private JMenu loginMenu;
    private JButton loginButton;

    public FortbildungsVerwaltungHS() {
        oeffnen();
    }

    public void oeffnen() {
        SachbearbeiterErfassenK sErfassenO = new SachbearbeiterErfassenK();
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("DorisPeric","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("EmilNick","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("MarkoNotAdmin","markojurkic123", false);
        System.out.println(Arrays.toString(Sachbearbeiter.gibAlleNamen()));
        loginAAS = new LoginAAS();
        Fortbildung mt1 = new Fortbildung("Mathematik 1");
        Fortbildung mt2 = new Fortbildung("Mathematik 2");
        mt2.fuegeHinzuVoraussetzungen(mt1);
        frame = new JFrame("Hello World");


        //frame.setLayout(new GridBagLayout());
        menuBar = new JMenuBar();
        loginMenu = new JMenu("Login");
        JMenu beendenMenu = new JMenu("Beenden");
        JMenuItem loginMenuItem = new JMenuItem("Login");
        JMenuItem beendenMenuItem = new JMenuItem("Beenden");
        loginMenu.add(loginMenuItem);
        beendenMenu.add(beendenMenuItem);
        menuBar.add(loginMenu);
        menuBar.add(beendenMenu);
        frame.setJMenuBar(menuBar);
        toolBar = new JToolBar();
        toolBar.setFloatable(false);
        AbstractAction beendenAction = new AbstractAction("Beenden") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };

        AbstractAction loginAction = new AbstractAction("Login") {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        };
        JButton abbruchButton = new JButton(beendenAction);
        beendenMenuItem.setAction(beendenAction);
        loginButton = new JButton(loginAction);

        loginMenuItem.setAction(loginAction);


        toolBar.add(loginButton);
        toolBar.add(abbruchButton);


        frame.add(toolBar, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        System.out.println(menuBar);
        frame.setResizable(true);
        frame.setVisible(true);
        refresh();
    }
    private void refresh() {
        frame.repaint();
        frame.revalidate();
    }
    public static void main(String[] args) {
        //Erstellen von beispielaccounts
        FortbildungsVerwaltungHS hs = new FortbildungsVerwaltungHS();

    }
    private void login() {
        loginMenu.setEnabled(false);
        loginButton.setEnabled(false);
        loginAAS.oeffnen(frame, this);
    }
    public void loginBeenden(int admin, JPanel loginPanel) {
        //loginMenu.setEnabled(true);
        //loginButton.setEnabled(true);
        //menuBar.removeAll();
        toolBar.removeAll();
        menuBar.removeAll();
        frame.remove(loginPanel);
        if(admin == 0) {
            AdminAS adminAS = new AdminAS();
            adminAS.oeffnen(frame, toolBar);
        } else {
            NormalAS normalAS = new NormalAS();
        }
        refresh();
    }
    public void loginAbbruch() {
        loginMenu.setEnabled(true);
        loginButton.setEnabled(true);
        refresh();
    }
}