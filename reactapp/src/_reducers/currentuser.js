import { UserConstants } from '../_constants';

function currentuser (state={}, action){
    switch(action.type){
        case UserConstants.LOGIN_SUCCESS:
            return action.user;
        default :
            return state   
    }
}

export default currentuser