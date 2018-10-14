import { UserConstants } from '../_constants';
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

    function request() { return { type: UserConstants.REGISTER_PROGRESS } }
    function success() { return { type: UserConstants.REGISTER_SUCCESS } }
    function failure() { return { type: UserConstants.REGISTER_ERROR } }
}

function login(username, password) {
    return dispatch => {
        dispatch(request())
        userService.login(username, password)
            .then(function (response) {
                console.log('logged user')
                console.log(response)
                dispatch(success(response));
                history.push('/home');
            })
            .catch(function (error) {
                dispatch(failure());
                history.push('/');
            });
    };

    function request() { return { type: UserConstants.LOGIN_PROGRESS } }
    function success(lUser) { return { type: UserConstants.LOGIN_SUCCESS, isAuthenticated: true, user: lUser } }
    function failure() { return { type: UserConstants.LOGIN_ERROR,  isAuthenticated: false } }
}


function logout() {
    //userService.logout();
    history.push('/');
    return { type: UserConstants.LOGOUT, isAuthenticated: false};
}