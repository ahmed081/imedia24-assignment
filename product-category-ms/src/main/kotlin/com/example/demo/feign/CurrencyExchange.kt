package com.example.demo.feign

import com.example.demo.dtos.Currency
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@FeignClient(name = "Fixer", url = "http://data.fixer.io/api", configuration = [Currency::class])
interface CurrencyExchange {
    @GetMapping("/latest")
    fun getCurrency(
        @RequestParam access_key: String?,
        @RequestParam base: String?
    ): Currency?

    @GetMapping("/symbols")
    fun getCurrencies(
        @RequestParam access_key: String?
    ): Currency?
}
