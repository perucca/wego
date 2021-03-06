import Axios from 'axios';

export const placeService = {
    getPlaces,
    getUserPlaces,
    deleteUserPlace,
    searchPlace,
    createUserPlace,
    increaseUserPlacePreference,
    decreaseUserPlacePreference,
    updateUserPlaceBatch
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

function deleteUserPlace(user, id) {
    console.log(user.authorization)
    return Axios.delete('/api/userplaces/byuser/' + user.id +'/'+ id, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully deleted the user place");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed deleting the user place");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("Delete error");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}

function searchPlace(user, name) {
    console.log(user.authorization)
    return Axios.get('/api/places/byname/' + name, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully fetched the places by name");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed fetching the places by name");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("Fetch error");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}

function createUserPlace(user, place) {
    console.log(user.authorization)
    return Axios.post('/api/userplaces/byuser/' + user.id, place, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully created the user place");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed creating the user place");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("Creation error");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}

function increaseUserPlacePreference(user, place) {
    console.log(user.authorization)
    return Axios.get('/api/userplaces/increased/'+user.id+"/"+ place, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully updated the user place");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed updating the user place");
                console.log(response.status + " " + response.statusText);
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

function decreaseUserPlacePreference(user, place) {
    console.log(user.authorization)
    return Axios.get('/api/userplaces/decreased/'+user.id+"/"+ place, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully updated the user place");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed updating the user place");
                console.log(response.status + " " + response.statusText);
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

//UPDATE USERPLACE BATCH
function updateUserPlaceBatch(user, userPlaceBatch) {
    
    return Axios.put('/api/userplaces/',userPlaceBatch, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully updated all the userPlaces");
                console.log(response)
                return response;
            }
            else {
                console.log("Failed to update all the userPlaces");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("Error updating all the userPlaces");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}