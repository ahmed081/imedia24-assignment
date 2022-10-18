package com.example.demo.services.implementations

import com.example.demo.entities.Product
import com.example.demo.services.interfaces.IProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl : IProductService {
    override fun getProductByCategory(idCategory: Long): List<Product> {
        TODO("Not yet implemented")
    }

    override fun getOneById(id: Long): Product {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Product> {
        TODO("Not yet implemented")
    }
}