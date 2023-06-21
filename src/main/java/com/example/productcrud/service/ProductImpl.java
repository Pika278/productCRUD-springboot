package com.example.productcrud.service;

import com.example.productcrud.entity.ProductEntity;
import com.example.productcrud.model.ProductModel;
import com.example.productcrud.repository.CategoryRepository;
import com.example.productcrud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductImpl {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
    public List<ProductModel> getAllProduct() {
        List<ProductEntity> productEntityList = productRepository.findAll();
        List<ProductModel> productModelList = new ArrayList<>();

        productEntityList.forEach(productEntity -> {
            ProductModel productModel = new ProductModel();
            productEntityToProductModel(productEntity,productModel);
            productModelList.add(productModel);
        });

    return productModelList;
    }

    public List<ProductModel> findProductByName(String keyword) {
        List<ProductEntity> productList = productRepository.findAll();
        List<ProductModel> productModelList = new ArrayList<>();
        productList.forEach(productEntity -> {
            String productName = productEntity.getName().toLowerCase();
            String productSearch = keyword.toLowerCase();
            if(productName.contains(productSearch)) {
                ProductModel productModel = new ProductModel();
                productEntityToProductModel(productEntity,productModel);
                productModelList.add(productModel);
            }
        });
        return productModelList;
    }

    public void addProduct(ProductModel productModel) {
            ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productModel.getName());
            productEntity.setCategoryID(productModel.getCategory());
            productEntity.setPrice(productModel.getPrice());
            productEntity.setDescription(productModel.getDescription());
        productRepository.save(productEntity);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private void productEntityToProductModel(ProductEntity productEntity, ProductModel productModel) {
        productModel.setId(productEntity.getId());
        productModel.setName(productEntity.getName());
        productModel.setDescription(productEntity.getDescription());
        productModel.setPrice(productEntity.getPrice());
        productModel.setCategory(categoryRepository.findById(productEntity.getCategoryID()).get().getId());
    }
}
