import { SportPlaceConstants } from '../_constants';
import { sportPlaceService } from '../_services';
import { SportConstants } from '../_constants';
import { sportService } from '../_services';
import { SportActions } from '../_actions';

export const SportPlaceActions = {
    readSportPlaceAssociations,
    createSportPlaceAssociation
}

//READ SPORTPLACE ASSOCIATIONS
function readSportPlaceAssociations(user) {
    return dispatch => {
        dispatch(request())
        sportPlaceService.readSportPlaceAssociations(user)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: SportPlaceConstants.READ_SPORTPLACE_ASSOCIATION_PROGRESS } }
    function success(sportPlaceAssociations) { return { type: SportPlaceConstants.READ_SPORTPLACE_ASSOCIATION_SUCCESS, sportPlaceAssociations } }
    function failure() { return { type: SportPlaceConstants.READ_SPORTPLACE_ASSOCIATION_FAIL } }
}

//CREATE SPORTPLACE ASSOCIATION
function createSportPlaceAssociation(user, userSport, sportPlaceAssociation) {
    return dispatch => {

        dispatch(requestUserSport());
        sportService.createUserSport(user, userSport)
            .then(function (response) {
                dispatch(successUserSport());
                dispatch(SportActions.getUserSports(user));
                dispatch(request());
                sportPlaceAssociation.idUserSport = response.headers.location.substr(response.headers.location.lastIndexOf('/') + 1);
                console.log(sportPlaceAssociation);
                sportPlaceService.createSportPlaceAssociation(user, sportPlaceAssociation)
                    .then(function (response) {
                        dispatch(success());
                        dispatch(readSportPlaceAssociations(user))
                    })
                    .catch(function (error) {
                        dispatch(failure());
                    })
            })
            .catch(function (error) {
                dispatch(failureUserSport());
            })
    }

    function requestUserSport() { return { type: SportConstants.CREATE_USERSPORT_PROGRESS } }
    function successUserSport() { return { type: SportConstants.CREATE_USERSPORT_SUCCESS } }
    function failureUserSport() { return { type: SportConstants.CREATE_USERSPORT_ERROR } }

    function request() { return { type: SportPlaceConstants.CREATE_SPORTPLACE_ASSOCIATION_PROGRESS } }
    function success() { return { type: SportPlaceConstants.CREATE_SPORTPLACE_ASSOCIATION_SUCCESS } }
    function failure() { return { type: SportPlaceConstants.CREATE_SPORTPLACE_ASSOCIATION_FAIL } }
}
