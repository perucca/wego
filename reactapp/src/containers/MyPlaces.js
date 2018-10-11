import React from 'react';
import { Link } from 'react-router-dom';
import './App.css';
import LoginLayout from '../hoc/LoginLayout';

const MyPlaces = () => (
    <div>
        MyPlaces tititi
    </div>
)

const MyPlacesInLayout = LoginLayout(MyPlaces);

export default MyPlacesInLayout;