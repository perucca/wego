import React from 'react';
import { Link } from 'react-router-dom';
import './App.css';
import HomeLayout from '../_hoc/HomeLayout';
import { PlaceList } from '../_components/PlaceList';
import Data from '../_helpers/mockdata'
import { AddPlace } from '../_components/AddPlace';

const MyPlaces = () => (
    <div>
        <PlaceList places={Data.userplaces} />
        <AddPlace></AddPlace>
    </div>
)

export const MyPlacesPage = HomeLayout(MyPlaces);