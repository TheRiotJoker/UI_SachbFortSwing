public class AdminAS {
    public void oeffnen() {

        boolean auswahlGetroffen;
        do {
            System.out.println();
            System.out.println("======Administrator Menü======");
            System.out.println();
            String[] auswahl = {"Sachbearbeiter Bearbeiten", "Sachbearbeiter Erfassen", "Sachbearbeiter Loeschen", "Fortbildung Zuordnen", "Fortbildungszuordnung Anzeigen", "Fortbildungszuordnung Loeschen"};
            String wahl = Auswaehlen.waehleAus(auswahl);
            switch (wahl) {
                case "Sachbearbeiter Bearbeiten" -> sachbearbeiterBearbeiten();
                case "Sachbearbeiter Erfassen" -> sachbearbeiterErfassen();
                case "Sachbearbeiter Loeschen" -> sachbearbeiterLoeschen();
                case "Fortbildung Zuordnen" -> fortbildungZuordnen();
                case "Fortbildungszuordnung Anzeigen" -> fortbildungsZuordnungAnzeigen();
                case "Fortbildungszuordnung Loeschen" -> fortbildungsZuordnungLoeschen();
                case "Abbruch" -> {
                    return;
                }

            }
        }while(true);
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
        SachbearbeiterLoeschenAAS slAAS = new SachbearbeiterLoeschenAAS();
        slAAS.oeffnen();
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
