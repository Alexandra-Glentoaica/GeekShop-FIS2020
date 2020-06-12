package Services;

import Models.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ProductServices {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void loadProducts(){
        try{
            products = new ArrayList<>();

            JSONParser jp = new JSONParser();
            FileReader fr = new FileReader("src/main/resources/products.json");
            Object obj = jp.parse(fr);
            JSONArray ja = (JSONArray) obj;

            for(Object product:ja){
                JSONObject jo = (JSONObject) product;

                String type = jo.get("type").toString();

                if(type.equals("Books")){
                    String name = jo.get("name").toString();
                    int price = Integer.parseInt(jo.get("price").toString());
                    int quantity = Integer.parseInt(jo.get("quantity").toString());
                    String author = jo.get("author").toString();
                    String language = jo.get("language").toString();
                    String publisher = jo.get("publisher").toString();

                    Book b = new Book(name,price,type,quantity,author,language,publisher);
                    products.add(b);
                }else {
                    String name = jo.get("name").toString();
                    int price = Integer.parseInt(jo.get("price").toString());
                    int quantity = Integer.parseInt(jo.get("quantity").toString());
                    String material = jo.get("material").toString();
                    String color = jo.get("color").toString();
                    String size = jo.get("size").toString();

                    Item i = new Item(name,price,type,quantity,material,color,size);
                    products.add(i);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void writeProducts(){
        FileWriter fw = null;
        try{
            fw = new FileWriter("src/main/resources/products.json");

            JSONArray ja = new JSONArray();

            for(Product p:products){
                JSONObject jo = new JSONObject();

                jo.put("name", p.getName());
                jo.put("price", p.getPrice());
                jo.put("type", p.getType());
                jo.put("quantity", p.getQuantity());
                if(p.getType().equals("Books")){
                    jo.put("author", ((Book)p).getAuthor());
                    jo.put("language", ((Book)p).getLanguage());
                    jo.put("publisher", ((Book)p).getPublisher());
                }else{
                    jo.put("material", ((Item)p).getMaterial());
                    jo.put("color", ((Item)p).getColor());
                    jo.put("size", ((Item)p).getSize());
                }

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

    public static ArrayList<Product> getProducts() {
        return products;
    }
}
