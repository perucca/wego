import { SportConstants } from '../_constants';
import { sportService } from '../_services';

export const SportActions = {
    getSports,
    getUserSports,
    createUserSport,
    deleteUserSport,
    updateUserSportBatch
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

//DELETE USERSPORT
function deleteUserSport(user, id) {
    return dispatch => {
        dispatch(request())
        sportService.deleteUserSport(user, id)
            .then(function (response) {
                dispatch(success(response))
                dispatch(getUserSports(user))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: SportConstants.DELETE_USERSPORT_PROGRESS } }
    function success(sports) { return { type: SportConstants.DELETE_USERSPORT_SUCCESS, sports } }
    function failure() { return { type: SportConstants.DELETE_USERSPORT_ERROR } }
}

//UPDATE USERSPORT BATCH
function updateUserSportBatch(user, userSportBatch) {
    return dispatch => {
        dispatch(request());
        sportService.updateUserSportBatch(user, userSportBatch)
            .then(function (response) {
                dispatch(success());
                dispatch(getUserSports(user))
            })
            .catch(function (error) {
                dispatch(failure());
            })
    }

    function request() { return { type: SportConstants.UPDATE_USERSPORT_BATCH_PROGRESS } }
    function success() { return { type: SportConstants.UPDATE_USERSPORT_BATCH_SUCCESS } }
    function failure() { return { type: SportConstants.UPDATE_USERSPORT_BATCH_ERROR } }
}