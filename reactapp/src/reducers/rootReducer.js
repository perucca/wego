import users from './users'
import places from './places'
import sports from './sports'
import userplaces from './userplaces'
import usersports from './usersports'
import sportplaceassociation from './sportplaceassociation'
import currentuser from './currentuser'


function rootReducer(state={}, action){
    return {
        users : users(state.users, action),
        places : places(state.places, action),
        sports : sports(state.sports, action),
        userplaces : userplaces(state.userplaces, action),
        usersports : usersports(state.usersports, action),
        sportplaceassociation : sportplaceassociation(state.sportplaceassociation, action),
        currentuser : currentuser(state.currentuser, action),
    };
}


export default rootReducer