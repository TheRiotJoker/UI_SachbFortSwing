public class FortbildungsZuordnungAuswaehlenK {
    public String[] gibZuordnungen(String benutzername, String typ) {
        if (typ.equals("belegt")) {
            return Sachbearbeiter.gib(benutzername).gibBelegteFortbildungen().keySet().toArray(new String[0]);
        } else {
            return Sachbearbeiter.gib(benutzername).gibBestandeneFortbildungen().keySet().toArray(new String[0]);
        }
    }
}
