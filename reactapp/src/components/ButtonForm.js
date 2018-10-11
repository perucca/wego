import React from 'react';

const ButtonForm = (props) => (
    <div className="form-group">
            <button type={props.type} className="btn btn-primary btn-block" onClick={props.onClick} >{props.name}</button>
        </div>
)

export default ButtonForm;