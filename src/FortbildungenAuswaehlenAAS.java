import javax.swing.*;

public class FortbildungenAuswaehlenAAS {
    private FortbildungAuswaehlenK faK;
    private JList<String> list;
    public FortbildungenAuswaehlenAAS() {
        faK = new FortbildungAuswaehlenK();
    }
    public JList<String> oeffnen() {
        DefaultListModel<String> model = new DefaultListModel<>();
        list = new JList<String>(model);
        String[] strings = faK.gibFortbildungenNamen();
        for(String s : strings) {
            model.addElement(s);
        }
        return list;
    }
    public String getSelectedItem() {
        return list.getSelectedValue();
    }
}
