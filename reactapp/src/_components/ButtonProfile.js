import React from 'react';

const ButtonProfile = (props) => (
    <div className="col-12">
            <a href={props.type} class="btn btn-info btn-lg my-1" role="button">{props.name}</a>
        </div>


)

export default ButtonProfile;