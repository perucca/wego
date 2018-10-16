import React from 'react';
import { PlaceItem } from './PlaceItem';

export const PlaceList = (props) => (
    <div className="list-group">
            {props.places.map(i => <PlaceItem name={i.placeDto.name}/>)}
    </div>
)
