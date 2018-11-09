import WeekendAdviceConstants from '../_constants'
import weekendAdviceService from '../_services/weekendadvice-service'

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

    function request() { return { type: WeekendAdviceConstants.REGISTER_PROGRESS } }
    function success(weekendadvice) { return { type: WeekendAdviceConstants.REGISTER_SUCCESS, weekendadvice } }
    function failure() { return { type: WeekendAdviceConstants.REGISTER_ERROR } }
}
