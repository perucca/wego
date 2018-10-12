import { UserConstants } from '../_constants';
import Axios from 'axios';
import { history } from '../_helpers';
import { userService } from '../_services';

export const UserActions = {
    login,
    logout,
    add
}
function add(user) {
    return dispatch => {
        dispatch({ type: UserConstants.ADD_USER_PROGRESS })
        Axios.post('/signin', user)
            .then(function (response) {
                dispatch({ type: UserConstants.ADD_USER_SUCCESS })
                history.push('/')
            })
            .catch(function (error) {
                dispatch({ type: UserConstants.ADD_USER_ERROR })
            })
    }
}

function login(username, password) {
    return dispatch => {
        dispatch(request())
        userService.login(username, password)
            .then(function (response) {
                dispatch(success());
                history.push('/home');
            })
            .catch(function (error) {
                dispatch(failure());
                history.push('/');
            });
    };

    function request() { return { type: UserConstants.LOGIN_PROGRESS } }
    function success() { return { type: UserConstants.LOGIN_SUCCESS, isAuthenticated: true } }
    function failure() { return { type: UserConstants.LOGIN_ERROR,  isAuthenticated: false } }
}


function logout() {
    //userService.logout();
    history.push('/');
    return { type: UserConstants.LOGOUT, isAuthenticated: false};
}