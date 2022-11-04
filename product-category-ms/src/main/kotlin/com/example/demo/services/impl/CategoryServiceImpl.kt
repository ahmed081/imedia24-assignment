package com.example.demo.services.impl

import com.example.demo.dtos.CategoryDTO
import com.example.demo.entities.Category
import com.example.demo.mapper.impl.CategoryMapper
import com.example.demo.repositories.CategoryRepository
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl( repository: CategoryRepository, categoryMapper: CategoryMapper) : GenericServiceImp<CategoryDTO, Category, CategoryRepository, CategoryMapper>(
    repository,categoryMapper
) {

}