package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentTest {

    @Test
    void testIfPaymentMethodIsFalse() {
        Map<String, String> paymentData = new HashMap<>();
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Credit Card", "REJECTED", paymentData);
        assertFalse(payment.getMethod.equals("Voucher Code") || payment.getMethod.equals("Bank Transfer"));
        assertTrue(payment.getStatus.equals("REJECTED"));
    }

    @Test
    void testIfPaymentMethodIsTrue() {
        Map<String, String> paymentData = new HashMap<>();
        Payment payment = new Payment("13652556-012a-4c07-b546-54eb1396d79b",
                "Bank Transfer", "ACCEPTED", paymentData);
        assertTrue(payment.getMethod.equals("Voucher Code") || payment.getMethod.equals("Bank Transfer"));
    }
}
