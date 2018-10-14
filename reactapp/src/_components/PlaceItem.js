import React from 'react';

export const PlaceItem = (props) => (
    <div className="row w-100 list-group-item">
            <div className="d-inline float-left text-left col-6">{props.name}</div>
            <div className="d-inline float-right text-right btn-group col-6">
                <button type="button" className="btn btn-secondary" onClick="">↑</button>
                <button type="button" className="btn btn-secondary" onClick="">↓</button>
                <button type="button" className="btn btn-secondary" onClick="">×</button>
            </div>
    </div>
)