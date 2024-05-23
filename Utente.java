import java.util.Scanner;

public class Utente extends Tessera{
    private String nomeUtente;
    private String passwordUtente;

    Scanner scanner = new Scanner(System.in);

    public Utente(int idTessera, double saldoTessera, String nomeUtente, String passwordUtente) {
        super(idTessera, saldoTessera);
        this.nomeUtente = nomeUtente;
        this.passwordUtente = passwordUtente;
    }
    public String getNomeUtente() {
        return nomeUtente;
    }
    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }
    public String getPasswordUtente() {
        return passwordUtente;
    }
    public void setPasswordUtente(String passwordUtente) {
        this.passwordUtente = passwordUtente;
    }
}
