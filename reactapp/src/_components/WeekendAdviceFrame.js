import React from 'react';
import { connect } from 'react-redux';
import {WeekendAdviceActions} from '../_actions';

class WeekendAdvice extends React.Component {

    componentDidMount() {
        this.props.load(this.props.user);
    }

    render(){
        let advice;

        console.log(this.props.weekendAdvice)
        if(this.props.weekendAdvice == null || this.props.weekendAdvice === "") {
            advice =(<div className="card-body"> <p className="card-text">No advice for this week end </p> </div>)
        } else {
            advice = (<div className="card-body">
            <p className="card-text">{this.props.weekendAdvice.place}</p>
            <p className="card-text">Practice : {this.props.weekendAdvice.sport}</p> 
            </div>
            )
        }

        return (
            <div className="card">
                {advice}
            </div>
        );
        }
}


const mapStateToProps = state => ({
    user: state.currentuser,
    weekendAdvice: state.weekendAdvice
});

const mapDispatchToProps = dispatch => {
    return {
        load: (user) => {
            dispatch(WeekendAdviceActions.load(user))
        }
    }
}

export const WeekendAdviceConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(WeekendAdvice)

export const WeekendAdviceFrame = WeekendAdviceConnected