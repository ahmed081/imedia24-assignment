import React, {Component} from 'react'
import {Form} from "react-bootstrap";
function FormSelectField ({input, label, required, defaultOptionMessage, meta, options}){
    const renderCurrencyOptions = (options) =>{
        return  Object.keys(options).map(currency => {
            return <option key={currency} value={currency}>{options[currency]}</option>
        })
    }

    const renderCategoryOptions = (options) =>{
        return  options?.map(category => {
            return <option key={category.id} value={category.id}>{category.nameCategory}</option>
        })
    }

    return (
        <div className='form-group'>
            <Form.Group className="mb-12">
                <Form.Label>{label}</Form.Label>
                <Form.Select required={required} name={input.name} {...input}>
                    <option>{defaultOptionMessage}</option>
                    {
                        input.name == "currency" ? renderCurrencyOptions(options)
                            : input.name == "categoryId" ? renderCategoryOptions(options) : ""
                    }
                </Form.Select>
            </Form.Group>

            {
                meta.error && meta.touched && (
                    <div className='mt-2 text-danger title'>{meta.error}</div>
                )
            }

        </div>
    )
}


export default FormSelectField;