package io.blueharvest.training.ms.inventoryservice.inventory.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.blueharvest.training.ms.inventoryservice.inventory.domain.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    Product getFirstByNameAndReservationCodeIsNull(String name);

    void deleteByReservationCode(String reservationCode);

}
