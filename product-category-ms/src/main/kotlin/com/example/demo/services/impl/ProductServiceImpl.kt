package com.example.demo.services.impl

import com.example.demo.dtos.ProductDTO
import com.example.demo.entities.Product
import com.example.demo.mapper.impl.ProductMapper
import com.example.demo.repositories.ProductRepository
import org.springframework.stereotype.Service


@Service
class ProductServiceImpl( repository: ProductRepository, productMapper: ProductMapper) : GenericServiceImp<ProductDTO, Product, ProductRepository, ProductMapper>(
    repository,productMapper
)