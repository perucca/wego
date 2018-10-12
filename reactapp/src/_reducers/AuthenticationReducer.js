import { UserConstants } from '../_constants';


function AuthenticationReducer(state = [], action) {
    switch (action.type) {
        case UserConstants.LOGIN_ERROR:
            return action.isAuthenticated;
        case UserConstants.LOGIN_SUCCESS:
            return action.isAuthenticated;
        case UserConstants.LOGOUT:
            return false;
        default:
            return state;
    }
}

export default AuthenticationReducer;