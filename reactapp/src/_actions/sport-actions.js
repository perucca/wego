import { SportConstants } from '../_constants';
import { sportService } from '../_services';

export const SportActions = {
    getSports,
    getUserSports,
    createUserSport
}

//RETRIEVE ALL SPORTS
function getSports(user) {
    return dispatch => {
        dispatch(request())
        sportService.getSports(user)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: SportConstants.GETSPORTS_PROGRESS } }
    function success(sports) { return { type: SportConstants.GETSPORTS_SUCCESS, sports } }
    function failure() { return { type: SportConstants.GETSPORTS_ERROR } }
}

//READ USERSPORTS
function getUserSports(user) {
    return dispatch => {
        dispatch(request())
        sportService.getUserSports(user)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: SportConstants.GETUSERSPORTS_PROGRESS } }
    function success(sports) { return { type: SportConstants.GETUSERSPORTS_SUCCESS, sports } }
    function failure() { return { type: SportConstants.GETUSERSPORTS_ERROR } }
}

//CREATE USERSPORT
function createUserSport(user, userSport) {
    return dispatch => {
        dispatch(request());
        sportService.createUserSport(user, userSport)
            .then(function (response) {
                dispatch(success());
                dispatch(getUserSports(user))
            })
            .catch(function (error) {
                dispatch(failure());
            })
    }

    function request() { return { type: SportConstants.CREATE_USERSPORT_PROGRESS } }
    function success() { return { type: SportConstants.CREATE_USERSPORT_SUCCESS } }
    function failure() { return { type: SportConstants.CREATE_USERSPORT_ERROR } }
}