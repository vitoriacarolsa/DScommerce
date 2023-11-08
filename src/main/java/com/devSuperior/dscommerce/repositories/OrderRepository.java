package com.devSuperior.dscommerce.repositories;
import com.devSuperior.dscommerce.entities.Order;
import com.devSuperior.dscommerce.entities.User;
import com.devSuperior.dscommerce.projections.UserDetailsProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
