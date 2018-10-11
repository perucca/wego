import React from 'react';
import { Link } from 'react-router-dom';
import './App.css';
import sun from '../_img/sun.png';
import LoginLayout from '../_hoc/LoginLayout';
import { ButtonLinked } from '../_components';

const Home = () => (
    <div className="dark">
        <h3> Welcome USER!</h3>   
        <div>
        <ButtonLinked name="My Places" type="button" to="/myplaces"></ButtonLinked>
        <ButtonLinked name="My Sports" type="button" to="/myplaces"></ButtonLinked>
        </div>
        <div className="jumbotron mw-100">
            {/* <div className="row"> */}
                {/* <div className="col-sm-3 col-md-2">
                    <img src={sun}></img>
                </div>
                <div className="col-sm-9 col-md-10 col-xs-12"> */}
                    <h4>Tips for the week-end</h4>
                {/* </div> */}
            {/* </div> */}
            <p>The weather will be perfect to go to PLACE and practice SPORT</p>
        </div>

</div>

)

export const HomePage = LoginLayout(Home);