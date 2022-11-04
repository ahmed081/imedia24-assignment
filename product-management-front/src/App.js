import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Container} from "react-bootstrap";
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {BrowserRouter as Router, Link, Route, Switch} from 'react-router-dom'
import ProductList from "./containers/product/ProductList";
import ProductEdit from "./containers/product/ProductEdit";
import CategoryList from "./containers/category/CategoryList";
import CategoryEdit from "./containers/category/CategoryEdit";
import {useState} from "react";

function App(){

    return (
        <div>
            <Router>
                <Container>
                    <Navbar bg="dark" variant="dark">
                        <Container>
                            <Navbar.Brand href="#home">Product Management App</Navbar.Brand>
                            <Nav className="me-auto">
                                <Nav.Link eventKey="product">
                                    <Link  to="/product">Products</Link>
                                </Nav.Link>
                                <Nav.Link eventKey="/category">
                                    <Link to="/category">Categories</Link>
                                </Nav.Link>
                            </Nav>
                        </Container>
                    </Navbar>
                </Container>
                <div>
                    <Switch>
                        <Route exact path="/" component={ProductList}/>
                        <Route exact path="/product" component={ProductList}/>
                        <Route exact path="/product/add" component={ProductEdit}/>
                        <Route exact path="/product/edit/:id" component={ProductEdit}/>
                        <Route exact path="/category" component={CategoryList}/>
                        <Route exact path="/category/add" component={CategoryEdit}/>
                        <Route exact path="/category/edit/:id" component={CategoryEdit}/>
                    </Switch>
                </div>
            </Router>

        </div>
    );
}

export default App;
