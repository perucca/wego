import React from 'react';
import { Link } from 'react-router-dom';
import './App.css';
import sun from '../_img/sun.png';
import HomeLayout from '../_hoc/HomeLayout';
import { ButtonLinked } from '../_components';


const Home = () => (
    <div className="dark">
        <h3> Welcome USER!</h3>
        <div>
            <ButtonLinked name="My Places" type="button" to="/myplaces"></ButtonLinked>
            <ButtonLinked name="My Sports" type="button" to="/mysports"></ButtonLinked>
        </div>
        <div className="card">
            <div className="card-body">
                <h4 className="card-title">Tips for the week-end</h4>
                <p className="card-text">The weather will be perfect to go to PLACE and practice SPORT</p>
            </div>
        </div>

    </div>

)

export const HomePage = HomeLayout(Home);