import java.util.List;

public class Main {

    public static void main(String[] args){

        ProductDAO dao = new ProductDAO();

        // Adding product (can be removed after testing)
        Product p1 = new Product(1, "Laptop", 60000);
        dao.addProduct(p1);

        // Fetch all products
        List<Product> products = dao.getAllProducts();

        for(Product p : products){
            System.out.println(p.getName() + " - " + p.getPrice());

            // Multithreading
            OrderThread t1 = new OrderThread(p);
            t1.start();
        }
    }
}
