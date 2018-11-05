import React from 'react';

export const Fab = (props) => {

    const fab = {
        backgroundColor: 'orange',
        color: 'white',
        fontSize: '2.5rem',
        padding: '0rem',
        border: 'none',
        borderRadius: '50%',
        width: '4rem',
        height: '4rem',
        position: 'fixed',
        bottom: '1rem',
        right: '1rem',
        boxShadow: '0 0 0.3rem 0.05rem #a4a4a4'
    };
    return (
        <button className="btn" style={fab} type="button" data-toggle={props.dataToggle} data-target={props.dataTarget} onClick={props.onClick}>
            +
        </button>

    )
}