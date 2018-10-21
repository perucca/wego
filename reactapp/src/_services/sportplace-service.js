import Axios from 'axios';

export const sportPlaceService = {
    readSportPlaceAssociations,
    createSportPlaceAssociation,
}

//READ SPORTPLACE ASSOCIATONS
function readSportPlaceAssociations(user) {
    console.log(user.authorization)
    return Axios.get('/sportplaceassociations/byuser/' + user.id, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully fetched the sport-place associations");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed to fetch the sport-place associations");
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

//CREATE SPORTPLACE ASSOCIATION
function createSportPlaceAssociation(user, sportPlaceAssociation) {
    
    return Axios.post('/sportplaceassociations/',sportPlaceAssociation, {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 201) {
                console.log("Successfully created sport-place association");
                console.log(response)
                return response;
            }
            else {
                console.log("Failed to create sport-place association");
                console.log(response.status + " " + response.statusText);
                return Promise.reject(response);
            }
        })
        .catch(function (error) {
            console.log("create error");
            if (error.response) {
                console.log(error.response);
            }
            return Promise.reject(error);
        });
}