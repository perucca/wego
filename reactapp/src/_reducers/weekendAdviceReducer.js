import { WeekendAdviceConstants } from '../_constants';

function weekendAdvice (state={}, action){
    switch(action.type){
        case WeekendAdviceConstants.WEEKENDADVICE_GET_SUCCESS:
            return action.weekendAdvice;    
        default :
            return state   
    }
}

export default weekendAdvice