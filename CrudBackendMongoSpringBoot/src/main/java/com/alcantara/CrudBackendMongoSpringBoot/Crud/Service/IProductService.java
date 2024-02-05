package com.alcantara.CrudBackendMongoSpringBoot.Crud.Service;

import com.alcantara.CrudBackendMongoSpringBoot.Crud.Entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> getAll();
    public Product getOne(Long id);
    public Optional<Product>getOneProduct(Long id);
}
