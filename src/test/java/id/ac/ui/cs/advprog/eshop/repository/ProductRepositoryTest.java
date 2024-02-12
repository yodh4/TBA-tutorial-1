package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;
    @BeforeEach
    void setUp() {

    }
    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductID("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductID(), savedProduct.getProductID());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductID("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductID("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductID(), savedProduct.getProductID());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductID(), savedProduct.getProductID());
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindProductById() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductName("Batu Karang Merah");
        product3.setProductQuantity(25);
        productRepository.create(product3);

        assertEquals(product3, productRepository.findById("3"));
        assertEquals(product2, productRepository.findById("2"));
        assertEquals(product1, productRepository.findById("1"));
        assertNotEquals(product3, productRepository.findById("2"));
    }

    @Test
    void testFindProductByIdIfEmpty() {
        assertNull(productRepository.findById("1"));
        assertNull(productRepository.findById("2"));
    }

    @Test
    void testUpdateProduct() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product tempProduct1 = new Product();
        tempProduct1.setProductName("Sampo Cap Tohir");
        tempProduct1.setProductQuantity(200);
        productRepository.update(product1.getProductID(), tempProduct1);

        assertEquals("Sampo Cap Tohir", product1.getProductName());
        assertEquals(200, product1.getProductQuantity());
        assertNotEquals("Sampo Cap Bambang", product1.getProductName());
        assertNotEquals(100, product1.getProductQuantity());
        assertNull(productRepository.findById(tempProduct1.getProductID()));

        tempProduct1.setProductName("Sampo Cap Badak");
        tempProduct1.setProductQuantity(-1293);
        productRepository.update(product1.getProductID(), tempProduct1);

        assertEquals("Sampo Cap Badak", product1.getProductName());
        assertEquals(-1293, product1.getProductQuantity());
        assertNotEquals("Sampo Cap Tohir", product1.getProductName());
        assertNotEquals(200, product1.getProductQuantity());
        assertNull(productRepository.findById(tempProduct1.getProductID()));
    }

    @Test
    void testUpdateIfProductNotExist() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Babang");
        product2.setProductQuantity(-100);
        productRepository.create(product2);

        Product tempProduct1 = new Product();
        tempProduct1.setProductName("Sampo Cap Tohir");
        tempProduct1.setProductQuantity(200);
        productRepository.update(product1.getProductID(), tempProduct1);

        assertNull(productRepository.update(product1.getProductID(), tempProduct1));
        assertNull(productRepository.findById(product1.getProductID()));
    }

    @Test
    void testUpdateIfRepositoryIsEmpty() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);

        Product tempProduct1 = new Product();
        tempProduct1.setProductName("Sampo Cap Tohir");
        tempProduct1.setProductQuantity(200);

        assertNull(productRepository.update(product1.getProductID(), tempProduct1));
    }

    @Test
    void testDeleteIfProductExist() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Imin");
        product1.setProductQuantity(200);
        productRepository.create(product1);

        assertEquals(product1, productRepository.findById(product1.getProductID()));
        assertEquals(product1, productRepository.delete(product1.getProductID()));
        assertNull(productRepository.findById(product1.getProductID()));
    }

    @Test
    void testDeleteIfProductNotExist() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Imin");
        product1.setProductQuantity(200);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductName("Sampo Cap Kambing");
        product2.setProductQuantity(-2000);
        productRepository.create(product2);

        Product product3 = new Product();
        product3.setProductName("Sampo Cap Kaki Tiga");
        product3.setProductQuantity(-2000);

        assertEquals(product1, productRepository.findById(product1.getProductID()));
        assertEquals(product2, productRepository.findById(product2.getProductID()));
        assertNull(productRepository.delete(product3.getProductID()));
        assertNull(productRepository.delete("10"));
    }

    @Test
    void testDeleteIfRepositoryIsEmpty() {
        Product product1 = new Product();
        product1.setProductName("Sampo Cap Imin");
        product1.setProductQuantity(200);

        assertNull(productRepository.delete(product1.getProductID()));
    }
}

