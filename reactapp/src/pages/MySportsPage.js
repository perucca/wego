import React, { Component } from 'react';
import HomeLayout from '../_hoc/HomeLayout';
import { SportActions, PlaceActions, SportPlaceActions } from '../_actions';
import { connect } from 'react-redux';
import { ButtonForm, CustomSelectSports, CustomSelectPlaces, Modal } from '../_components';

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
        };
    }

    componentDidMount() {
        console.log('my sport page');
        this.props.getSports(this.props.currentuser);
        this.props.getUserSports(this.props.currentuser);
        this.props.getUserPlaces(this.props.currentuser);
        this.props.readSportPlaceAssociations(this.props.currentuser);
    }

    handleSubmit = (event) => {
        event.preventDefault();
        this.state.newUserSport.preferenceOrder = this.props.usersports.length + 1;
        this.state.newUserSport.idSport = this.state.idnewUserSport;
        this.state.newSportPlaceAssociation.idUserPlace = this.state.idUserPlace;
        console.log(this.state.newUserSport);
        console.log(this.state.newSportPlaceAssociation);
        this.props.createSportPlaceAssociation(this.props.currentuser, this.state.newUserSport, this.state.newSportPlaceAssociation);
    }

    handleChange = (e) => {
        const change = this.state;
        change[e.target.name] = e.target.value;
        this.setState(change);
        console.log(this.state)
    }

    render() {

        return (
            <div>
                <div>MySports {this.props.currentuser.firstName}</div>

                <div>{this.props.usersports.map(sport => <div>{sport.sportDto.sportName}</div>)}</div>

                <button type="button" className="btn" data-toggle="modal" data-target="#modalAddSports">
                    Add Sports
                </button>

                <Modal title="Add a Sport">
                    <form onSubmit={this.handleSubmit}>
                        <div className="form-group">
                            <CustomSelectSports options={this.props.sports} name="idnewUserSport" label="Sports" handleChange={this.handleChange} />
                        </div>
                        <div className="form-group">Add practice Locations</div>
                        <div className="form-group">
                            <CustomSelectPlaces options={this.props.userplaces}  name="idUserPlace" label="Location" handleChange={this.handleChange} />
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
        createSportPlaceAssociation: (user, userSport, sportPlaceAssociation) => {
            dispatch(SportPlaceActions.createSportPlaceAssociation(user, userSport, sportPlaceAssociation))
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