import {UserConstants} from '../_constants/UserConstants';

function users (state=[], action){
    switch(action.type){
        case UserConstants.ADD_USER_PROGRESS:
        case UserConstants.ADD_USER_ERROR :
        case UserConstants.ADD_USER_SUCCESS :
        default :
            return state   
    }
}

export default users