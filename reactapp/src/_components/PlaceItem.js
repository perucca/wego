import React from 'react';

export const PlaceItem = (props) => (
    <div className="row w-100 list-group-item">
            <div className="d-inline float-left text-left col-sm-6">{props.name}</div>
            <div className="d-inline float-right btn-group col-sm-6">
                <button type="button" class="btn btn-secondary" onClick="">↑</button>
                <button type="button" class="btn btn-secondary" onClick="">↓</button>
                <button type="button" class="btn btn-secondary" onClick="">×</button>
            </div>
    </div>
)