package com.example.nasilemakapi.controller;

import com.example.nasilemakapi.client.RiceOrderClient;
import com.example.nasilemakapi.dto.RiceOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/nasi-goreng")
public class NasiGorengRetrievalController {

    private final RiceOrderClient riceOrderClient;

    public NasiGorengRetrievalController(RiceOrderClient riceOrderClient) {
        this.riceOrderClient = riceOrderClient;
    }

    /**
     * Retrieves all nasi goreng orders by calling the external endpoint via RestClient
     * 
     * @return ResponseEntity containing list of all rice orders
     */
    @GetMapping("/retrieve-orders")
    public ResponseEntity<List<RiceOrderResponse>> retrieveAllNasiGorengOrders() {
        List<RiceOrderResponse> orders = riceOrderClient.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    /**
     * Retrieves a specific nasi goreng order by ID via RestClient
     * 
     * @param orderId The ID of the order to retrieve
     * @return ResponseEntity containing the requested rice order
     */
    @GetMapping("/retrieve-orders/{orderId}")
    public ResponseEntity<RiceOrderResponse> retrieveNasiGorengOrderById(@PathVariable String orderId) {
        RiceOrderResponse order = riceOrderClient.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }
}

