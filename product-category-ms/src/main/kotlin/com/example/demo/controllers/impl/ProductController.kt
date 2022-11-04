package com.example.demo.controllers.impl

import com.example.demo.dtos.ProductDTO
import com.example.demo.services.impl.ProductServiceImpl
import io.swagger.annotations.Api

import org.springframework.web.bind.annotation.*


@CrossOrigin("*")
@RestController
@RequestMapping( "products")
@Api(description = "Product APIs")
class ProductController(
    service : ProductServiceImpl
) : BaseController<ProductDTO, ProductServiceImpl>(
    service
) {
}