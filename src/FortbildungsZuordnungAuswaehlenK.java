public class FortbildungsZuordnungAuswaehlenK {
    public String[] gibBelegteZuordnungen(String benutzername) {
        String[] sArray = Sachbearbeiter.gib(benutzername).gibBelegteFortbildungen().keySet().toArray(new String[0]);
        for(String s : sArray) {
            s = s.concat("-> *belegt*");
        }
        return sArray;
    }
    public String[] gibBestandeneZuordnungen(String benutzername) {
        String[] sArray = Sachbearbeiter.gib(benutzername).gibBestandeneFortbildungen().keySet().toArray(new String[0]);
        for(String s : sArray) {
            s = s.concat("-> *bestanden*");
        }
        return sArray;
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
