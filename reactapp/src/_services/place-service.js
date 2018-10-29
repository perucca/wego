import Axios from 'axios';

export const placeService = {
    getPlaces,
    getUserPlaces
}

function getPlaces(user) {
    console.log(user.authorization)
    return Axios.get('/api/places', {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully fetched places");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed fetching places");
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

function getUserPlaces(user) {
    console.log(user.authorization)
    return Axios.get('/api/userplaces/byuser/' + user.id, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully fetched the user places");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed fetching user places");
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