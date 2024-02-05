package com.alcantara.CrudBackendMongoSpringBoot.Crud.Controller;

import com.alcantara.CrudBackendMongoSpringBoot.Crud.Dto.ProductDTO;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Entity.Product;
import com.alcantara.CrudBackendMongoSpringBoot.Crud.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<Product>getOne(@PathVariable Long id){
        Product product = productService.getOne(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<Product>getOneProduct(@PathVariable Long id){
        Product product = productService.getOneProduct(id).get();
        return ResponseEntity.ok(product);
    }
    @PostMapping("/create")
    public ResponseEntity<Product>postSaveProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.postSaveProduct(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product>putProduct(@PathVariable Long id,@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.putProduct(id,dto));
    }
}
