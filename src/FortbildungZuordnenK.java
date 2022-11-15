public class FortbildungZuordnenK {
    public void ordneFortbildungZu(String benutzername, String fortbildungName, String typ) {
        Sachbearbeiter s = Sachbearbeiter.gib(benutzername);
        if(typ.equalsIgnoreCase("belegt")) {
            try {
                s.fuegeHinzuBelegteFortbildungen(Fortbildung.gib(fortbildungName), fortbildungName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } else {
            try {
                s.fuegeHinzuBestandeneFortbildungen(Fortbildung.gib(fortbildungName), fortbildungName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
