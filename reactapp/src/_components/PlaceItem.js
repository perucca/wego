import React from 'react';
import { connect } from 'react-redux';
import { PlaceActions } from '../_actions/place-actions';

class PlaceItem extends React.Component {

    handleOnClickDelete = (event) => {
        event.preventDefault();
        this.props.deleteUserPlace(this.props.currentuser,this.props.iduserplace);
    }

    handleOnClickIncrease = (event) => {
        event.preventDefault();
        this.props.increaseUserPlacePreference(this.props.currentuser,this.props.iduserplace);
    }

    handleOnClickDecrease = (event) => {
        event.preventDefault();
        this.props.decreaseUserPlacePreference(this.props.currentuser,this.props.iduserplace);
    }

    render() {
        return (
            <div className="row w-100 list-group-item">
            <div className="d-inline float-left text-left col-6"> {this.props.preferenceorder} {this.props.name}</div>
            <div className="d-inline float-right text-right btn-group col-6">
                <button type="button" className="btn btn-secondary" onClick={this.handleOnClickIncrease}>↑</button>
                <button type="button" className="btn btn-secondary" onClick={this.handleOnClickDecrease}>↓</button>
                <button type="button" className="btn btn-secondary" onClick={this.handleOnClickDelete}>×</button>
            </div>
          </div>
        );        
    }
}


const mapStateToProps = state => ({
    currentuser: state.currentuser,
    userplaces: state.userplaces
});

const mapDispatchToProps = dispatch => {
    return {
        deleteUserPlace: (user, id)=>{
            dispatch(PlaceActions.deleteUserPlace(user, id))
        },
        increaseUserPlacePreference: (user, id)=>{
            dispatch(PlaceActions.increaseUserPlacePreference(user, id))
        },
        decreaseUserPlacePreference: (user, id)=>{
            dispatch(PlaceActions.decreaseUserPlacePreference(user, id))
        }
    }
}

export const PlaceItemConnected = connect(
     mapStateToProps,
     mapDispatchToProps)(PlaceItem);

