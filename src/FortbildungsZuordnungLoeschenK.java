public class FortbildungsZuordnungLoeschenK {
    public void loescheFortbildungsZuordnung(String benutzer, String fortbildung) {
        System.out.println(fortbildung);
        Sachbearbeiter s = Sachbearbeiter.gib(benutzer);
        for(int i = 0; i < fortbildung.length(); i++) {
            if(fortbildung.startsWith("->", i)) {
                s.loescheFortbildungsZuordnung(fortbildung.substring(0,i-1));
            }
        }
    }
}
