import {combineReducers} from 'redux'
import CategoryReducer from './categoryReducer'
import CurrencyReducer from './currencyReducer'
import ProductReducer from './ProductReducer'
import {reducer as reduxForm} from 'redux-form'


const rootReducers = combineReducers({
    products: ProductReducer,
    categories: CategoryReducer,
    currencies: CurrencyReducer,
    form: reduxForm

})

export default rootReducers