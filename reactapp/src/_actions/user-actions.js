import { UserConstants } from '../_constants';
import Axios from 'axios';
import { history } from '../_helpers';
import { userService } from '../_services';

export const UserActions = {
    login,
    logout,
    register
}
function register(user) {
    return dispatch => {
        dispatch(request())
        userService.register(user)
            .then(function (response) {
                dispatch(success())
                history.push('/')
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: UserConstants.LOGIN_PROGRESS } }
    function success() { return { type: UserConstants.LOGIN_SUCCESS } }
    function failure() { return { type: UserConstants.LOGIN_ERROR } }
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