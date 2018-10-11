import React from 'react';
import {Switch, Route} from 'react-router-dom';
import Home from './Home'
import MySports from './MySports';
import Profile from './Profile';
import Login from './Login';
import SignIn from './SignIn';

const Main = () => (
    <main className="h-100">
        <Switch>
            <Route exact path="/home" component={Home} />
            <Route exact path="/" component={Login} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/profile" component={Profile} />
            <Route exact path="/mysports" component={MySports} />
            <Route exact path="/signin" component={SignIn} />
        </Switch>
    </main>
)

export default Main;