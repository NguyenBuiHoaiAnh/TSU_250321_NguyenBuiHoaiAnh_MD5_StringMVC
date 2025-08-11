package ra.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.edu.model.CartItems;
import ra.edu.model.Product;
import ra.edu.repo.ProductRepo;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProductList() {
        return productRepo.getProductList();
    }

    // Cart Items
    public boolean addCartItems(CartItems cartItems) {
        return productRepo.addCartItems(cartItems);
    }

    public Product getProduct(String name) {
        return productRepo.getProduct(name);
    }

    public List<CartItems> getCartItemsList() {
        return productRepo.getCartItemsList();
    }

}
