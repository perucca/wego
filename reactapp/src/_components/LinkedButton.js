import React from 'react';
import { Link } from 'react-router-dom';

export const LinkedButton = (props) => (

    <Link type={props.type} className="btn btn-info btn-lg my-1" to={props.to}>
        {props.name}
    </Link>
)
