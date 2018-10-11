import { UserConstants } from '../_constants';
import { history } from '../_helpers';

export const UserActions = {
    login,
}

export const authenticate = (isAuthenticated) => {
    return {type: UserConstants.LOGIN_SUCCESS, isAuthenticated: isAuthenticated};
}

function login(){
    return dispatch => {
        delay(500)
        .then((res) => {
            dispatch(authenticate(true));
            history.push('/home');
            console.log('authenticate');
        }, (error) => {
            console.log('error' + error);
        }
        )
    }
}

function delay(t) {
    return new Promise(function(resolve){
        setTimeout(resolve.bind(null, true),t);
    });
        
        
 }
 


function signout(callback){
    this.isAuthenticated = false;
    setTimeout(callback, 100);
}

