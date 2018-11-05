import React from 'react';
import { PlaceItemConnected } from './PlaceItem';

export const PlaceList = (props) => (
    <div className="list-group">
            {props.places.map(i => <PlaceItemConnected key={i.idUserplace} iduserplace={i.idUserplace} preferenceorder={i.preferenceOrder} name={i.placeDto.name}/>)}
    </div>
)
