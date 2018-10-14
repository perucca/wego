import { SportConstants } from '../_constants';

function sports (state=[], action){
    switch(action.type){
        case SportConstants.GETSPORTS_SUCCESS:
            return action.sports;
        default :
            return state;
    }
}

export default sports;