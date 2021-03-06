import Axios from 'axios';

export const sportService = {
    getSports,
    getUserSports,
    createUserSport,
    deleteUserSport,
    updateUserSportBatch
}

//READ ALL SPORTS
function getSports(user) {
    console.log(user.authorization)
    return Axios.get('/api/sports', {
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

//READ USERSPORTS
function getUserSports(user) {
    console.log(user.authorization)
    return Axios.get('/api/usersports/byuser/' + user.id, {
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

//CREATE USERSPORT
function createUserSport(user, userSport) {
    
    return Axios.post('/api/usersports/',userSport, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 201) {
                console.log("Successfully created userSport");
                console.log(response)
                return response;
            }
            else {
                console.log("Failed to create userSport");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("Error creating userSport");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}

//DELETE USERSPORT
function deleteUserSport(user, id) {
    console.log(user.authorization)
    return Axios.delete('/api/usersports/'+ id, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully deleted the user sport");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed deleting the user sport");
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

//UPDATE USERSPORT BATCH
function updateUserSportBatch(user, userSportBatch) {
    
    return Axios.put('/api/usersports/',userSportBatch, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully updated all the userSports");
                console.log(response)
                return response;
            }
            else {
                console.log("Failed to update all the userSports");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("Error updating all the userSports");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}