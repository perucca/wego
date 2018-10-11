import React from 'react';

export const ButtonForm = (props) => (
    <div className="form-group">
            <button type={props.type} className="btn btn-primary btn-block">{props.name}</button>
        </div>
)