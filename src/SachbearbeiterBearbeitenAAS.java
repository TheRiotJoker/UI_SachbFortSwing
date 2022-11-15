public class SachbearbeiterBearbeitenAAS {
    public final SachbearbeiterAuswaehlenAAS sachbearbeiterAuswaehlen;
    public SachbearbeiterBearbeitenAAS() {
        sachbearbeiterAuswaehlen = new SachbearbeiterAuswaehlenAAS();
    }
    public void ausgefuehrt(String name) {
        System.out.println("Der Sachbearbeiter "+name+" wurde erfolgreich geändert!");
    }
}
