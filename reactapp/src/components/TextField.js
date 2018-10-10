import React from 'react';

const TextField = (props) => (
    <div className="form-group">
        <label htmlFor={props.id} className="sr-only">{props.placeholder}</label>
        <input type={props.type} className="form-control textfield" id={props.id} aria-describedby={props.placeholder} placeholder={props.placeholder} />
    </div>
)

export default TextField;