import Axios from 'axios';

export const userService = {
    login,
    register
}

function login(username, password) {
    return Axios.post('/login', {}, {
        auth: {
            username: username,
            password: password
        }
    })
        .then(function (response) {
            if (response.status === 202) {
                console.log("authentication succeeded");
                console.log(response.config.headers.Authorization);
                console.log(username);
             
                //add the user to local storage
                
                //add the user to the store
                return Axios.get('/users/by_email/' + username, {
                    auth: {
                        username: username,
                        password: password
                    }
                }).then(function (response) {
                    let user = response.data;
                    user.authorization = response.config.headers.Authorization;
                    console.log("user fetched" + user);
                    return user;
                })
                
            }
            else {
                console.log("authentication failed");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("login error");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}

function register(user) {
    return Axios.post('/signin', user)
        .then(function (response) {
            console.log("signin succeeded");
            return response;
        })
        .catch(function (error) {
            console.log("signin failed");
            return Promise.reject(error);
        })
}