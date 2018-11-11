import React, { Component } from 'react';
import './App.css';
import {HomeLayout} from '../_hoc/HomeLayout';
import { LinkedButton, WeekendAdviceFrame } from '../_components';
import { connect } from 'react-redux';
import icon from '../_img/profile.svg';
import iconSports from '../_img/cycling-orange.svg';
import iconPlaces from '../_img/place-orange.svg';


class Home extends Component {

    componentDidMount() {
        console.log('my home page');
    }

    render(){ 
    return(
    <HomeLayout title={"Welcome " + this.props.currentuser.firstName} icon={icon}>
      <div className="dark homepage">
      <WeekendAdviceFrame/>
        <div>
            <LinkedButton name="Places" type="button" to="/myplaces" icon={iconPlaces} info={"Manage the list of your favorite places"}></LinkedButton>
        </div>    
        <div>
            <LinkedButton name="Sports" type="button" to="/mysports" icon={iconSports} info={"Manage the list of your favorite sports"}></LinkedButton>
        </div>
        
    </div>
    </HomeLayout>
    );
    }
}

const mapStateToProps = state => ({
    currentuser: state.currentuser,
});

const mapDispatchToProps = dispatch => ({});

export const HomeConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(Home)

export const HomePage = HomeConnected;