import React, { Component } from 'react';
import HomeLayout from '../_hoc/HomeLayout';
import { SportActions } from '../_actions';
import { connect } from 'react-redux';

class MySports extends Component {

    componentDidMount() {
        console.log('my sport page');
        this.props.getSports(this.props.currentuser);
        this.props.getUserSports(this.props.currentuser);
    }
    
    render() {
        return (
            <div>
                <div>MySports {this.props.currentuser.firstName}</div>

                <div>All Sports</div>

        <div>{this.props.sports.map(sport => <div>sport={sport.sportName}</div>)}</div>
        <div>My Sports</div>

        <div>{this.props.usersports.map(sport => <div>sport={sport.sportDto.sportName}</div>)}</div>
            </div>
        )
    }

}

const mapStateToProps = state => ({
    currentuser: state.currentuser,
    sports: state.sports,
    usersports: state.usersports
});

const mapDispatchToProps = dispatch => {
    return {
        getSports: (user) => {
            dispatch(SportActions.getSports(user))
        },
        getUserSports: (user) => {
            dispatch(SportActions.getUserSports(user))
        },
    }
}

export const MySportsConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(MySports)

export const MySportsPage = HomeLayout(MySportsConnected);