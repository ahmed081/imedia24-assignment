package com.example.demo.exceptions.handlers

import com.example.demo.dtos.BaseDto
import com.example.demo.dtos.ResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import javax.persistence.EntityNotFoundException


@ControllerAdvice

class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    @ResponseStatus(code = HttpStatus.OK)
    @ResponseBody
    fun handleValidationError(ex: EntityNotFoundException): ResponseEntity<ResponseDTO<BaseDto>> {
        val message = ex.message
        return ResponseEntity(
            ResponseDTO(false,null,null,message)
            ,HttpStatus.OK);
    }
}