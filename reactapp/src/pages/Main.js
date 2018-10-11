import React from 'react';
import {Switch, Route} from 'react-router-dom';
import {HomePage, LoginPage, SignInPage, ProfilePage, MyPlacesPage, MySportsPage} from '../pages';
import { PrivateRoute } from '../_components';


const Main = (props) => (
    <main className="h-100">
        <Switch>
            <Route exact path="/" component={LoginPage} />
            <Route exact path="/login" component={LoginPage} />
            <Route exact path="/profile" component={ProfilePage} />
            <Route exact path="/mysports" component={MySportsPage} />
            <Route exact path="/signin" component={SignInPage} />
            <PrivateRoute exact path="/home" component={HomePage} name="coco"/>
            <PrivateRoute exact path="/myplaces" component={MyPlacesPage}/>
        </Switch>
    </main>
)

  
  export default Main;