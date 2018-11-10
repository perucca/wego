import Axios from 'axios';

export const weekendAdviceService = {
    load,
}

//LOG THE USER
function load(user) {
    return Axios.get('/api/weekendadvice/', {
        headers : {'Authorization': '' + user.authorization}
    })
        .then(function (response) {
            if (response.status === 200) {
                console.log("Successfully fetched the weekendadvice");
                console.log(response)
                return response.data;
            }
            else {
                console.log("Failed fetching weekendAdvice");
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
