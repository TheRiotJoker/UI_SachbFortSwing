import java.util.Scanner;

public class Auswaehlen {
    static String waehleAus(String[] alternativen) {
        Scanner scan = new Scanner(System.in);
        String rueckgabe = null;
        int wahl = -1;
        for(int i = 0; i < alternativen.length; i++) {
            System.out.println((i+1)+" "+alternativen[i]);
        }
        do {
            wahl = -1;
            String eingabe = Eingabe.eingeben("Bitte geben Sie die gewünschte Nummer ein: ");
            if(eingabe.length() == 0) { //dieses IF ist nicht notwendig, aber ich habs hier drin wegen der aufgabenstellung
                //eigentlich wird alles von dem try catch block überprüft, darunter fällt auch leere eingabe rein... oh well
                System.out.println("Kein Index eingegeben.");
            } else {
                try {
                    wahl = Integer.parseInt(eingabe);
                    rueckgabe = alternativen[wahl-1];
                } catch(NumberFormatException | IndexOutOfBoundsException e) {
                    System.out.println("Ungültigen Index eingegeben");
                    System.out.println("Bitte Eingabe wiederholen.");
                }
            }
        }while(rueckgabe == null);

        return rueckgabe;
    }
}
