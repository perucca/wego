import React from 'react';

export const Modal = (props) => (
    <div className="modal fade" id="modalAddSports" tabIndex="-1" role="dialog" aria-labelledby="modalAddSports" aria-hidden="true">
        <div className="modal-dialog modal-dialog-centered" role="document">
            <div className="modal-content">
                <div className="modal-header">
                    <h5 className="modal-title" id="exampleModalLabel">{props.title}</h5>
                    <button type="button" className="close" data-dismiss="modal" aria-label="Close" onClick={props.onClick}>
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div className="modal-body" style={{textAlign: 'left'}}>
                    {props.children}
                </div>
            </div>
        </div>
    </div>
)
