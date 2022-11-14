public class LoginAAS {
    private final LoginK loginK;
    private final NormalAS normalAS;
    private final AdminAS adminAS;
    public LoginAAS() {
        loginK = new LoginK();
        normalAS = new NormalAS();
        adminAS = new AdminAS();

    }
    public void oeffne() {
        boolean success = false;
        boolean pAdmin = true;
        do{
            String username = Eingabe.eingeben("Bitte geben Sie den Benutzernamen ein: ");
            String password = Eingabe.eingeben("Bitte geben Sie das Passwort ein: ");
            if(username.equals("abbruch") || password.equals("abbruch")) {
                return;
            }
            String admin;
            do {
                admin = Eingabe.eingeben("Sind sie ein Admin? [J/N]");
                pAdmin = admin.equals("J");
                if(admin.equals("abbruch")) {
                    return;
                }
            }while(!admin.equals("J") && !admin.equals("N"));
            success = loginK.pruefeLogin(username, password, pAdmin);
            if(!success) {
                System.out.println("Das Passwort, der Benutzername oder der Adminstatus ist falsch");
            }
        } while(!success);
        if(pAdmin) {
            adminAS.oeffnen();
        } else {
            normalAS.oeffnen();
        }
    }
}
