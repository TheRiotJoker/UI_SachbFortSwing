public class FortbildungsZuordnungAnzeigenAAS {
    private final FortbildungsZuordnungAuswaehlenAAS fzaAAS;
    public FortbildungsZuordnungAnzeigenAAS() {
        fzaAAS = new FortbildungsZuordnungAuswaehlenAAS();
    }
    public void oeffnen() {
        String[] fortbildungsZuordnungen = fzaAAS.oeffnen();
        System.out.println("Die Zuordnungen von dem von Ihnen gewählten Nutzer: ");
        for(String s : fortbildungsZuordnungen) {
            System.out.println(s);
        }
    }
}
