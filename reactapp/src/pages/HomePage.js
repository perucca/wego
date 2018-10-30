import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import './App.css';
import sun from '../_img/sun.png';
import HomeLayout from '../_hoc/HomeLayout';
import { LinkedButton } from '../_components';
import { connect } from 'react-redux';

class Home extends Component {

    componentDidMount() {
        console.log('my home page');
    }

    render(){ 
    return(
      <div className="dark homepage">
        <h3> Welcome {this.props.currentuser.firstName} !</h3>
        <div>
            <LinkedButton name="My Places" type="button" to="/myplaces"></LinkedButton>
        </div>    
        <div>
            <LinkedButton name="My Sports" type="button" to="/mysports"></LinkedButton>
        </div>
        <div className="card">
            <div className="card-body">
                <h4 className="card-title">Tips for the week-end</h4>
                <p className="card-text">The weather will be perfect to go to PLACE and practice SPORT</p>
            </div>
        </div>

    </div>
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

export const HomePage = HomeLayout(HomeConnected);