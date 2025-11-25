import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public void addProduct(Product product){
        try{
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO products VALUES(?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());

            ps.executeUpdate();
            System.out.println("Product Added Successfully!");

        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();

        try{
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM products");

            while(rs.next()){
                products.add(new Product(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3)
                ));
            }

        }catch(Exception e){
            System.out.println(e);
        }
        return products;
    }
}
