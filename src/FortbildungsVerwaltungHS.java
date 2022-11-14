import java.util.Arrays;

public class FortbildungsVerwaltungHS {
    public static void main(String[] args) {

        SachbearbeiterErfassenK sErfassenO = new SachbearbeiterErfassenK();
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic2","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic3","markojurkic123", true);
        sErfassenO.erfasseSachbearbeiter("MarkoJurkic4","markojurkic123", false);
        SachbearbeiterLoeschenK sLoeschenK = new SachbearbeiterLoeschenK();
        System.out.println(Arrays.toString(Sachbearbeiter.gibAlleNamen()));
        sLoeschenK.loescheSachbearbeiter("MarkoJurkic3");
        SachbearbeiterBearbeitenK sBearbeitenK = new SachbearbeiterBearbeitenK();
        sBearbeitenK.schreibeSachbearbeiter("MarkoJurkic2", "JurkicMarko2","markojurkic123", true);
        System.out.println(Arrays.toString(Sachbearbeiter.gibAlleNamen()));
        System.out.println("Hello world!");
        LoginAAS loginAAS = new LoginAAS();
        loginAAS.oeffne();
    }
}