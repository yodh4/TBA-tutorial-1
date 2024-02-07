package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();
    static long ID = 0;

    public Product create(Product product) {
        product.setProductID(Long.toString(ID));
        ID++;
        productData.add(product);
        printAllProducts();
        return product;
    }

    public Product update(String productId, Product updatedProduct) {
        Product product = findById(productId);
        product.setProductName(updatedProduct.getProductName());
        product.setProductQuantity(updatedProduct.getProductQuantity());
        return product;
    }

    public Product delete(String productID) {
        Product product = findById(productID);
        productData.remove(product);
        return product;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    public Product findById(String id) {
        for (Product product : productData) {
            if (product.getProductID().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void printAllProducts() {
        System.out.println("List of Products:");
        for (Product product : productData) {
            System.out.println("Product ID: " + product.getProductID());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Product Quantity: " + product.getProductQuantity());
            System.out.println("------------------------");
        }
    }
}
