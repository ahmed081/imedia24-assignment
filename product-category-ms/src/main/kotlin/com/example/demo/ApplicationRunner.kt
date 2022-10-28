package com.example.demo

import com.example.demo.entities.Category
import com.example.demo.entities.Product
import com.example.demo.repositories.CategoryRepository
import com.example.demo.repositories.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*
import kotlin.random.Random

@SpringBootApplication
class ApplicationRunner {



	@Bean
	fun init(categoryRepository: CategoryRepository, productRepository: ProductRepository) = CommandLineRunner {
		// save a couple of customers

		categoryRepository.save(Category(0,"category 1"))
		categoryRepository.save(Category(0,"category 2"))
		categoryRepository.save(Category(0,"category 3"))
		categoryRepository.save(Category(0,"category 4"))
		categoryRepository.save(Category(0,"category 5"))
		categoryRepository.save(Category(0,"category 6"))

		categoryRepository.findAll().forEach{ category:Category ->
			productRepository.save(Product(0, Random.nextDouble()*100,UUID.randomUUID().toString(),12,Date(),Date(),category))
		}
	}

}

fun main(args: Array<String>) {
	runApplication<ApplicationRunner>(*args)
}
