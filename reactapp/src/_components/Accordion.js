import React from 'react';

export const Accordion = (props) => (
    <div id="accordion">
        {props.us.map(us => {
            const headingId = 'heading' + us.idUserSport;
            const collapseId = 'collapse' + us.idUserSport;
            const refCollapseId = '#' + collapseId;
            const itemSportName = us.sportDto.sportName;
            const spaList = props.spa;
            console.log(spaList)

            const buttonStyle = {
                background: 'none',
                border: 'none',
                width: '100%'
              };
              
            return (
                <div className="card" key={us.idUserSport}>
                    <div className="card-header" id={headingId}>
                        <h5 className="mb-0">
                            <button className="" style= {buttonStyle} data-toggle="collapse" data-target={refCollapseId} aria-expanded="true" aria-controls={collapseId}>
                                {itemSportName}
                     </button>
                        </h5>
                    </div>
                    <div id={collapseId} className="collapse show" aria-labelledby={headingId} data-parent="#accordion">
                        <div className="card-body">
                            {spaList
                                .filter((spa) => spa.userSportDtoRead.idUserSport === us.idUserSport)
                                .map((spa) => <p className="mb-0" key={spa.id}>{spa.userPlaceDtoRead.placeDto.name}</p>)}
                        </div>
                    </div>
                </div>
            )
        }
        )}

    </div>
)
