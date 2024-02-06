package com.alcantara.CrudBackendMongoSpringBoot.Crud.Repository;

import com.alcantara.CrudBackendMongoSpringBoot.Crud.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends MongoRepository<Product,Long> {
    boolean existsByDescription(String description);
    Optional<Product>findByDescription(String description);
}
