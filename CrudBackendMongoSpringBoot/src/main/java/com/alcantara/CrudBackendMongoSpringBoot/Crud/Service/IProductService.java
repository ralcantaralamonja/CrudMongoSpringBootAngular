package com.alcantara.CrudBackendMongoSpringBoot.Crud.Service;

import com.alcantara.CrudBackendMongoSpringBoot.Crud.Dto.ProductDTO;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Entity.Product;
import com.alcantara.CrudBackendMongoSpringBoot.Global.Exceptions.ResourceNotFound;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    public List<Product> getAll();
    public Product getOne(Long id) throws ResourceNotFound;
    public Optional<Product>getOneProduct(Long id) throws ResourceNotFound;
    public Product postSaveProduct(ProductDTO dto);
    public Product putProduct(Long id ,ProductDTO dto) throws ResourceNotFound;
    public Product deleteProduct(Long id) throws ResourceNotFound;
}
