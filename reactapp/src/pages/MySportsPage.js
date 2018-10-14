import React, { Component } from 'react';
import HomeLayout from '../_hoc/HomeLayout';
import { SportActions } from '../_actions';
import { connect } from 'react-redux';

class MySports extends Component {

    componentDidMount() {
        console.log('my sport page');
        console.log(this.props.currentuser);
        this.props.getSports(this.props.currentuser);
        console.log(this.props.sports);
    }
    render() {
        return (
            <div>
                MySports tototo

        {this.props.sports.map(sport => <div>sport={sport.sportName}</div>)}
            </div>
        )
    }

}

const mapStateToProps = state => ({
    currentuser: state.currentuser,
    sports: state.sports,
});

const mapDispatchToProps = dispatch => {
    return {
        getSports: (user) => {
            dispatch(SportActions.getSports(user))
        }
    }
}

export const MySportsConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(MySports)

export const MySportsPage = HomeLayout(MySportsConnected);