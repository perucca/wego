import React, { Component } from 'react';
import './App.css';
import HomeLayout from '../_hoc/HomeLayout';
import { PlaceActions } from '../_actions/place-actions';
import { PlaceList } from '../_components/PlaceList';
import { ButtonForm, CustomSelectNewPlace, Modal } from '../_components';
import { connect } from 'react-redux';


class MyPlaces extends Component {
    constructor(props) {
        super(props);
        this.state = {
            newUserPlace: {
                idUser: this.props.currentuser.id,
                idPlace : null,
                preferenceOrder: null
            },
            searchedCityName: ""
        };
    }

    componentDidMount() {
        console.log('my places page');
        this.props.getUserPlaces(this.props.currentuser);
    }

    handleChangeUserPlace = (event) => {
        this.setState({newUserPlace: {idUser: this.state.newUserPlace.idUser, idPlace: event.target.value, preferenceOrder: this.state.newUserPlace.preferenceOrder}, searchedCityName:this.state.searchedCityName});
        console.log("l'id de la place selectionnée est " + event.target.value)
    }

    handleSubmitUserPlace = (event) => {
        event.preventDefault();
        if (this.state.newUserPlace.idPlace !=null){
            this.state.newUserPlace.preferenceOrder = this.props.userplaces.length + 1;
            this.props.createUserPlace(this.props.currentuser, this.state.newUserPlace);
        }
        console.log(this.state);
        this.setState({newUserPlace: {idUser: this.state.newUserPlace.idUser, idPlace:null, preferenceOrder:null}, searchedCityName:""});
    }

    handleChangeCityName = (e) => {
        this.setState({newUserPlace: this.state.newUserPlace, searchedCityName:e.target.value});
        console.log(this.state)
    }

    handleSubmitCityName = (e) => {
        e.preventDefault();
        if (this.state.searchedCityName!==""){
            this.props.searchPlace(this.props.currentuser, this.state.searchedCityName);
            console.log("on va chercher en base : " + this.state.searchedCityName);
            this.setState({newUserPlace: this.state.newUserPlace, searchedCityName:""});
        }  
    }

    render() {
        return (
        <div>
        <h2>My Places: </h2>
        <PlaceList places={this.props.userplaces.sort((a,b)=>a.preferenceOrder>b.preferenceOrder)} />
        <button type="button" className="btn" data-toggle="modal" data-target="#modalAddSports">
                    Add a place
        </button>
        <Modal title="Add a new Place">
            <form onSubmit={this.handleSubmitCityName}>
                <div className="form-group">First, search a place name</div>
                <div className="form-group row w-100">
                    <div className="d-inline col-1"></div>
                    <input className="d-inline float-center text-left col-8 input-group" placeholder="Place Name" type="text" value={this.state.searchedCityName} onChange={this.handleChangeCityName}/>  
                    <button className="d-inline float-right text-center col-3" type="submit" className="btn">Search</button>
                </div>
            </form>    

            <form onSubmit={this.handleSubmitUserPlace}>
                <div className="form-group">Then, select the right place in the list</div>
                <CustomSelectNewPlace options={this.props.places}  name="idPlace" label="Location" handleChange={this.handleChangeUserPlace} />
                <ButtonForm name="Add Place" type="submit" />
            </form>
        </Modal>
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
        searchPlace: (user, cityname) => {
            dispatch(PlaceActions.searchPlace(user, cityname))
        },
        createUserPlace: (user, place) => {
            dispatch(PlaceActions.createUserPlace(user, place))
        }
    }
}

export const MyPlacesConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(MyPlaces)

export const MyPlacesPage = HomeLayout(MyPlacesConnected);