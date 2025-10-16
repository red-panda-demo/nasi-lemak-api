package com.example.nasilemakapi.client;

import com.example.nasilemakapi.dto.RiceOrderResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class RiceOrderClient {

    private final RestClient restClient;

    public RiceOrderClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("http://localhost:8080")
                .build();
    }

    /**
     * Retrieves all nasi goreng orders from the external API
     * @return List of RiceOrderResponse objects
     */
    public List<RiceOrderResponse> getAllOrders() {
        return restClient.get()
                .uri("/api/v1/orders")
                .retrieve()
                .body(new ParameterizedTypeReference<List<RiceOrderResponse>>() {});
    }

    /**
     * Retrieves a specific nasi goreng order by ID from the external API
     * @param orderId The order ID to retrieve
     * @return RiceOrderResponse object
     */
    public RiceOrderResponse getOrderById(String orderId) {
        return restClient.get()
                .uri("/api/v1/orders/{orderId}", orderId)
                .retrieve()
                .body(RiceOrderResponse.class);
    }
}

