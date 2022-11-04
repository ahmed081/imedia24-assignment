package com.example.demo.controllers.impl

import com.example.demo.controllers.IExchangeCurrencyController
import com.example.demo.dtos.ProductDTO
import com.example.demo.services.ICurrencyService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
@CrossOrigin("*")
@RestController
@RequestMapping("currencies")
class ExchangeCurrencyController (
    var currencyService : ICurrencyService
): IExchangeCurrencyController {

    @ApiOperation(value = "To exchange currency")
    @PatchMapping("/exchange")
    override fun exchange(@RequestParam target: String, @RequestParam productId: Long,@RequestBody product: ProductDTO): ProductDTO {
        return currencyService.exchange(target,productId,product)
    }

    @ApiOperation(value = "To get all currencies")
    @GetMapping()
    override fun getCurrencies(): Map<String, String> ?{
        return currencyService.getCurrencies()
    }


}