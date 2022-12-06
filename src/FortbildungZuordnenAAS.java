import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FortbildungZuordnenAAS {
    private final SachbearbeiterAuswaehlenAAS saAAS;
    private final FortbildungenAuswaehlenAAS faAAS;
    private final FortbildungZuordnenK faK;
    public FortbildungZuordnenAAS() {
        saAAS = new SachbearbeiterAuswaehlenAAS();
        faAAS = new FortbildungenAuswaehlenAAS();

        faK = new FortbildungZuordnenK();
    }
    public JPanel oeffnen(Schnittstellenklasse as) {
        JPanel panel = new JPanel();
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
        panel.add(saAAS.oeffnen(), c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(new JLabel("Fortbildungen"), c);
        c.gridx = 1;
        c.gridy = 3;
        panel.add(faAAS.oeffnen(), c);
        JRadioButton belegt = new JRadioButton("Belegt");
        JRadioButton bestanden = new JRadioButton("Bestanden");
        ButtonGroup group = new ButtonGroup();
        group.add(belegt);
        c.gridx = 0;
        c.gridy = 4;
        group.add(bestanden);
        c.gridy = 4;
        panel.add(belegt, c);
        c.gridy = 5;
        panel.add(bestanden,c);
        c.gridy = 6;
        c.gridx = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        JButton zuordnen = new JButton("Zuordnen");
        panel.add(zuordnen, c);
        zuordnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(belegt.isSelected()) {
                        faK.ordneFortbildungZu(saAAS.getItem(), faAAS.getSelectedItem(), "belegt");
                        as.fortbildungZurodnenAbgeschlossen(panel);
                    } else {
                        if(bestanden.isSelected()) {
                            faK.ordneFortbildungZu(saAAS.getItem(), faAAS.getSelectedItem(), "bestanden");
                            as.fortbildungZurodnenAbgeschlossen(panel);
                        } else {
                            as.zeigeFehlermeldung("Art der Zuordnung wurde nicht ausgewählt!");
                        }
                    }
                }catch(IllegalArgumentException ex) {
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
        panel.add(abbruch,c);
        return panel;
    }
}
