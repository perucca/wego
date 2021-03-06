import React from 'react';

export const TextField = (props) => (
    <div className="form-group">
        <label htmlFor={props.id} className="sr-only">{props.placeholder}</label>
        <input name={props.name} type={props.type} className="form-control textfield" id={props.id} aria-describedby={props.placeholder} placeholder={props.placeholder} onChange={props.onChange} value={props.value}/>
    </div>
)

