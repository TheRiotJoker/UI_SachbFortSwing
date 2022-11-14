public class SachbearbeiterErfassenK {
    public boolean erfasseSachbearbeiter(String name, String passwort, boolean isAdmin) {
        try {
            Sachbearbeiter s = new Sachbearbeiter(name, passwort, isAdmin);
            System.out.println("Der Sachbearbeiter wurde erfolgreich angelegt.");
            return true;
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
