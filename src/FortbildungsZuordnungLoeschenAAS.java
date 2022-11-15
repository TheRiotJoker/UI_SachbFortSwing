import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        System.out.println("======Fortbildungszuordnung Löschen======");
        String[] fortbildungen = fzaAAS.oeffnen();
        for(int i = 0; i < fortbildungen.length; i++) {
            String s = fortbildungen[i];
            for(int j = 0; j < s.length(); j++) {
                if(s.startsWith("->", j)) {
                    fortbildungen[i] = s.substring(0,j-1);
                }
            }
        }
        String benutzer = fzaAAS.getBenutzername();
        System.out.println("Wählen Sie die Fortbildung aus, die Sie löschen wollen: ");
        Set<String> set = new HashSet<String>(Arrays.asList(fortbildungen)); //packe alles in eine "menge" oder "set", um verdopplungen zu vermeiden
        fortbildungen = set.toArray(new String[0]);
        String f = Auswaehlen.waehleAus(fortbildungen);
        if(f.equalsIgnoreCase("Abbruch")) {
            return;
        }
        fzlK.loescheFortbildungsZuordnung(benutzer, f);
    }
}
