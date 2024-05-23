import java.util.ArrayList;
import java.util.Scanner;

public class Lavanderia {
    ArrayList<Utente> utentiRegistrati; 

    public Lavanderia() {
        utentiRegistrati = new ArrayList<>();
    }

    public boolean login(String name, String pass) {
        for(Utente utente : utentiRegistrati) {
            if(utente.getNomeUtente().equals(name)) {
                if(utente.getPasswordUtente().equals(pass)) {
                    System.out.println("Login riuscito!!");
                    return true;
                }
            }
        }
        System.out.println("Login non riuscito.");
        return false;
    } 

    void registrazioneUtente(Utente utente) {
        utentiRegistrati.add(utente);
    }
    
    static boolean verificaPanni(double numeroPanni) {
        if(numeroPanni>10) {
            return false;
        } else {
           return true; 
        }
    }

    static boolean controlloSaldo(Utente utente) {
        if(utente.getSaldoTessera()>20) {
            return true; //quindi  applica sconto
        }
        return false;
    }

    static double calcoloPrezzo(Utente utente, double numeroPanni){
        double prezzoFinale = 0;
        if(controlloSaldo(utente)) {
            prezzoFinale = numeroPanni/2;
        } 
        if(!controlloSaldo(utente)) {
            prezzoFinale = numeroPanni;
        }
        return prezzoFinale;
    }

    //metodo per stampare utenti registrati
    void stampaUtentiRegistrati() {
        for(Utente utente : utentiRegistrati) {
            System.out.println("Gli utenti registrati nella lavanderia sono : ");
            System.out.println("-" + utente.getNomeUtente());
        }
    }

    int generatoreIdTessera(int baseId) {
        baseId += 1;
        return baseId;
    }

    public static void main(String[] args) {
        Scanner scannerN = new Scanner(System.in);
        Scanner scannerS = new Scanner(System.in);
        System.out.println(" \nBENVENUTO NELLA LAVANDERIA!\n");
        Lavanderia lavanderia = new Lavanderia();
        int inizioIdTessera = 111;
        Utente nuovoUtente = null;

        boolean done = true;
        while (done) {
            System.out.println("Scegli l'opzione \n1)Registrazione \n2)Login \n3)Esci");
            int scelta = scannerN.nextInt();
            switch (scelta) {
                case 1:
                    System.out.println("Inserisci nome : ");
                    String nome = scannerS.nextLine();
                    System.out.println("Inserisci password : ");
                    String pass = scannerS.nextLine();
                    nuovoUtente = new Utente(lavanderia.generatoreIdTessera(inizioIdTessera), 0, nome, pass);
                    lavanderia.registrazioneUtente(nuovoUtente);
                    
                    break;
                case 2:
                    System.out.println("Inserisci nome : ");
                    String nomeLogin = scannerS.nextLine();
                    System.out.println("Inserisci password : ");
                    String passLogin = scannerS.nextLine();
                    lavanderia.login(nomeLogin, passLogin);
                    done = false;
                    break;
                case 3:
                    System.out.println("Arrivederci");
                    done = false;
                default:
                    System.out.println("Input non valido");
            } 
        }
        System.out.println("Quanti panni vuoi lavare ?");
        double numeroPanni = scannerN.nextDouble();
        if(verificaPanni(numeroPanni)) {
            
            System.out.println("Di quanto vuoi ricaricare il saldo tessera?");
            double aggiungiSaldo = scannerN.nextDouble();

            nuovoUtente.setSaldoTessera(aggiungiSaldo);
            double prezzoFinale = calcoloPrezzo(nuovoUtente, numeroPanni);
            System.out.println("Il totale alla cassa è : " + prezzoFinale);
        } else {
            System.out.println("Devi dividere in più lavatrici ");
            double numeroLavatrici = numeroPanni/10 + 1;
            int numLav = (int)numeroLavatrici;
            System.out.println("Stai usando " + numLav + " lavatrici");
            System.out.println("Il totale alla cassa è : " + calcoloPrezzo(nuovoUtente, numeroPanni));
        }
        
    }
}
