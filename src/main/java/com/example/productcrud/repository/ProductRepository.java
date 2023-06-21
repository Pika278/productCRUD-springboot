package com.example.productcrud.repository;

import com.example.productcrud.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    List<ProductEntity> findAllByCategoryID(Long categoryID);
    @Query("select categoryID from ProductEntity where id= :productId")
    Long findCategoryIdById(Long productId);
}
