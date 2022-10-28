package com.example.demo.services.implementations

import com.example.demo.entities.Category
import com.example.demo.repositories.CategoryRepository
import com.example.demo.services.interfaces.ICategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl : ICategoryService {
    @Autowired
    private lateinit var categoryRepository : CategoryRepository


    override fun getOneById(id: Long): Category {

        val category:Category = categoryRepository.getReferenceById(id)
        return category
    }

    override fun getAll(): List<Category> {
        val categories : List<Category> = categoryRepository.findAll();
//        return categories;
        return categories
    }

    override fun addOne(dto: Category): Category {
        categoryRepository.save(dto)
        return dto

    }

    override fun updateOne(dto: Category): Category {
        categoryRepository.save(dto)
        return dto
    }

    override fun deleteOne(id: Long): Category {
        val category:Category = categoryRepository.getReferenceById(id)
        categoryRepository.delete(category)
        return  category
    }
}