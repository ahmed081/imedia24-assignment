package com.example.demo.services.impl

import com.example.demo.dtos.Currency
import com.example.demo.dtos.ProductDTO
import com.example.demo.entities.Product
import com.example.demo.feign.CurrencyExchange
import com.example.demo.mapper.impl.ProductMapper
import com.example.demo.repositories.ProductRepository
import com.example.demo.services.ICurrencyService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service


@Service
class CurrencyService(
        @Value("\${access.key}")
        val accessKey: String?,
        @Value("\${base.currency}")
        val baseCurrency: String?,
        var currencyExchange: CurrencyExchange,
        var productService : ProductServiceImpl
    )
    : ICurrencyService {



    override fun exchange(target: String, productId: Long,productDTO: ProductDTO): ProductDTO {
        val product = productService.getOneById(productId)
        val currency : Currency? = currencyExchange.getCurrency(accessKey,baseCurrency)
        product.productPrice = productDTO.productPrice
        product.againstValue = currency?.rates?.get(target)?.times(product.productPrice!!)
        product.exchangeRate = currency?.rates?.get(target)
        product.currency = target

        return product
    }


    override fun getCurrencies(): Currency? {
        val currency: Currency? = currencyExchange.getCurrencies(accessKey)
        return currency
    }
}