import {WeekendAdviceConstants} from '../_constants'
import {weekendAdviceService} from '../_services/weekendadvice-service'

export const WeekendAdviceActions = {
    load
}

function load(user) {
    return dispatch => {
        dispatch(request())
        weekendAdviceService.load(user)
            .then(function (response) {
                dispatch(success(response))
            })
            .catch(function (error) {
                dispatch(failure())
            })
    }

    function request() { return { type: WeekendAdviceConstants.WEEKENDADVICE_GET_PROGRESS } }
    function success(weekendAdvice) { return { type: WeekendAdviceConstants.WEEKENDADVICE_GET_SUCCESS, weekendAdvice } }
    function failure() { return { type: WeekendAdviceConstants.WEEKENDADVICE_GET_ERROR } }
}
