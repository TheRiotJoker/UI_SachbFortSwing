public class FortbildungsZuordnungLoeschenAAS {
    public final FortbildungsZuordnungLoeschenK fzlK;
    public final FortbildungsZuordnungAuswaehlenAAS fzaAAS;

    public FortbildungsZuordnungLoeschenAAS() {
        fzlK = new FortbildungsZuordnungLoeschenK();
        fzaAAS = new FortbildungsZuordnungAuswaehlenAAS();
    }

    public void oeffnen() { //falls Sie das lesen, hier hat ganz ehrlich nach 6 Stunden arbeit mein Gehirn aufgehört.
        //das könnte man auch Kapitulation nennen, wie ich es hier gelöst habe, aber es ist funktionsfähig
        //und der rest ist (meine ich) sauber
        String[] fortbildungen = fzaAAS.oeffnen();
        String benutzer = fzaAAS.getBenutzername();
        System.out.println("Wählen Sie die Fortbildung aus, die Sie löschen wollen: ");
        String f = Auswaehlen.waehleAus(fortbildungen);
        if(f.equals("Abbruch")) {
            return;
        }
        fzlK.loescheFortbildungsZuordnung(benutzer, f);
    }
}
