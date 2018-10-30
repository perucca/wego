import React, { Component } from 'react';
import HomeLayout from '../_hoc/HomeLayout';
import { SportActions, PlaceActions, SportPlaceActions } from '../_actions';
import { connect } from 'react-redux';
import { ButtonForm, CustomSelectSports, Modal, Checkbox, Accordion } from '../_components';

class MySports extends Component {

    constructor(props) {
        super(props);
        this.state = {
            newUserSport: {
                idUser: this.props.currentuser.id,
                idSport: null,
                preferenceOrder: null
            },
            newSportPlaceAssociation: {
                idUserSport: null,
                idUserPlace: null,
            },
            newPlaces: new Map(),
            spaBatch:[],
            availableUserPlaces: [],
            availableSports: [],
            userSports: []
        };
    }

    componentDidMount() {
        console.log('my sport page');
        this.props.getSports(this.props.currentuser);
        this.props.getUserSports(this.props.currentuser);
        this.props.getUserPlaces(this.props.currentuser);
        this.props.readSportPlaceAssociations(this.props.currentuser);
        this.setState(previousState => ({ availableUserPlaces: [...previousState.availableUserPlaces, this.props.userplaces] }));
        this.setState(previousState => ({ availableSports: [...previousState.availableSports, this.props.sports] }));
        console.log(this.state);
    }

    handleSubmit = (event) => {
        event.preventDefault();
        this.setState({
            newUserSport: {
                idUser: this.props.currentuser.id,
                idSport: this.props.usersports.length + 1,
                preferenceOrder: this.state.idnewUserSport
            },
            newSportPlaceAssociation: {
                idUserSport: null,
                idUserPlace: this.state.idUserPlace,
            },
        });

        this.state.newPlaces.forEach(location => {
            console.log("yolo" + location)
        });

        this.props.createUserSportWithSportPlaceAssociation(this.props.currentuser, this.state.newUserSport, this.state.newSportPlaceAssociation);
    }

    handleChange = (e) => {
        const change = this.state;
        change[e.target.name] = e.target.value;
        this.setState(change);
        console.log(this.state)
    }

    handleAddLocation = (e) => {
        const item = e.target.value;
        const isChecked = e.target.checked;
        this.setState(prevState => ({ newPlaces: prevState.newPlaces.set(item, isChecked) }));
        console.log(this.state);
    }
    
    resetState = () => {
        this.setState({
            newPlaces: new Map(),
            spaBatch:[],
            newUserSport: {
                idUser: this.props.currentuser.id,
                idSport: null,
                preferenceOrder: null
            },
        })
        // this.props.getUserPlaces(this.props.currentuser);
        this.setState(prevState => ({ newPlaces: prevState.newPlaces.set("1", false) }));
        this.setState(prevState => ({ newPlaces: prevState.newPlaces.set("2", false) }));
        console.log("reset");
        console.log(this.state);
    }

    render() {

        return (
            <div>
                <h2 className ="mb-4 mt-4">Manage Your Sports</h2>

                <Accordion us={this.props.usersports} spa={this.props.sportplaceassociations}/>

                <button className="btn mt-4" type="button" data-toggle="modal" data-target="#modalAddSports" onClick={this.resetState}>
                    Add Sport
                </button>

                <Modal title="Add a Sport">
                    <form onSubmit={this.handleSubmit}>
                        <div className="form-group">

                            <CustomSelectSports options={this.props.sports} name="idnewUserSport" label="Sport" handleChange={this.handleChange} />
                        </div>
                        <div className="form-group">Add practice locations</div>
                        <div className="form-group">
                            {this.props.userplaces.map((place) =>
                                <Checkbox key={place.idUserplace} id={place.idUserplace} value={place.idUserplace} name={place.placeDto.name} checked={this.state.newPlaces.get(place.idUserplace)} handleChange={this.handleAddLocation} />
                            )}
                        </div>
                        <ButtonForm name="Add Sport" type="submit" />

                    </form>
                </Modal>
            </div>
        )
    }
}

const mapStateToProps = state => ({
    currentuser: state.currentuser,
    sports: state.sports,
    usersports: state.usersports,
    userplaces: state.userplaces,
    sportplaceassociations: state.sportplaceassociations
});

const mapDispatchToProps = dispatch => {
    return {
        getSports: (user) => {
            dispatch(SportActions.getSports(user))
        },
        getUserSports: (user) => {
            dispatch(SportActions.getUserSports(user))
        },
        getUserPlaces: (user) => {
            dispatch(PlaceActions.getUserPlaces(user))
        },
        createUserSport: (user, userSport) => {
            dispatch(SportActions.createUserSport(user, userSport))
        },
        createUserSportWithSportPlaceAssociation: (user, userSport, sportPlaceAssociation) => {
            dispatch(SportPlaceActions.createUserSportWithSportPlaceAssociation(user, userSport, sportPlaceAssociation))
        },
        readSportPlaceAssociations: (user) => {
            dispatch(SportPlaceActions.readSportPlaceAssociations(user))
        },
    }
}

export const MySportsConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(MySports)

export const MySportsPage = HomeLayout(MySportsConnected);