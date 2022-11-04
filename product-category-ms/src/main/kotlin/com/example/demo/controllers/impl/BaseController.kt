package com.example.demo.controllers.impl

import com.example.demo.controllers.IBaseController
import com.example.demo.dtos.ResponseDTO
import com.example.demo.services.IGenericService
import io.swagger.annotations.ApiOperation
import org.aspectj.apache.bcel.classfile.Constant
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


open class BaseController<DTO, Service : IGenericService<DTO>>(
    var service : Service
) : IBaseController<DTO> {

    @ApiOperation(value = "To get element by id")
    @GetMapping("/{id}")
    override fun getOneById(@PathVariable id: Long): ResponseEntity<ResponseDTO<DTO>> {
        val dto:DTO = service.getOneById(id)
        return ResponseEntity(
            ResponseDTO(true,dto,null,"Success")
            ,HttpStatus.OK);
    }

    @ApiOperation(value = "To get all elements")
    @GetMapping()
    override fun getAll():  ResponseEntity<ResponseDTO<DTO>> {
        val list =  service.getAll()
        return ResponseEntity(
            ResponseDTO(true,null,list,"Success")
            ,HttpStatus.OK);
    }

    @ApiOperation(value = "To add element ")
    @PostMapping()
    override fun addOne(@RequestBody dto: DTO):  ResponseEntity<ResponseDTO<DTO>> {
        val addedDto:DTO = service.addOne(dto);
        return ResponseEntity(
            ResponseDTO(true,addedDto,null,"Success")
            ,HttpStatus.OK);
    }
    @ApiOperation(value = "To update element ")
    @PutMapping("/{id}")
    override fun updateOne(@RequestBody dto: DTO, @PathVariable id: Long): ResponseEntity<ResponseDTO<DTO>> {
        val updatedDto:DTO = service.updateOne(dto,id)
        return ResponseEntity(
            ResponseDTO(true,updatedDto,null,"Success")
            ,HttpStatus.OK)
    }
    @ApiOperation(value = "To delete element ")
    @DeleteMapping("/{id}")
    override fun deleteOne(@PathVariable id: Long): ResponseEntity<ResponseDTO<DTO>> {
        val deletedDto:DTO =  service.deleteOne(id)
        return ResponseEntity(
            ResponseDTO(true,deletedDto,null,"Success")
            ,HttpStatus.OK)
    }
}