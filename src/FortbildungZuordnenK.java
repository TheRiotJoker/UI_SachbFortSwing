public class FortbildungZuordnenK {
    public void ordneFortbildungZu(String benutzername, String fortbildungName, String typ) {
        Sachbearbeiter s = Sachbearbeiter.gib(benutzername);
        if(typ.equalsIgnoreCase("belegt")) {
            s.fuegeHinzuBelegteFortbildungen(Fortbildung.gib(fortbildungName), fortbildungName);
        } else {
            s.fuegeHinzuBestandeneFortbildungen(Fortbildung.gib(fortbildungName), fortbildungName);
        }

    }
}
