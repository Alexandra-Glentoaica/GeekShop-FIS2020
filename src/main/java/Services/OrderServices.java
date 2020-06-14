package Services;

import Models.Order;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class OrderServices {
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void loadOrders(){
        try {
            orders=new ArrayList<>();
            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader("src/main/resources/orders.json");
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray) obj;

            for(Object order:ja){
                JSONObject jo = (JSONObject) order;
                orders.add(new Order(jo.get("id").toString(), jo.get("status").toString(), jo.get("product").toString(), Integer.parseInt(jo.get("quantity").toString()), jo.get("name").toString(), jo.get("address").toString(), jo.get("date").toString(), jo.get("payment").toString(), jo.get("cardNumber").toString(), jo.get("expirationDate").toString(), jo.get("cvv").toString()));
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void writeOrders(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/main/resources/orders.json");

            JSONArray ja = new JSONArray();

            for(Order o:orders){
                JSONObject jo = new JSONObject();

                jo.put("id",o.getId());
                jo.put("status",o.getStatus());
                jo.put("product",o.getProduct());
                jo.put("quantity",o.getQuantity());
                jo.put("name",o.getName());
                jo.put("address",o.getAddress());
                jo.put("date",o.getDate());
                jo.put("payment",o.getPayment());
                jo.put("cardNumber",o.getCardNumber());
                jo.put("expirationDate",o.getExpirationDate());
                jo.put("cvv",o.getCvv());

                ja.add(jo);
            }

            fw.write(ja.toJSONString());
        }catch(Exception e){
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

    public static ArrayList<Order> getOrders() {
        return orders;
    }
}
