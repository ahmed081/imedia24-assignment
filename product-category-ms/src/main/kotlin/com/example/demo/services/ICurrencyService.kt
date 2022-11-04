package com.example.demo.services

import com.example.demo.dtos.ProductDTO

interface ICurrencyService {

    /**
     * to exchange currency
     * @author Ahmed EL ASSIMI
     * @param target
     * @param productId
     * @param productDTO
     * @return ProductDTO
     */
    fun exchange(target:String, productId: Long,productDTO: ProductDTO): ProductDTO


    /**
     * to get all currencies
     * @author Ahmed EL ASSIMI
     * @return Map<String,String>
     */
    fun getCurrencies(): Map<String,String>?
}