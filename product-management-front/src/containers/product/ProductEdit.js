import React, {Component, useEffect, useState} from 'react'
import {connect} from 'react-redux'
import {getOne, productCreate, productUpdate} from "../../actions/ProductActions";
import {categoriesFetch} from "../../actions/CategoryActions";
import ProductForm from "../../components/products/ProductForm";

function ProductEdit ({categories,match,getOne,categoriesFetch,formValues, productCreate, productUpdate, productItem,history}){
    useEffect(()=>{
        if (match.params.id) {
            getOne(match.params.id)
        }
        categoriesFetch();

        if(match.path.indexOf('add') > 0){
            setPage({
                type : "add",
                title : "Add new Product"
            })
        }else if ( match.path.indexOf('edit') > 0 ){
            setPage({
                type : "edit",
                title : "Update Product"
            })
        }
    },[])
    const [page,setPage] = useState({})
    const getCategoryById = (id)=>{
        return categories?.categoryPage?.find(category =>category.id == id)
    }

    const submitProduct = async () => {
        const category = getCategoryById(formValues.categoryId);
        if(category){
            formValues.category = category;
            formValues.id = match.params.id;
            if(page.type == "add"){
                await productCreate(formValues);
            }else if(page.type == "edit"){
                await productUpdate(productItem.id, formValues)
            }
            history.push('/product')
        }


    }
    return (
        <div>
            <div className="container">
                <div className="col-md-5">

                    <h2>{page?.title}</h2>
                    <ProductForm onProductSubmit={submitProduct}/>


                </div>
            </div>

        </div>
    )
}

function mapStateToProps({form, products, categories}) {
    return {
        formValues: form.ProductForm
            ? form.ProductForm.values
            : null,
        products,
        productItem: products.productItem,
        categories
    }
}

export default connect(mapStateToProps, {categoriesFetch, productCreate, productUpdate, getOne})(ProductEdit)
