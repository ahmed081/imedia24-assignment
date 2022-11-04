import React, {useEffect} from 'react'
import {connect} from 'react-redux'
import {change, Field, reduxForm} from 'redux-form'
import FormField from "../common/FormField";
import FormSelectField from "../common/FormSelectField";
import {Button, Col} from "react-bootstrap";
import {productFormFields} from "./FormFields";
import {getExchangeRate,getCurrencies} from "../../actions/currencyAction";
import {useParams} from "react-router";

function ProductForm ({getExchangeRate,onProductSubmit,handleSubmit,categories,currencies,getCurrencies,productItem,dispatch}){

    const { id } = useParams();

    const renderFields = ()=> {
        return productFormFields.map(({label, name, type, options, required, defaultOptionMessage, disabled,defaultValue}, i) => {

            if (type !== 'select')
                return (
                    <Field key={i} label={label} name={name} type={type} required={required} props={{disabled}}
                           onChange={(e) => {
                               handleChange(name, e.target.value)
                           }}
                           component={FormField}/>
                )
            return (
                <Field key={i} label={label} name={name} props={{defaultOptionMessage: defaultOptionMessage}}
                       options={name === 'currency' ? currencies : categories.categoryPage}
                       type={type} required={required}
                       onChange={(e) => {
                           handleChange(name, e.target.value)
                       }}
                       component={FormSelectField}/>
            )
        })
    }

    const handleChange= (name, value) =>{
        if (name === 'currency') {
            getExchangeRate(value,id,productItem?.productPrice)
        }
        if(name == "productPrice"){
            getExchangeRate(productItem?.currency,id,value)
        }

    }
    useEffect(()=>{
        getCurrencies()
    },[])
    useEffect(()=>{
        dispatch(change("ProductForm","exchangeRate",productItem?.exchangeRate));
        dispatch(change("ProductForm","againstValue",productItem?.againstValue));
        dispatch(change("ProductForm","productPrice",productItem?.productPrice));
    },[productItem])

    return (
        <form onSubmit={handleSubmit(onProductSubmit)}>
            {renderFields()}
            <Col md={12} style={{marginTop: '5px'}}> <Button type='submit' variant="success">Save</Button></Col>
        </form>
    )
}

function validate(values) {
    const errors = {}
    productFormFields.forEach(({name, required}) => {
        if (!values[name] && required) {
            errors[name] = 'required'
        }
    })
    return errors
}

function mapStateToProps({products, categories, currencies}) {
    return {
        currencies,
        categories,
        productItem: products.productItem,
        initialValues: products&& products.productItem &&{
            productName: products?.productItem?.productName,
            productPrice: products?.productItem?.productPrice,
            productQuantity: products?.productItem?.productQuantity,
            currency: products?.productItem?.currency,
            exchangeRate: products?.productItem?.exchangeRate,
            againstValue: products?.productItem?.againstValue,
            categoryId: products?.productItem?.category?.id,
        }
    }
}

ProductForm = reduxForm({validate, form: 'ProductForm'})(ProductForm)

export default connect(mapStateToProps, {getExchangeRate,getCurrencies})(ProductForm)