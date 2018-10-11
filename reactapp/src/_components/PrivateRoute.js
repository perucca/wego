import React from 'react';
import {Route, Redirect} from 'react-router-dom';
import { connect } from 'react-redux';

export const PrivateRouteBase = ({component: Component, ...rest})=>(
    <Route {...rest} render = {(props) =>(
        
        rest.isAuthenticated === true
        ? <Component {...props} />
        : <Redirect to='/login' />

    )}/>
)

const mapStateToProps = state => ({
    isAuthenticated: state.isAuthenticated,
  });

  export const PrivateRoute = connect(
    mapStateToProps,
    null)(PrivateRouteBase)
  