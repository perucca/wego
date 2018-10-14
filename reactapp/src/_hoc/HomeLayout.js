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
                        <div className="col-sm-2 col-md-4"></div>
                        <div className="col-sm-8 col-md-4 col-xs-12">
                            <WrappedComponent />
                        </div>
                        <div className="col-sm-2 col-md-4"></div>
                    </div>
                </div>
                </div>
            )
        }
    }
    return HOC;
}


export default HomeLayout;