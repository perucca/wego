import React from 'react';
import { Link } from 'react-router-dom';

export const ButtonLinked = (props) => (

    <button type={props.type} className="btn btn-info btn-lg my-1">
        <Link to={props.to}>{props.name}</Link>
    </button>
)
