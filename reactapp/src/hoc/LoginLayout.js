import React from 'react';

const LoginLayout = (WrappedComponent) => {
    class HOC extends React.Component {
        render() {
            return (
                <div className="container-fluid h-100">
                    <div className="row align-items-center h-100">
                        <div className="col-sm-2 col-md-4"></div>
                        <div className="col-sm-8 col-md-4 col-xs-12">
                            <div className="card bg-light text-secondary">
                                <div className="card-body">
                                    <WrappedComponent />
                                </div>
                            </div>
                        </div>
                        <div className="col-sm-2 col-md-4"></div>
                    </div>
                </div>
            )
        }
    }
    return HOC;
}


export default LoginLayout;