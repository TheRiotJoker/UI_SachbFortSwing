public class NormalAS {
    private final NormalSachbearbeiterBearbeitenAAS nsbAAS;
    public void oeffnen() {
        do {
            System.out.println();
            System.out.println("======Sachbearbeiter Menü======");
            System.out.println();
            String auswahl = Auswaehlen.waehleAus(new String[]{"Sachbearbeiter Bearbeiten", "Fortbildung Zuordnen", "Fortbildungszuordnung Loeschen", "Fortbildungszuordnungen Anzeigen"});
            switch(auswahl) {
                case "Sachbearbeiter Bearbeiten" -> sachbearbeiterBearbeiten();
                case "Fortbildung Zuordnen" -> fortbildungZuordnen();
                case "Fortbildungszuordnung Loeschen" -> fortbildungsZuordnungLoeschen();
                case "Fortbildungszuordnungen Anzeigen" -> fortbildungsZuordnungAnzeigen();
                case "Abbruch" -> {
                    return;
                }
                default -> System.out.println("Fehler");
            }
        }while(true);
    }
    public NormalAS() {
        nsbAAS = new NormalSachbearbeiterBearbeitenAAS();
    }
    private void sachbearbeiterBearbeiten() {
        nsbAAS.oeffnen();
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
}
