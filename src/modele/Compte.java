package modele;

public class Compte {

    private static int compteurNumero = 1;
    protected int numero;
    protected int solde;
    private Client client;

    public Compte(int solde, Client client) {
        this.numero = compteurNumero++;
        this.solde = solde;
        this.client = client;
    }

    public Compte() {
        this.numero = compteurNumero++;
    }

    public int getNumero() {
        return numero;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
