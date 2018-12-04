package io.blueharvest.training.ms.inventoryservice.inventory.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.blueharvest.training.ms.inventoryservice.inventory.domain.entity.Product;
import io.blueharvest.training.ms.inventoryservice.inventory.domain.model.ReservationResponse;
import io.blueharvest.training.ms.inventoryservice.inventory.service.InventoryService;

@RequestMapping("/api/inventory-service")
@RestController
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @PostMapping(path = "/products")
    public void addProduct(@RequestBody Product product) {
        inventoryService.add(product);
    }

    @GetMapping(path = "/products")
    public List<Product> getProducts() {
        return inventoryService.getAllProducts();
    }

    @PostMapping(path = "/products/{product-name}/reservations")
    public ReservationResponse reserveProduct(@PathVariable("product-name") String productName) {
        return new ReservationResponse(inventoryService.reserve(productName));
    }

    @DeleteMapping("/products/reservations/{reservation-code}")
    public void dispense(@PathVariable("reservation-code") String reservationCode) {
        inventoryService.dispense(reservationCode);
    }

}
