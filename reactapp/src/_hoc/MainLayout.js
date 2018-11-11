import React from 'react';
import './MainLayout.css';
import { Header } from '../_components';

export const MainLayout = (props) => (

    <div className="h-100 main-layout d-flex flex-column">
        <Header />
        <div className="container-fluid h-100">
            <div className="title-section row text-center">
                <h4 className="ml-auto mr-auto mt-4">{props.title}</h4>
            </div>
            <div className="page-icon">
                <img src={props.icon} alt="page icon"/>
            </div>
         
            <div className="row align-items-top">
                <div className="col-sm-1 col-md-2 col-lg-3"></div>
                <div className="col-xs-12 col-sm-10 col-md-8 col-lg-6">
                    {props.children}
                </div>
                <div className="col-sm-1 col-md-2  col-lg-3" ></div>
            </div>
        </div>
    </div>
)