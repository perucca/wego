import React from 'react';
import { Link } from 'react-router-dom';

export const LinkedButton = (props) => (

    <Link className="btn btn-block btn-lg my-1" to={props.to}>
        {props.name}
    </Link>
)
