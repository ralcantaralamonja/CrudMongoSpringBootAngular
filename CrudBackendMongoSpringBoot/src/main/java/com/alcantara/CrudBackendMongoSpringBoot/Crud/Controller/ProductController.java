package com.alcantara.CrudBackendMongoSpringBoot.Crud.Controller;

import com.alcantara.CrudBackendMongoSpringBoot.Crud.Dto.ProductDTO;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Entity.Product;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Service.IProductService;
import com.alcantara.CrudBackendMongoSpringBoot.Global.Exceptions.AttributeException;
import com.alcantara.CrudBackendMongoSpringBoot.Global.Exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    IProductService productService;
    @GetMapping("/all")
    public ResponseEntity<List<Product>>getAll(){
        List<Product>products = productService.getAll();
        return ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product>getOne(@PathVariable Long id) throws ResourceNotFound {
        Product product = productService.getOne(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Optional<Product>>getOneProduct(@PathVariable Long id) throws ResourceNotFound {
        Optional<Product> product = productService.getOneProduct(id);
        return ResponseEntity.ok(product);
    }
    @PostMapping("/create")
    public ResponseEntity<Product>postSaveProduct(@RequestBody ProductDTO dto) throws AttributeException {
        return ResponseEntity.ok(productService.postSaveProduct(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product>putProduct(@PathVariable Long id,@RequestBody ProductDTO dto) throws ResourceNotFound, AttributeException {
        return ResponseEntity.ok(productService.putProduct(id,dto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Product>deleteProduct(@PathVariable Long id) throws ResourceNotFound {
        Product product = productService.deleteProduct(id);
        return ResponseEntity.ok(product);
    }
}
