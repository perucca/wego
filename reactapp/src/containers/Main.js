import React from 'react';
import {Switch, Route} from 'react-router-dom';
import Home from './Home'
import MySports from './MySports';
import Profile from './Profile';
import Login from './Login';

const Main = () => (
    <main>
        <Switch>
            <Route exact path="/home" component={Home} />
            <Route exact path="/" component={Login} />
            <Route exact path="/profile" component={Profile} />
            <Route exact path="/mysports" component={MySports} />
        </Switch>
    </main>
)

export default Main;