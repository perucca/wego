import React from 'react';
import { Link } from 'react-router-dom';
import './App.css';
import LoginLayout from '../hoc/LoginLayout'
import ButtonProfile from '../components/ButtonProfile';

const Home = () => (
    <div className="dark">
        <h3> Welcome User !</h3>   
        <div>
        <ButtonProfile name="My Places" type="myplaces"></ButtonProfile>
        <ButtonProfile name="My Sports" type="mysports"></ButtonProfile>
        </div>
        <div className="jumbotron mw-100">
            <h4>Conseil du Week-End</h4>
            <p>Cette semaine, la météo sera idéale à place.name pour pratiquer le/la place.sport</p>
        </div>
    </div>
)

const LoginInLayout = LoginLayout(Home);

export default LoginInLayout;