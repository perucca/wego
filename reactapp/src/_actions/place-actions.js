import { PlaceConstants } from '../_constants';
import { placeService } from '../_services/place-service';

export const PlaceActions = {
    getPlaces,
    getUserPlaces,
    deleteUserPlace,
    searchPlace,
    createUserPlace,
    increaseUserPlacePreference,
    decreaseUserPlacePreference,
    updateUserPlaceBatch
}

function getPlaces(user) {
    return dispatch => {
        dispatch(request())
        placeService.getPlaces(user)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: PlaceConstants.GETPLACES_PROGRESS } }
    function success(places) { return { type: PlaceConstants.GETPLACES_SUCCESS, places } }
    function failure() { return { type: PlaceConstants.GETPLACES_ERROR } }
}

function getUserPlaces(user) {
    return dispatch => {
        dispatch(request())
        placeService.getUserPlaces(user)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: PlaceConstants.GETUSERPLACES_PROGRESS } }
    function success(places) { return { type: PlaceConstants.GETUSERPLACES_SUCCESS, places } }
    function failure() { return { type: PlaceConstants.GETUSERPLACES_ERROR } }
}

function deleteUserPlace(user, id) {
    return dispatch => {
        dispatch(request())
        placeService.deleteUserPlace(user, id)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: PlaceConstants.DELETEUSERPLACE_PROGRESS } }
    function success(places) { return { type: PlaceConstants.DELETEUSERPLACE_SUCCESS, places } }
    function failure() { return { type: PlaceConstants.DELETEUSERPLACE_ERROR } }
}

function searchPlace(user, name) {
    return dispatch => {
        dispatch(request())
        placeService.searchPlace(user, name)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: PlaceConstants.SEARCHPLACE_PROGRESS } }
    function success(places) { return { type: PlaceConstants.SEARCHPLACE_SUCCESS, places } }
    function failure() { return { type: PlaceConstants.SEARCHPLACE_ERROR } }
}

function createUserPlace(user, place) {
    return dispatch => {
        dispatch(request())
        placeService.createUserPlace(user, place)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: PlaceConstants.CREATEUSERPLACE_PROGRESS } }
    function success(places) { return { type: PlaceConstants.CREATEUSERPLACE_SUCCESS, places } }
    function failure() { return { type: PlaceConstants.CREATEUSERPLACE_ERROR } }
}

function increaseUserPlacePreference(user, place) {
    return dispatch => {
        dispatch(request())
        placeService.increaseUserPlacePreference(user, place)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: PlaceConstants.INCREASEUSERPLACEPREFERENCE_PROGRESS } }
    function success(places) { return { type: PlaceConstants.INCREASEUSERPLACEPREFERENCE_SUCCESS, places } }
    function failure() { return { type: PlaceConstants.INCREASEUSERPLACEPREFERENCE_ERROR } }
}

function decreaseUserPlacePreference(user, place) {
    return dispatch => {
        dispatch(request())
        placeService.decreaseUserPlacePreference(user, place)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: PlaceConstants.DECREASEUSERPLACEPREFERENCE_PROGRESS } }
    function success(places) { return { type: PlaceConstants.DECREASEUSERPLACEPREFERENCE_SUCCESS, places } }
    function failure() { return { type: PlaceConstants.DECREASEUSERPLACEPREFERENCE_ERROR } }
}

//UPDATE USERSPORT BATCH
function updateUserPlaceBatch(user, userPlaceBatch) {
    return dispatch => {
        dispatch(request());
        placeService.updateUserPlaceBatch(user, userPlaceBatch)
            .then(function (response) {
                dispatch(success());
                dispatch(getUserPlaces(user))
            })
            .catch(function (error) {
                dispatch(failure());
            })
    }

    function request() { return { type: PlaceConstants.UPDATE_USERPLACE_BATCH_PROGRESS } }
    function success() { return { type: PlaceConstants.UPDATE_USERPLACE_BATCH_SUCCESS } }
    function failure() { return { type: PlaceConstants.UPDATE_USERPLACE_BATCH_ERROR } }
}