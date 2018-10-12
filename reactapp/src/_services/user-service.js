import Axios from 'axios';

export const userService = {
    login
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
                return response;
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