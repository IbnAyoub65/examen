package views;

import controller.ClientController;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientController controller = new ClientController();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Ajouter un client");
            System.out.println("2. Lister les clients");
            System.out.println("3. Créer un compte");
            System.out.println("4. Lister les comptes d’un client");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Nom du client : ");
                    String nom = scanner.nextLine();
                    System.out.print("Prénom du client : ");
                    String prenom = scanner.nextLine();
                    controller.ajouterClient(nom, prenom);
                    break;

                case 2:
                    controller.listerClients();
                    break;

                case 3:
                    System.out.print("ID du client : ");
                    int clientId = scanner.nextInt();
                    System.out.print("Type de compte (Epargne/Cheque) : ");
                    String typeCompte = scanner.next();
                    System.out.print("Solde initial : ");
                    int solde = scanner.nextInt();

                    if ("Epargne".equalsIgnoreCase(typeCompte)) {
                        System.out.print("Date de blocage (YYYY-MM-DD) : ");
                        Date dateBlocage = Date.valueOf(scanner.next());
                        System.out.print("Date de fin blocage (YYYY-MM-DD) : ");
                        Date finBlocage = Date.valueOf(scanner.next());
                        System.out.print("Taux : ");
                        String taux = scanner.next();
                        controller.creerCompte(clientId, typeCompte, solde, dateBlocage, finBlocage, taux, 0);
                    } else if ("Cheque".equalsIgnoreCase(typeCompte)) {
                        System.out.print("Frais : ");
                        int frais = scanner.nextInt();
                        controller.creerCompte(clientId, typeCompte, solde, null, null, null, frais);
                    } else {
                        System.out.println("Type de compte invalide !");
                    }
                    break;

                case 4:
                    System.out.print("ID du client : ");
                    int clientIdComptes = scanner.nextInt();
                    controller.listerComptesClient(clientIdComptes);
                    break;

                case 0:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        } while (choix != 0);

        scanner.close();
    }
}
