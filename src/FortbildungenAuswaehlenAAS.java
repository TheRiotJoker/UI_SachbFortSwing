public class FortbildungenAuswaehlenAAS {
    private final FortbildungAuswaehlenK faK;
    public FortbildungenAuswaehlenAAS() {
        faK = new FortbildungAuswaehlenK();
    }
    public String oeffne() {
        System.out.println("======Fortbildungen Auswählen======");
        praesentiereFortbildungen();
        return selektiereFortbildung();
    }
    private void praesentiereFortbildungen() {
        String[] fortbildungen = faK.gibFortbildungenNamen();
        System.out.println("Verfügbare Fortbildungen");
        for(String s : fortbildungen) {
            System.out.println(s);
        }
    }
    private String selektiereFortbildung() {
        Eingabe.abbruchInfo();
        return Auswaehlen.waehleAus(faK.gibFortbildungenNamen());
    }

}
