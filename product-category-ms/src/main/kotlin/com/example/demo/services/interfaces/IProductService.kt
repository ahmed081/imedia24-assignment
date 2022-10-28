package com.example.demo.services.interfaces

import com.example.demo.dtos.ProductDTO
import com.example.demo.entities.Product

interface IProductService : IGenericService<Product>{

    fun getProductByCategory(idCategory:Long): List<Product>;

}