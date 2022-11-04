import {Component} from "react";
import {Col, Pagination, Row} from "react-bootstrap";


function PaginationComponent  ({currentPage, totalElements,paginate}){
    const gotToPage = (page) => {
        paginate(page)
    }

        return (
            <Row className="text-center">
                <Col md={12}>
                    <center>
                        <Pagination className="text-center">
                            {currentPage > 0 && <Pagination.Prev onClick={e => gotToPage(currentPage - 1)}/>}
                            <Pagination.Item onClick={e => gotToPage(0)}
                                             active={currentPage === 0}>1</Pagination.Item>
                            {currentPage !== 0 && <Pagination.Ellipsis/>}
                            {currentPage !== 0 &&
                                <Pagination.Item onClick={e => gotToPage(currentPage)}
                                                 active={currentPage !== 0}>{currentPage + 1}</Pagination.Item>}
                            {currentPage + 1 !== totalElements &&
                                <Pagination.Ellipsis/>
                            }
                            {currentPage + 1 !== totalElements &&
                                <Pagination.Item
                                    onClick={e =>gotToPage(totalElements - 1)}>{totalElements}</Pagination.Item>}
                            {currentPage + 1 !== totalElements &&
                                <Pagination.Next onClick={e => gotToPage(currentPage + 1)}/>}
                        </Pagination>
                    </center>
                </Col>
            </Row>
            )

}



export default PaginationComponent