package com.example.demo.controllers

import com.example.demo.dtos.ProductDTO
import com.example.demo.entities.Product
import com.example.demo.services.implementations.ProductServiceImpl
import com.example.demo.services.interfaces.IProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping( "products")
class ProductController : BaseController<Product> {

    @Autowired
    lateinit var productService: IProductService



    @GetMapping("/{id}")
    override fun getOneById(id: Long): Product {
        return productService.getOneById(id);
    }


    @GetMapping()
    override fun getAll(): List<Product> {
        return productService.getAll();
    }


    @GetMapping("/{categoryId}")
    fun getProductByCategory(categoryId: Long): List<Product> {
        return productService.getProductByCategory(categoryId);
    }

    @PostMapping()
    override fun addOne(@RequestBody dto: Product): Product {
        return productService.addOne(dto);
    }

    @PutMapping("/{id}")
    override fun updateOne(@RequestBody dto: Product): Product {

        return productService.updateOne(dto)
    }

    @DeleteMapping("/{id}")
    override fun deleteOne(id: Long): Product {
        return productService.deleteOne(id)
    }
}