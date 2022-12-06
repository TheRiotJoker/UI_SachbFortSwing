public class FortbildungsZuordnungAnzeigenK {
    public String[] gibBelegteZuordnungen(String benutzername) {
        return Sachbearbeiter.gib(benutzername).gibBelegteFortbildungen().keySet().toArray(new String[0]);
    }
    public String[] gibBestandeneZuordnungen(String benutzername) {
        return Sachbearbeiter.gib(benutzername).gibBestandeneFortbildungen().keySet().toArray(new String[0]);
    }
    public String[] gibZuordnungen(String benutzername) {
        String[] belegteFortbildungen = gibBelegteZuordnungen(benutzername);
        String[] bestandeneFortbildungen = gibBestandeneZuordnungen(benutzername);
        String[] retVal = new String[belegteFortbildungen.length+bestandeneFortbildungen.length];
        for(int i = 0; i < belegteFortbildungen.length; i++) {
            if(belegteFortbildungen[i] != null) {
                retVal[i] = belegteFortbildungen[i].concat( " -> *belegt*");
            }
        }
        for(int i = 0; i < bestandeneFortbildungen.length; i++) {
            if(bestandeneFortbildungen[i] != null) {
                retVal[i+belegteFortbildungen.length] = bestandeneFortbildungen[i].concat( " -> *bestanden*");;
            }
        }
        return retVal;
    }
}
