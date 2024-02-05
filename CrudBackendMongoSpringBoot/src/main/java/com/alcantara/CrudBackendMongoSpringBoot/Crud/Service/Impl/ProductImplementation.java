package com.alcantara.CrudBackendMongoSpringBoot.Crud.Service.Impl;

import com.alcantara.CrudBackendMongoSpringBoot.Crud.Entity.Product;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Repository.IProductRepository;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImplementation implements IProductService {
    @Autowired
    IProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Optional<Product> getOneProduct(Long id) {
        return productRepository.findById(id);
    }

}
