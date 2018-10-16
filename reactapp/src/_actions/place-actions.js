import { PlaceConstants } from '../_constants';
import { history } from '../_helpers';
import { placeService } from '../_services/place-service';

export const PlaceActions = {
    getPlaces,
    getUserPlaces
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