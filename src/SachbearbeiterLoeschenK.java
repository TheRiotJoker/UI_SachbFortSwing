public class SachbearbeiterLoeschenK {
    public boolean loescheSachbearbeiter(String name) {
        try {
            Sachbearbeiter.loesche(name);
            return true;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
