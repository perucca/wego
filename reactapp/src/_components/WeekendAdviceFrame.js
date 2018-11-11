import React from 'react';
import { connect } from 'react-redux';
import { WeekendAdviceActions } from '../_actions';
import clear from '../_img/weather/animated/day.svg';
import rain from '../_img/weather/animated/rainy-6.svg';
import cloudy from '../_img/weather/animated/cloudy.svg';
import snow from '../_img/weather/animated/snowy-6.svg';

class WeekendAdvice extends React.Component {

    componentDidMount() {
        this.props.load(this.props.user);
    }

    getImage = () => {
        switch (this.props.weekendAdvice.weather) {
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

    componentDidUpdate() {
        console.log("WEATHER", this.props.weekendAdvice)
    }

    render() {
        let advice;
        if (this.props.weekendAdvice == null || this.props.weekendAdvice === "" || Object.keys(this.props.weekendAdvice).length === 0) {
            advice = (
                <div className="p-3 d-flex align-items-center mb-5 mt-4">
                    <div><em>We do not have any suggestions for this weekend</em></div>
                </div>)
        } else {
            advice = (
                <div className="p-3 d-flex align-items-center mb-5 mt-4">
                    <div><img src={this.getImage()} className=".img-fluid icon-weather" alt="" /></div>
                    <div className="text-left">This weekend, we suggest you to practice <strong>{this.props.weekendAdvice.sport}</strong> in <strong>{this.props.weekendAdvice.place}</strong>
                        <br /><span className="secondary-text">({this.props.weekendAdvice.temperature} °C - wind: {this.props.weekendAdvice.wind} km/h)</span>
                    </div>
                </div>
            )
        }
        return advice;
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