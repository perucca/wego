import Axios from 'axios';

export const userService = {
    login,
    register,
    updateUserProfile
}

//LOG THE USER
function login(username, password) {
    return Axios.post('/api/login', {}, {
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
                return Axios.get('/api/users/by_email/' + username, {
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

//REGISTER THE USER
function register(user) {
    return Axios.post('/api/signin', user)
        .then(function (response) {
            console.log("signin succeeded");
            return response;
        })
        .catch(function (error) {
            console.log("signin failed");
            return Promise.reject(error);
        })
}

function updateUserProfile(user, dto) {
    return Axios.put('/api/users/'+user.id, dto, {
        headers : {'Authorization': '' + user.authorization}
    })
    .then(function (response) {
        if (response.status === 200) {
            console.log("Successfully updated the user");
            return response.data;
        }
        else {
            console.log("Failed updating the user");
            return Promise.reject(response);
        }
    })
    .catch(function (error) {
        console.log("Update error");
        if (error.response) {
            console.log(error.response);
        }
        return Promise.reject(error);
    });
}
