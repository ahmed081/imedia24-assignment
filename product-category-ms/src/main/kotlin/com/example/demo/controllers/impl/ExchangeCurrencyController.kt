package com.example.demo.controllers.impl

import com.example.demo.controllers.IExchangeCurrencyController
import com.example.demo.dtos.Currency
import com.example.demo.dtos.ProductDTO
import com.example.demo.dtos.ResponseDTO
import com.example.demo.services.ICurrencyService
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@CrossOrigin("*")
@RestController
@RequestMapping("currencies")
class ExchangeCurrencyController (
    var currencyService : ICurrencyService
): IExchangeCurrencyController {

    @ApiOperation(value = "To exchange currency")
    @PatchMapping("/exchange")
    override fun exchange(@RequestParam target: String, @RequestParam productId: Long,@RequestBody product: ProductDTO): ResponseEntity<ResponseDTO<ProductDTO>> {
        val data :ProductDTO= currencyService.exchange(target,productId,product)
        return ResponseEntity(
            ResponseDTO(true,data,null,"Success")
            ,HttpStatus.OK);
    }

    @ApiOperation(value = "To get all currencies")
    @GetMapping()
    override fun getCurrencies(): ResponseEntity<ResponseDTO<Currency>> {
        val listCurrency :Currency? = currencyService.getCurrencies()
        return ResponseEntity(
            ResponseDTO(true,listCurrency,null,"Success")
            ,HttpStatus.OK);
    }


}