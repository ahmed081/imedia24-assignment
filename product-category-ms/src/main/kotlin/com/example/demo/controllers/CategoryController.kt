package com.example.demo.controllers

import com.example.demo.entities.Category
import com.example.demo.services.interfaces.ICategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping( "categories")
class CategoryController : BaseController<Category> {


    @Autowired
    lateinit var categoryService: ICategoryService


    /**
     * @author ahmed
     */
    @GetMapping("/{id}")
    override fun getOneById(id: Long): Category {
        return categoryService.getOneById(id);
    }


    @GetMapping
    override fun getAll(): List<Category> {
        return categoryService.getAll();
    }


    @PostMapping
    override fun addOne(@RequestBody dto: Category): Category {
        return categoryService.addOne(dto);
    }

    @PutMapping
    override fun updateOne(@RequestBody dto: Category): Category {

        return categoryService.updateOne(dto)
    }

    @DeleteMapping("/{id}")
    override fun deleteOne(@PathVariable id: Long): Category {
        return categoryService.deleteOne(id)
    }
}