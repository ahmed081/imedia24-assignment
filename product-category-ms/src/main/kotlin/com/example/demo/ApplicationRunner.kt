package com.example.demo

import com.example.demo.entities.Category
import com.example.demo.entities.Product
import com.example.demo.repositories.CategoryRepository
import com.example.demo.repositories.ProductRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import java.util.*
import kotlin.random.Random

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

class ApplicationRunner {



	@Bean
	fun init(categoryRepository: CategoryRepository, productRepository: ProductRepository) = CommandLineRunner {

		for (i in 1..10) {
			val category = Category()
			category.nameCategory = UUID.randomUUID().toString()
			category.descCategory = UUID.randomUUID().toString()
			categoryRepository.save(category)
		}

		categoryRepository.findAll().forEach{
			val product = Product()
			product.productPrice=String.format("%.2f",  Random.nextDouble()*100).toDouble()
			product.productName= UUID.randomUUID().toString()
			product.productQuantity= 12
			product.exchangeRate= 1.0
			product.currency= "EUR"
			product.againstValue= product.productPrice
			product.category= it
			productRepository.save(product)

		}
	}

}

fun main(args: Array<String>) {
	runApplication<ApplicationRunner>(*args)
}
