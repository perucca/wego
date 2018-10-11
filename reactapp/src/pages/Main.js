import React from 'react';
import {Switch, Route} from 'react-router-dom';
import {HomePage, LoginPage, SignInPage, ProfilePage, MyPlacesPage, MySportsPage} from '../pages';

const Main = () => (
    <main className="h-100">
        <Switch>
            <Route exact path="/home" component={HomePage} />
            <Route exact path="/" component={LoginPage} />
            <Route exact path="/login" component={LoginPage} />
            <Route exact path="/profile" component={ProfilePage} />
            <Route exact path="/mysports" component={MySportsPage} />
            <Route exact path="/signin" component={SignInPage} />
            <Route exact path="/myplaces" component={MyPlacesPage} />
        </Switch>
    </main>
)

export default Main;