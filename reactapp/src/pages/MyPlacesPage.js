import React from 'react';
import { Link } from 'react-router-dom';
import './App.css';
import HomeLayout from '../_hoc/HomeLayout';

const MyPlaces = () => (
    <div>
        MyPlaces tititi
    </div>
)

export const MyPlacesPage = HomeLayout(MyPlaces);