package ra.edu.repo;

import org.springframework.stereotype.Repository;
import ra.edu.model.Data;
import ra.edu.model.Product;

import java.util.List;

@Repository
public class ProductRepo {
    public List<Product> getProductsList() {
        return Data.productsList;
    }
}
