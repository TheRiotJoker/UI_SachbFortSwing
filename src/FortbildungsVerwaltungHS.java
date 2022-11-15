import java.util.Arrays;

public class FortbildungsVerwaltungHS {
    public static void main(String[] args) {
        //Erstellen von beispielaccounts
        SachbearbeiterErfassenK sErfassenO = new SachbearbeiterErfassenK();
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic2","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic3","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic4","markojurkic123", false);
        System.out.println(Arrays.toString(Sachbearbeiter.gibAlleNamen()));
        LoginAAS loginAAS = new LoginAAS();
        Fortbildung mt1 = new Fortbildung("Mathematik 1");
        Fortbildung mt2 = new Fortbildung("Mathematik 2");
        mt2.fuegeHinzuVoraussetzungen(mt1);
        loginAAS.oeffne();
    }
}