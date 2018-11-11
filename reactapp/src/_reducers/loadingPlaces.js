import { PlaceConstants } from '../_constants';

function loadingPlaces (state=[], action){
    switch(action.type){
        case PlaceConstants.SEARCHPLACE_PROGRESS:
            return true;
        case PlaceConstants.SEARCHPLACE_SUCCESS:
            return false;       
        case PlaceConstants.SEARCHPLACE_ERROR:
            return false;       
        default :
            return false;
    }
}

export default loadingPlaces;