import {Component, useEffect} from "react";
import {productDelete, productsFetch} from "../../actions/ProductActions";
import {connect} from 'react-redux'
import {Button, Col, Container, Row, Table} from "react-bootstrap";
import PaginationComponent from "../../components/common/PaginationComponent";

function ProductList ({productsFetch,products, currentPage,history,productDelete}){
    useEffect(()=>{
        productsFetch()
    },[])

    const paginate = (page) => {
        productsFetch(page)
    }

    return (
        <Container>
            <Row>
                <Col md={12} style={{margin: '15px 0'}}>
                    <Button variant="success" style={{float: 'right'}}
                            onClick={(e) => history.push('product/add/')
                            }>New Product</Button>
                </Col>
            </Row>
            <Row>
                <Col md={12}>
                    <Table striped bordered hover>
                        <thead>
                        <tr>
                            <th>code</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {products?.map(
                            product => (
                                <tr key={product.id}>
                                    <td>{product.id}</td>
                                    <td>{product.productName}</td>
                                    <td>{product.category?.nameCategory}</td>
                                    <td>{product.productQuantity}</td>
                                    <td>{product.productPrice}</td>
                                    <td>
                                        <Row>
                                            <Col md={6}><i className="bi bi-pencil-square" onClick={() => {
                                                history.push('/product/edit/' + product.id)
                                            }}></i></Col>
                                            <Col md={6}><i className="bi bi-trash-fill" onClick={async () => {
                                                if (window.confirm("Are you sure want to delete the product number " + product.id)) {
                                                    await productDelete(product.id)

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
            {products?.totalElements > 1 && <PaginationComponent paginate={paginate} currentPage={currentPage}
                                                                 totalElements={products?.totalElements}/>}
        </Container>
    )
}



function mapStateToProps({products}) {
    return {
        products: products.productPage,
        currentPage: products.currentPage
    }
}


export default connect(mapStateToProps, {productsFetch, productDelete})(ProductList)