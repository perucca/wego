import { SportPlaceConstants } from '../_constants';

function sportplaceassociation (state=[], action){
    switch(action.type){
        case SportPlaceConstants.READ_SPORTPLACE_ASSOCIATION_SUCCESS:
            return action.sportPlaceAssociations;
        default :
            return state   
    }
}

export default sportplaceassociation