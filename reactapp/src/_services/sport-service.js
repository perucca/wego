import Axios from 'axios';

export const sportService = {
    getSports,
    getUserSports
}

function getSports(user) {
    console.log(user.authorization)
    return Axios.get('/sports', {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully fetched sports");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed fetching sports");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("fetch error");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}

function getUserSports(user) {
    console.log(user.authorization)
    return Axios.get('/usersports/byuser/' + user.id, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully fetched the user sports");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed fetching user sports");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("fetch error");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}