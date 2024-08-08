package com.revature.celestial_emporium_backend.Stripe;

import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:5173")
public class StripeController {

    @Autowired
    private StripeService stripeService;

    @PostMapping("/create-payment-intent")
    public Map<String, Object> createPaymentIntent(@RequestBody Map<String, Object> paymentInfo) throws StripeException {
        Long amount = ((Number) paymentInfo.get("amount")).longValue();
        String currency = (String) paymentInfo.get("currency");

        return stripeService.createPaymentIntent(amount, currency);
    }
}
