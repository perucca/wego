import React from 'react';
import './HomeLayout.css';
import { Header } from '../_components';

export const HomeLayout = (props) => (

    <div className="h-100 home-layout d-flex flex-column">
        <Header />
        <div className="container-fluid fill-flex">
            <div className="title-section row text-center">
                <h3 className="ml-auto mr-auto mt-4">{props.title}</h3>
            </div>
            <div className="page-icon">
                <img src={props.icon} alt="page icon"/>
            </div>
         
            <div className="row align-items-center h-50">
                <div className="col-sm-1 col-md-2 col-lg-3"></div>
                <div className="col-xs-12 col-sm-10 col-md-8 col-lg-6">
                    {props.children}
                </div>
                <div className="col-sm-1 col-md-2  col-lg-3" ></div>
            </div>
        </div>
    </div>
)