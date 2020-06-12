package Services;

import Models.Order;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.ArrayList;

public class OrderServices {
    private static ArrayList<Order> orders = new ArrayList<>();

    public static void loadOrders(){

    }

    public static void writeOrders(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/main/resources/orders.json");

            JSONArray ja = new JSONArray();

            for(Order o:orders){
                JSONObject jo = new JSONObject();

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
