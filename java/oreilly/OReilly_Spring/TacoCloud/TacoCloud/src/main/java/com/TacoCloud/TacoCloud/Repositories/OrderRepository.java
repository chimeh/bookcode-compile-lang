package com.TacoCloud.TacoCloud.Repositories;

import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.TacoCloud.TacoCloud.Domain.Entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findByZip(String deliveryZip);

    List<Order> readOrdersByZipAndPlacedAtBetween(String zip, Date startDate, Date endDate);

}
