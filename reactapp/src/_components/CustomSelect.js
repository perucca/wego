import React from 'react';

export const CustomSelectSports = (props) => (
    <div className="input-group">
        <div className="input-group-prepend">
            <label className="input-group-text" htmlFor="selectOptions">{props.label}</label>
        </div>
        <select className="custom-select" id="selectOptions" name={props.name} value={props.value} onChange={props.handleChange}>
            <option value="" disabled selected hidden>Choose...</option>
            {props.options.map(i => <option key={i.id} value={i.id}>{i.sportName}</option>)}
        </select>
    </div>
)

export const CustomSelectPlaces = (props) => (
    <div className="input-group">
        <div className="input-group-prepend">
            <label className="input-group-text" htmlFor="selectOptions">{props.label}</label>
        </div>
        <select className="custom-select" id="selectOptions" name={props.name} value={props.value} onChange={props.handleChange}>
            <option value="" disabled selected hidden>Choose...</option>
            {props.options.map(i => <option key={i.idUserplace} value={i.idUserplace}>{i.placeDto.name}</option>)}
        </select>
    </div>
)