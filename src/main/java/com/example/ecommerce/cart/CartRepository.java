package com.example.ecommerce.cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
  @Query("SELECT c FROM Cart c JOIN FETCH c.items WHERE c.id = :id")
  Cart findCartWithItems(@Param("id") Long id);
}
