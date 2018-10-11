import React from 'react';

export const Checkbox = (props) => (
    <div className="form-group">
        <div className="form-check">
            <input type="checkbox" className="form-check-input" id={props.id} />
            <label className="form-check-label" htmlFor={props.id}>{props.value}</label>
        </div>
    </div>
)
