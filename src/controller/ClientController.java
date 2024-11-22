package controller;

import modele.Client;
import modele.Compte;
import modele.Cheque;
import modele.Epargne;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ClientController {
    private List<Client> clients;

    public ClientController() {
        this.clients = new ArrayList<>();
    }

    public void ajouterClient(String nom, String prenom) {
        Client client = new Client(nom, prenom);
        clients.add(client);
        System.out.println("Client ajouté : " + nom + " " + prenom);
    }

    public void listerClients() {
        if (clients.isEmpty()) {
            System.out.println("Aucun client enregistré.");
        } else {
            System.out.println("Liste des clients :");
            for (Client client : clients) {
                System.out.println("ID: " + client.getId() + " - Nom: " + client.getNom() + " " + client.getPrenom());
            }
        }
    }

    public void creerCompte(int clientId, String typeCompte, int solde, Date dateBlocage, Date finBlocage, String taux, int frais) {
        Client client = trouverClientParId(clientId);
        if (client == null) {
            System.out.println("Client introuvable !");
            return;
        }

        Compte compte;
        if ("Epargne".equalsIgnoreCase(typeCompte)) {
            compte = new Epargne(solde, client, dateBlocage, finBlocage, taux);
        } else if ("Cheque".equalsIgnoreCase(typeCompte)) {
            compte = new Cheque(solde, client, frais);
        } else {
            System.out.println("Type de compte invalide !");
            return;
        }

        client.ajouterCompte(compte);
        System.out.println("Compte " + typeCompte + " créé pour le client " + client.getNom() + ".");
    }

    public void listerComptesClient(int clientId) {
        Client client = trouverClientParId(clientId);
        if (client == null) {
            System.out.println("Client introuvable !");
            return;
        }

        List<Compte> comptes = client.getComptes();
        if (comptes.isEmpty()) {
            System.out.println("Aucun compte enregistré pour ce client.");
        } else {
            System.out.println("Comptes du client " + client.getNom() + " :");
            for (Compte compte : comptes) {
                System.out.println("Numéro: " + compte.getNumero() + ", Solde: " + compte.getSolde());
            }
        }
    }

    private Client trouverClientParId(int id) {
        for (Client client : clients) {
            if (client.getId() == id) {
                return client;
            }
        }
        return null;
    }
}
