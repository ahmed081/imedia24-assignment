package com.example.demo.controllers.impl

import com.example.demo.dtos.CategoryDTO
import com.example.demo.services.impl.CategoryServiceImpl
import io.swagger.annotations.Api

import org.springframework.web.bind.annotation.*

@CrossOrigin("*")
@RestController
@RequestMapping( "categories")
@Api(description = "Category APIs")
class CategoryController(
    service : CategoryServiceImpl
) : BaseController<CategoryDTO, CategoryServiceImpl>(
    service
) {
}