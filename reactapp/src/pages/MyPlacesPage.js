import React, { Component } from 'react';
import './App.css';
import HomeLayout from '../_hoc/HomeLayout';
import { PlaceActions } from '../_actions/place-actions';
import { PlaceList } from '../_components/PlaceList';
import { AddPlace } from '../_components/AddPlace';
import { connect } from 'react-redux';


class MyPlaces extends Component {

    componentDidMount() {
        console.log('my places page');
        this.props.getPlaces(this.props.currentuser);
        this.props.getUserPlaces(this.props.currentuser);
    }

    render() {
        return (
        <div>
        <h2>My Places: </h2>
        <PlaceList places={this.props.userplaces} />
        <AddPlace/>
        </div> );        
    }
}

const mapStateToProps = state => ({
    currentuser: state.currentuser,
    places: state.places,
    userplaces: state.userplaces
});

const mapDispatchToProps = dispatch => {
    return {
        getPlaces: (user) => {
            dispatch(PlaceActions.getPlaces(user))
        },
        getUserPlaces: (user) => {
            dispatch(PlaceActions.getUserPlaces(user))
        },
    }
}

export const MyPlacesConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(MyPlaces)

export const MyPlacesPage = HomeLayout(MyPlacesConnected);