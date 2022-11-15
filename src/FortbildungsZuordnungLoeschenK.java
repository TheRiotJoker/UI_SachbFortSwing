public class FortbildungsZuordnungLoeschenK {
    public void loescheFortbildungsZuordnung(String benutzer, String fortbildung) {
        Sachbearbeiter s = Sachbearbeiter.gib(benutzer);
        try {
            s.loescheFortbildungsZuordnung(fortbildung);
        }catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
