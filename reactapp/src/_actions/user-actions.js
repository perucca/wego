import { UserConstants } from '../_constants';
import { history } from '../_helpers';
import Axios from 'axios';

export const UserActions = {
    login,
}

export const authenticate = (isAuthenticated) => {
    return { type: UserConstants.LOGIN_SUCCESS, isAuthenticated: isAuthenticated };
}

function login(username, password) {
    return dispatch => {
        Axios.post('/login', {}, {
            auth: {
                username: username,
                password: password
            }
        })
            .then(function (response) {
                console.log(response);
                if (response.status === 202) {
                    dispatch(authenticate(true));
                    history.push('/home');
                    console.log('authenticated');
                }
                else {
                    console.log("authentication failed");
                }

            })
            .catch(function (error) {
                //on trace l'erreur au maximum
                //this.logError(error);
                console.log("error");
                //Gérer le code 401 ici pour retourner un message d'erreur
            });
    }
}
