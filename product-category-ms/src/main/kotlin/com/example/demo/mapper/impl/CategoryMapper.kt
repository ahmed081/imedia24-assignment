package com.example.demo.mapper.impl

import com.example.demo.dtos.CategoryDTO
import com.example.demo.entities.Category
import com.example.demo.mapper.IMapper
import org.springframework.stereotype.Service

@Service
class CategoryMapper : IMapper<CategoryDTO, Category> {

    override fun toDTO(entity: Category?): CategoryDTO {
        return CategoryDTO(
            entity?.id,
            entity?.nameCategory,
            entity?.descCategory
        )
    }

    override fun toListDTO(entities: List<Category>): List<CategoryDTO> {
        return entities.map { toDTO(it) }
    }

    override fun toEntity(dto: CategoryDTO?): Category {
        val category = Category()
        category.id = dto?.id
        category.nameCategory = dto?.nameCategory
        category.descCategory = dto?.descCategory
        return category
    }


}