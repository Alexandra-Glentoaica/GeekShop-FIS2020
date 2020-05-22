package Services;

import Models.Client;

import java.util.ArrayList;

public class ClientServices {
    private static ArrayList<Client> clients;

    public static void loadClients() {

    }

    public static void writeClients() {

    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static void setClients(ArrayList<Client> clients) {
        ClientServices.clients = clients;
    }
}
