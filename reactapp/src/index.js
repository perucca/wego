import 'bootstrap/dist/css/bootstrap.min.css';
import $ from 'jquery';
import Popper from 'popper.js';
import 'bootstrap/dist/js/bootstrap.bundle.min';
// pour plus d'info sur bootstrap : https://blog.logrocket.com/how-to-use-bootstrap-with-react-a354715d1121
import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './pages/App';
import * as serviceWorker from './serviceWorker';
import { Router } from 'react-router-dom';
import { history } from './_helpers';
import {Provider} from 'react-redux';
import Data from './_helpers/mockdata'
import {configureStore } from './_helpers';


const store = configureStore({
    users: Data.users,
    places: Data.places,
    sports: Data.sports,
    userplaces : [],
    usersports : [],
    sportplaceassociation : Data.sportplaceassociation,
    currentuser : {},
    isAuthenticated: false
});

ReactDOM.render((
    <Router history={history}>
        <Provider store={store}>
        <App />
        </Provider>
    </Router>

), document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
