package com.example.productcrud.repository;

import com.example.productcrud.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<ProductEntity,Long> {
}
