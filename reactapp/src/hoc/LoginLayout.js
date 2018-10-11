import React from 'react';
import './LoginLayout.css';
import logo from '../img/WeGo-Logo-03.png';

const LoginLayout = (WrappedComponent) => {
    class HOC extends React.Component {
        render() {
            return (

                <div className="container-fluid h-100 custom-background-color">
                    <div className="row align-items-center justify-content-center h-25">
                        <div className="col">
                            <img className="logo" src={logo} alt="WeGo logo" />
                        </div>
                    </div>
                    <div className="row align-items-center h-50">
                        <div className="col-sm-2 col-md-5"></div>
                        <div className="col-sm-8 col-md-2 col-xs-12">
                            <WrappedComponent />

                        </div>
                        <div className="col-sm-2 col-md-5"></div>
                    </div>
                </div>
            )
        }
    }
    return HOC;
}


export default LoginLayout;