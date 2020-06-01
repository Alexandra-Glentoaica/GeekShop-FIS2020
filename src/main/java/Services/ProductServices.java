package Services;

import Models.Book;
import Models.Client;
import Models.Item;
import Models.Product;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
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
                    String author = jo.get("author").toString();
                    String language = jo.get("language").toString();
                    String publisher = jo.get("publisher").toString();

                    Book b = new Book(name,price,type,author,language,publisher);
                    products.add(b);
                }else {
                    String name = jo.get("name").toString();
                    int price = Integer.parseInt(jo.get("price").toString());
                    String material = jo.get("material").toString();
                    String color = jo.get("color").toString();
                    String size = jo.get("size").toString();

                    Item i = new Item(name,price,type,material,color,size);
                    products.add(i);
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
}
