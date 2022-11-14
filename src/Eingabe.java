import java.util.Scanner;

public class Eingabe {
    public static String eingeben(String eingabeAufforderung) {
        System.out.println(eingabeAufforderung);
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public static void abbruchInfo() {
        System.out.println("Zum Verlassen des Programms bitte geben Sie \"abbruch\" ein.");
    }
}
