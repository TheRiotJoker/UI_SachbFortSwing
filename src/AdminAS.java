public class AdminAS {
    public void oeffnen() {
        boolean auswahlGetroffen;
        do {
            auswahlGetroffen = true;
            Eingabe.abbruchInfo();
            String[] auswahl = {"Sachbearbeiter Bearbeiten", "Sachbearbeiter Erfassen", "Sachbearbeiter Loeschen", "Fortbildung Zuordnen", "Fortbildungszuordnung Anzeigen", "Fortbildungszuordnung Loeschen"};
            String wahl = Auswaehlen.waehleAus(auswahl);
            switch (wahl) {
                case "Sachbearbeiter Bearbeiten" -> sachbearbeiterBearbeiten();
                case "Sachbearbeiter Erfassen" -> sachbearbeiterErfassen();
                case "Sachbearbeiter Loeschen" -> sachbearbeiterLoeschen();
                case "Fortbildung Zuordnen" -> fortbildungZuordnen();
                case "Fortbildungszuordnung Anzeigen" -> fortbildungsZuordnungAnzeigen();
                case "Fortbildungszuordnung Loeschen" -> fortbildungsZuordnungLoeschen();
                case "abbruch" -> {
                    return;
                }
                default -> auswahlGetroffen = false;

            }
        }while(!auswahlGetroffen);
    }
    private void sachbearbeiterBearbeiten() {
        AdminSachbearbeiterBearbeitenAAS asbASS = new AdminSachbearbeiterBearbeitenAAS();
        asbASS.oeffnen();
    }
    private void sachbearbeiterErfassen() {
        SachbearbeiterErfassenAAS seAAS = new SachbearbeiterErfassenAAS();
        seAAS.oeffne();
    }
    private void sachbearbeiterLoeschen() {

    }
    private void fortbildungZuordnen() {

    }
    private void fortbildungsZuordnungLoeschen() {

    }
    private void fortbildungsZuordnungAnzeigen() {

    }
}
