package Services;

import Models.Client;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Base64;

public class ClientServices {
    private static String path;
    private static ArrayList<Client> clients;

    public static void loadClients() {
        try{
            clients = new ArrayList<>();

            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader(path);
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray) obj;

            for(Object client:ja){
                JSONObject jo = (JSONObject) client;
                clients.add(new Client(jo.get("username").toString(), jo.get("password").toString(), jo.get("role").toString()));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static String encodePassword(String password){
        String result = Base64.getEncoder().encodeToString(password.getBytes());

        return result;
    }

    public static void writeClients() {
        FileWriter fw = null;
        try {
            fw = new FileWriter(path);

            JSONArray ja = new JSONArray();

            for(Client i:clients){
                JSONObject jo = new JSONObject();

                jo.put("username", i.getUsername());
                jo.put("password", i.getPassword());
                jo.put("role", i.getRole());

                ja.add(jo);
            }

            fw.write(ja.toJSONString());
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try{
                fw.flush();
                fw.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static void setClients(ArrayList<Client> clients) {
        ClientServices.clients = clients;
    }

    public static void setPath(String path) {
        ClientServices.path = path;
    }
}
