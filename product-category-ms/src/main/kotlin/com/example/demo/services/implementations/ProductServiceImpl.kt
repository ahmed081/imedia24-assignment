package com.example.demo.services.implementations

import com.example.demo.entities.Category
import com.example.demo.entities.Product
import com.example.demo.repositories.CategoryRepository
import com.example.demo.repositories.ProductRepository
import com.example.demo.services.interfaces.IProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl : IProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository
    @Autowired
    private lateinit var categoryRepository: CategoryRepository

    override fun getProductByCategory(idCategory: Long): List<Product> {
        val category: Category =categoryRepository.getReferenceById(idCategory)
        val products : List<Product> = productRepository.findByCategoryId(category)
        return products
    }


    override fun getOneById(id: Long): Product {

        val product:Product = productRepository.getReferenceById(id)
        return product
    }

    override fun getAll(): List<Product> {
        val products : List<Product> = productRepository.findAll();

        return products
    }

    override fun addOne(dto: Product): Product {

            return productRepository.save(dto)
    }

    override fun updateOne(dto: Product): Product {
        productRepository.save(dto)
        return dto
    }

    override fun deleteOne(id: Long): Product {
        val product:Product = productRepository.getReferenceById(id)
        productRepository.delete(product)
        return  product
    }
}