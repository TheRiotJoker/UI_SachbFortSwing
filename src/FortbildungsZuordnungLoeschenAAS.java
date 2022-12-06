import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FortbildungsZuordnungLoeschenAAS {
    public final FortbildungsZuordnungLoeschenK fzlK;
    public final FortbildungsZuordnungAnzeigenAAS faAAS;
    public final SachbearbeiterAuswaehlenAAS saAAS;
    private JList<String> list;
    private JPanel panel;
    private JComboBox<String> comboBox;

    public FortbildungsZuordnungLoeschenAAS() {
        fzlK = new FortbildungsZuordnungLoeschenK();
        faAAS = new FortbildungsZuordnungAnzeigenAAS();
        saAAS = new SachbearbeiterAuswaehlenAAS();
    }

    public JPanel oeffnen(Schnittstellenklasse as) {
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(50,25,50,25);
        c.weightx = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Fortbildung Zuordnen"), c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(new JLabel("Sachbearbeiter"),c);
        c.gridx = 1;
        c.gridy = 1;
        comboBox = saAAS.oeffnen();
        panel.add(comboBox, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(new JLabel("Fortbildungen"), c);
        c.gridx = 1;
        c.gridy = 3;
        list = faAAS.oeffnen(saAAS.getItem());
        panel.add(list, c);
        c.gridy = 6;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        JButton zuordnen = new JButton("Löschen");
        panel.add(zuordnen, c);
        zuordnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(list.getSelectedValue() != null) {
                        fzlK.loescheFortbildungsZuordnung((String)comboBox.getSelectedItem(), list.getSelectedValue());
                        System.out.println((String)comboBox.getSelectedItem()+ " ----- " +list.getSelectedValue());
                        as.fortbildungsZuordnungLoeschenAbschliessen(panel);
                    } else {
                        as.zeigeFehlermeldung("Es wurde keine Fortbildung ausgewählt!");
                    }
                } catch(IllegalArgumentException ex) {
                    as.zeigeFehlermeldung(ex.getMessage());
                }
            }
        });
        c.gridx = 1;
        JButton abbruch = new JButton("Abbruch");
        abbruch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                as.abbrechen(panel);
            }
        });
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                updateList(c);
            }
        });
        panel.add(abbruch,c);
        return panel;

    }

    private void updateList(GridBagConstraints c) {
        c.gridx = 1;
        c.gridy = 3;
        panel.remove(list);
        list = faAAS.oeffnen((String)comboBox.getSelectedItem());
        panel.add(list, c);
        panel.revalidate();
        panel.repaint();
    }
}
