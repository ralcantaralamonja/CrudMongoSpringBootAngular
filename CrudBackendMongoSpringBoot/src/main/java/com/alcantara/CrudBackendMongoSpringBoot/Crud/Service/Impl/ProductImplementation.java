package com.alcantara.CrudBackendMongoSpringBoot.Crud.Service.Impl;

import com.alcantara.CrudBackendMongoSpringBoot.Crud.Dto.ProductDTO;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Entity.Product;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Repository.IProductRepository;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Service.IProductService;
import com.alcantara.CrudBackendMongoSpringBoot.Global.Exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
    public Product getOne(Long id) throws ResourceNotFound {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Not found"));
    }

    @Override
    public Optional<Product> getOneProduct(Long id) throws ResourceNotFound {
        return Optional.ofNullable(productRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Nor found")));
    }

    @Override
    public Product postSaveProduct(ProductDTO dto) {
        Long id = autoIncremental();
        Product product = new Product(id,dto.getDescription(),dto.getPrice());
        return productRepository.save(product);
    }

    @Override
    public Product putProduct(Long id, ProductDTO dto) throws ResourceNotFound {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Not Found"));
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return productRepository.save(product);
    }

    @Override
    public Product deleteProduct(Long id) throws ResourceNotFound {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Not found"));
        productRepository.delete(product);
        return product;
    }

    //Metodo privado
    private Long autoIncremental(){
        List<Product> products = productRepository.findAll();
        return products.isEmpty() ? 1L :
                products.stream().max(Comparator.comparing(Product::getId))
                        .get().getId() + 1;
    }

}
