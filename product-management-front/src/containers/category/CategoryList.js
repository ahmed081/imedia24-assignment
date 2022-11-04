import {Component, useEffect} from "react";
import {categoriesFetch, categoryDelete} from "../../actions/CategoryActions";
import {connect} from 'react-redux'
import {Button, Col, Container, Row, Table} from "react-bootstrap";
import PaginationComponent from "../../components/common/PaginationComponent";

function CategoryList ({categoriesFetch,categories, currentPage,history,categoryDelete}){
    useEffect(()=>{
        categoriesFetch()
    },[])

    const paginate = (page) => {
        categoriesFetch(page)
    }

    return (
        <Container>
            <Row>
                <Col md={12} style={{margin: '15px 0'}}>
                    <Button variant="success" style={{float: 'right'}}
                            onClick={(e) => history.push('category/add/')
                            }>New Category</Button>
                </Col>
            </Row>
            <Row>
                <Col md={12}>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>code</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {categories?.map(
                            category => (
                                <tr key={category.id}>
                                    <td>{category.id}</td>
                                    <td>{category.nameCategory}</td>
                                    <td>{category.descCategory}</td>
                                    <td>
                                        <Row>
                                            <Col md={6}><i className="bi bi-pencil-square" onClick={() => {
                                                history.push('/category/edit/' + category.id)
                                            }}></i></Col>
                                            <Col md={6}><i className="bi bi-trash-fill" onClick={async () => {
                                                if (window.confirm("Are you sure want to delete the category number " + category.id)) {
                                                    await categoryDelete(category.id)

                                                }
                                            }}></i></Col>
                                        </Row>
                                    </td>
                                </tr>
                            ))}

                        </tbody>
                    </Table>
                </Col>
            </Row>
            {categories?.totalElements > 1 &&
                <PaginationComponent paginate={paginate} currentPage={currentPage}
                                     totalElements={categories?.totalElements}/>}
        </Container>
    )
}


function mapStateToProps({categories}) {
    return {
        categories: categories.categoryPage,
        currentPage: categories.currentPage
    }
}


export default connect(mapStateToProps, {categoriesFetch, categoryDelete})(CategoryList)