import React, { Component } from 'react';
import './App.css';
import {HomeLayout} from '../_hoc/HomeLayout';
import { LinkedButton, WeekendAdviceFrame } from '../_components';
import { connect } from 'react-redux';
import icon from '../_img/profile.svg';


class Home extends Component {

    componentDidMount() {
        console.log('my home page');
    }

    render(){ 
    return(
    <HomeLayout title={"Welcome " + this.props.currentuser.firstName} icon={icon}>
      <div className="dark homepage">
        <div>
            <LinkedButton name="My Places" type="button" to="/myplaces"></LinkedButton>
        </div>    
        <div>
            <LinkedButton name="My Sports" type="button" to="/mysports"></LinkedButton>
        </div>
        <WeekendAdviceFrame/>

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