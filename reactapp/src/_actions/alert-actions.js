import { AlertConstants } from '../_constants';

export const AlertActions = {
    success,
    error,
    clear
}

function success(message){
    return {type : AlertConstants.SUCCESS, message : message};
}

function error(message){
    return {type : AlertConstants.ERROR, message : message};
}

function clear(message){
    return {type : AlertConstants.CLEAR, message : message};
}