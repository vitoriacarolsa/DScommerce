package com.devSuperior.dscommerce.repositories;
import com.devSuperior.dscommerce.entities.Order;
import com.devSuperior.dscommerce.entities.OrderItem;
import com.devSuperior.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
