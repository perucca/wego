import React from 'react';
import './HomeLayout.css';
import { Header } from '../_components';

const HomeLayout = (WrappedComponent) => {
    class HOC extends React.Component {
        render() {
            return (
                <div className="h-100 home-layout">
                    <Header />
                <div className="container-fluid h-100">
                    <div className="row align-items-center h-50">
                        <div className="col-sm-1 col-md-2 col-lg-3"></div>
                        <div className="col-xs-12 col-sm-10 col-md-8 col-lg-6">
                            <WrappedComponent />
                        </div>
                        <div className="col-sm-1 col-md-2  col-lg-3" ></div>
                    </div>
                </div>
                </div>
            )
        }
    }
    return HOC;
}


export default HomeLayout;