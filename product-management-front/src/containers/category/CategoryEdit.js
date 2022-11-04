import React, {Component, useEffect} from 'react'
import {connect} from 'react-redux'
import {categoryCreate, categoryUpdate, getOne} from "../../actions/CategoryActions";
import CategoryForm from "../../components/categories/CategoryForm";

function CategoryEdit ({getOne,formValues, match, categories, categoryCreate, categoryUpdate, categoryItem,history}){
    useEffect(()=>{
        if (match.params.id) {
            getOne(match.params.id)
        }
    },[])


    return (
        <div>
            <div className="container">
                <div className="col-md-5">
                    {match.path.indexOf('add') > 0 && (
                        <div>
                            <h2>Add new category</h2>
                            <CategoryForm onCategorySubmit={async () => {
                                await categoryCreate(formValues);
                                history.push('/category')

                            }
                            }/>
                        </div>

                    )}
                    {match.path.indexOf('edit') > 0 && (
                        <div>
                            <h2>Update category</h2>

                            <CategoryForm onCategorySubmit={() => {
                                categoryUpdate(categoryItem.id, formValues)
                                history.push('/category')

                            }}/>
                        </div>
                    )}
                </div>
            </div>

        </div>
    )
}
function mapStateToProps({form, categories}) {
    return {
        formValues: form.CategoryForm
            ? form.CategoryForm.values
            : null,
        categoryItem: categories.categoryItem,
        categories
    }
}

export default connect(mapStateToProps, {categoryCreate, categoryUpdate, getOne})(CategoryEdit)
