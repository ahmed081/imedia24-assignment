import axios from "axios";
import {GET_ALL_CURRENCIES} from "../types/CurrenciesTypes";
import {PRODUCT_GET_ONE} from "../types/ProductTypes";
export const path = process.env.REACT_APP_API_URL + '/currencies/'
export function getExchangeRate(currency,target,productPrice) {
    return dispatch => {
        axios.patch(path+`exchange?target=${currency}&productId=${target}`,{
            productPrice
        })
            .then(
                res => {
                    dispatch({
                        type: PRODUCT_GET_ONE,
                        payload: res.data
                    })
                }
            )
    }
}

export function getCurrencies() {
    return dispatch => {
        axios.get(path)
            .then(
                res => {
                    dispatch({
                        type: GET_ALL_CURRENCIES,
                        payload: res.data
                    })
                }
            )
    }
}