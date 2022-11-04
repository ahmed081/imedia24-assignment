import {GET_ALL_CURRENCIES} from "../types/CurrenciesTypes";

export default function (state = [], action) {
    switch (action.type) {
        case GET_ALL_CURRENCIES:
            return action.payload.data.symbols
        default:
            return state
    }
}