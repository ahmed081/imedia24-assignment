package com.example.demo.services.implementations

import com.example.demo.mapper.ProductMapper
import com.example.demo.entities.Category
import com.example.demo.services.interfaces.ICategoryService
import org.mapstruct.factory.Mappers
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl : ICategoryService {
    override fun getOneById(id: Long): Category {
        TODO("Not yet implemented")
        var converter = Mappers.getMapper(ProductMapper::class.java)
    }

    override fun getAll(): List<Category> {
        TODO("Not yet implemented")
    }
}