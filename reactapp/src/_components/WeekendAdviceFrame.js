import React from 'react';
import { connect } from 'react-redux';
import {WeekendAdviceActions} from '../_actions';
import clear from '../_img/weather/animated/day.svg';
import rain from '../_img/weather/animated/rainy-6.svg';
import cloudy from '../_img/weather/animated/cloudy.svg';
import snow from '../_img/weather/animated/snowy-6.svg';

class WeekendAdvice extends React.Component {

    componentDidMount() {
        this.props.load(this.props.user);
    }

    getImage = () => {
        switch(this.props.weekendAdvice.weather) {
            case 'CLEAR':
                return clear;
            case 'RAIN':
                return rain;
            case 'CLOUDS':
                return cloudy;
            case 'SNOW':
                return snow;
            default:
                return clear;
        }
    }

    render(){
        let advice;
        if(this.props.weekendAdvice == null || this.props.weekendAdvice === "") {
            advice =(<div className="card-body"> <p className="card-text">No advice for this week end </p> </div>)
        } else {
            advice = (
                <div className="card-body"> 
                <p className="car-text">Place: {this.props.weekendAdvice.place}</p>
                <p className="car-text ">Practice : {this.props.weekendAdvice.sport}</p> 
                <img src={this.getImage()} className=".img-fluid" alt=""/>
                <p className="card-text">T°: {this.props.weekendAdvice.temperature} °C</p>
                <p className="card-text">Wind: {this.props.weekendAdvice.wind} km/h</p>
            </div>
            
            )
        }

        return (
            <div className="card">
                <h6 className="card-header">Tip for the Week-End</h6>
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