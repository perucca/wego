import { SportConstants } from '../_constants';

function usersports (state=[], action){
    switch(action.type){
        case SportConstants.GETUSERSPORTS_SUCCESS:
            return action.sports;
        default :
            return state   
    }
}

export default usersports