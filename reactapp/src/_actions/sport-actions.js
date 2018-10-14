import { SportConstants } from '../_constants';
import { history } from '../_helpers';
import { sportService } from '../_services';

export const SportActions = {
    getSports
}

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