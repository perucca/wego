import { UserConstants } from '../_constants';

function AuthenticationReducer(state = [], action) {
    switch (action.type) {
        case UserConstants.LOGIN_SUCCESS:
            return true;
        case UserConstants.LOGOUT:
            return false;
        default:
            return state;
    }
}

export default AuthenticationReducer;