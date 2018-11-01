import { PlaceConstants } from '../_constants';

function places (state=[], action){
    switch(action.type){
        case PlaceConstants.GETPLACES_SUCCESS:
            return action.places;
        case PlaceConstants.SEARCHPLACE_SUCCESS:
            return action.places;       
        case PlaceConstants.CREATEUSERPLACE_SUCCESS:
            return [];       
        default :
            return state;
    }
}

export default places;