import users from './users'
import places from './places'
import sports from './sports'
import userplaces from './userplaces'
import usersports from './usersports'
import sportplaceassociation from './sportplaceassociation'
import currentuser from './currentuser'
import AuthenticationReducer from './AuthenticationReducer'
import weekendAdvice from './weekendAdviceReducer'
import loadingPlaces from './loadingPlaces'

function rootReducer(state={}, action){
    return {
        users : users(state.users, action),
        places : places(state.places, action),
        sports : sports(state.sports, action),
        userplaces : userplaces(state.userplaces, action),
        usersports : usersports(state.usersports, action),
        sportplaceassociations : sportplaceassociation(state.sportplaceassociations, action),
        currentuser : currentuser(state.currentuser, action),
        isAuthenticated: AuthenticationReducer(state.isAuthenticated, action),
        weekendAdvice: weekendAdvice(state.weekendadvice,action),
        arePlacesLoading: loadingPlaces(state.arePlacesLoading, action)
    };
}


export default rootReducer