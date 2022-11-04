package com.example.demo.controllers.impl

import com.example.demo.controllers.IBaseController
import com.example.demo.services.IGenericService
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*


open class BaseController<DTO, Service : IGenericService<DTO>>(
    var service : Service
) : IBaseController<DTO> {

    @ApiOperation(value = "To get element by id")
    @GetMapping("/{id}")
    override fun getOneById(@PathVariable id: Long): DTO {
        return service.getOneById(id);
    }

    @ApiOperation(value = "To get all elements")
    @GetMapping()
    override fun getAll(): List<DTO> {
        return service.getAll();
    }

    @ApiOperation(value = "To add element ")
    @PostMapping()
    override fun addOne(@RequestBody dto: DTO): DTO {
        return service.addOne(dto);
    }
    @ApiOperation(value = "To update element ")
    @PutMapping("/{id}")
    override fun updateOne(@RequestBody dto: DTO, @PathVariable id: Long): DTO {
        return service.updateOne(dto,id)
    }
    @ApiOperation(value = "To delete element ")
    @DeleteMapping("/{id}")
    override fun deleteOne(@PathVariable id: Long): DTO {
        return service.deleteOne(id)
    }
}