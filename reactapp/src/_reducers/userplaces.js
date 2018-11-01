import { PlaceConstants } from '../_constants';
import { AlertActions } from '../_actions';

function userplaces (state=[], action){
    switch(action.type){
        case PlaceConstants.GETUSERPLACES_SUCCESS:
            return action.places;
        case PlaceConstants.DELETEUSERPLACE_SUCCESS:
            return action.places;
        case PlaceConstants.CREATEUSERPLACE_SUCCESS:
            return action.places;  
        case PlaceConstants.INCREASEUSERPLACEPREFERENCE_SUCCESS:
            return action.places;   
        case PlaceConstants.DECREASEUSERPLACEPREFERENCE_SUCCESS:
            return action.places;      
        default :
            return state   
    }
}

export default userplaces