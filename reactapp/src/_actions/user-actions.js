import { UserConstants } from '../_constants';
import Axios from 'axios';
import { history } from '../_helpers';

export const UserActions = {
    login,
    add
}
function add(user) {
    return dispatch => {
        dispatch({type: UserConstants.ADD_USER_PROGRESS})
        Axios.post('/signin', user)
        .then(function(response) {
            dispatch({type:UserConstants.ADD_USER_SUCCESS})
            history.push('/')
        })
        .catch(function(error) {
            dispatch({type: UserConstants.ADD_USER_ERROR})
        })
    }
}
function login(username, password) {
    return dispatch => {
        dispatch({ type: UserConstants.LOGIN_PROGRESS})
        Axios.post('/login', {}, {
            auth: {
                username: username,
                password: password
            }
        })
            .then(function (response) {
                if (response.status === 202) {
                    dispatch({ type: UserConstants.LOGIN_SUCCESS });
                    history.push('/home'); 
                }
                else {
                    console.log("authentication failed");
                }
            })
            .catch(function (error) {
                if(error.response) {
                    console.log(error.response)
                }

                dispatch({ type: UserConstants.LOGIN_ERROR });
                history.push('/'); 
                //on trace l'erreur au maximum
                //this.logError(error);
                console.log("error");
                //Gérer le code 401 ici pour retourner un message d'erreur
            });
    }
}
