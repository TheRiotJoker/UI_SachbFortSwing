import javax.swing.*;

public class FortbildungsZuordnungAnzeigenAAS {
    private JList<String> list;
    private final FortbildungsZuordnungAnzeigenK fzaK;
    public FortbildungsZuordnungAnzeigenAAS() {

        fzaK = new FortbildungsZuordnungAnzeigenK();
    }
    public JList<String> oeffnen(String name) {
        DefaultListModel<String> model = new DefaultListModel<>();
        list = new JList<>(model);
        String[] strings = fzaK.gibZuordnungen(name);
        for(String s : strings) {
            model.addElement(s);
        }
        return list;
    }

    public String getItem() {
        return list.getSelectedValue();
    }
}
