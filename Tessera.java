public class Tessera{

    private int idTessera;
    private double saldoTessera;
    public Tessera(int idTessera, double saldoTessera) {
        this.idTessera = idTessera;
        this.saldoTessera = saldoTessera;
    }
    public int getIdTessera() {
        return idTessera;
    }
    public void setIdTessera(int idTessera) {
        this.idTessera = idTessera;
    }
    public double getSaldoTessera() {
        return saldoTessera;
    }
    public void setSaldoTessera(double saldoTessera) {
        this.saldoTessera = saldoTessera;
    }
    
    void ricaricaSaldo(double ricarica) {
        System.out.println("Saldo iniziale : " + saldoTessera);
        saldoTessera += ricarica;
        System.out.println("Saldo aggiornato : " + saldoTessera);
    }

    double verificaSaldo() {
        return saldoTessera;
    }

}
