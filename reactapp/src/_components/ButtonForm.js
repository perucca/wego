import React from 'react';

export const ButtonForm = (props) => (
    <div className="form-group">
            <button type={props.type} className="btn btn-primary btn-block" onClick={props.onClick} data-toggle={props.dataToggle} data-target={props.dataTarget}>{props.name}</button>
        </div>
)