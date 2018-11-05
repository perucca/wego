import React from 'react';

export const Checkbox = (props) => (
    
        <div className="form-check">
            <input type="checkbox" className="form-check-input" value={props.value} id={props.id} checked={props.checked} onChange={props.handleChange}/>
            <label className="form-check-label" htmlFor={props.id}>{props.name}</label>
        </div>

)
