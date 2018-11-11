import React from 'react';
import { Link } from 'react-router-dom';

export const LinkedButton = (props) => (

    <Link className="card btn btn-lg my-1 mt-3 mb-3" to={props.to}>
        <div className="d-flex align-items-center">
            <div><img src={props.icon} className="icon-menu" alt="" /></div>
            <div className="text-left ml-3"><strong>{props.name}</strong>
                <br /><span className="secondary-text">{props.info}</span>
            </div>
        </div>
    </Link>
)