package com.example.demo.controllers

import com.example.demo.dtos.Currency
import com.example.demo.dtos.ProductDTO
import com.example.demo.dtos.ResponseDTO
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity

interface IExchangeCurrencyController {

    fun exchange(target:String, productId: Long, product: ProductDTO):ResponseEntity<ResponseDTO<ProductDTO>>

    fun getCurrencies(): ResponseEntity<ResponseDTO<Currency>>
}