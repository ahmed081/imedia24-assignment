package com.example.demo.controllers

import com.example.demo.dtos.ProductDTO
import org.springframework.beans.factory.annotation.Value

interface IExchangeCurrencyController {

    fun exchange(target:String, productId: Long, product: ProductDTO):ProductDTO

    fun getCurrencies():Map<String,String>?
}