package com.example.demo.repositories

import com.example.demo.entities.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface  CategoryRepository : JpaRepository<Category,Long> {
}