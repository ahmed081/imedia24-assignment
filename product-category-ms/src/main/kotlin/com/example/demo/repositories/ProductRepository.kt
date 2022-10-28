package com.example.demo.repositories

import com.example.demo.entities.Category
import com.example.demo.entities.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface  ProductRepository : JpaRepository<Product,Long> {
    fun findByCategoryId(category: Category): List<Product>;
}