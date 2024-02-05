package com.alcantara.CrudBackendMongoSpringBoot.Crud.Repository;

import com.alcantara.CrudBackendMongoSpringBoot.Crud.Entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends MongoRepository<Product,Long> {
}
