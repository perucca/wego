import React, { Component } from 'react';
import { MainLayout } from '../_hoc/MainLayout';
import { SportActions, PlaceActions, SportPlaceActions } from '../_actions';
import { connect } from 'react-redux';
import { ButtonForm, CustomSelectSports, Checkbox, Fab } from '../_components';
import { SortableContainer, SortableElement, arrayMove } from 'react-sortable-hoc';
import { Modal, ModalHeader, ModalBody } from 'reactstrap';
import icon from '../_img/cycling.svg';
import editBtn from '../_img/edit-button.svg';


const SortableItem = SortableElement(({ value, onClick }) =>
    <li className="list-group-item text-left">{value}<span><img className="edit-btn float-right" onClick={onClick} src={editBtn} alt="edit button"/></span></li>
);

const SortableList = SortableContainer(({ items, onClick }) => {
    return (
        <ul className="list-group">
            {items.map((value, index) => (
                <SortableItem key={`item-${index}`} index={index} value={value} onClick={onClick}/>
            ))}
        </ul>
    );
});

class MySports extends Component {

    constructor(props) {
        super(props);
        this.state = {
            newUserSport: {
                idUser: this.props.currentuser.id,
                idSport: null,
                preferenceOrder: null
            },
            newSportPlaceAssociation: {
                idUserSport: null,
                idUserPlace: null,
            },
            newPlaces: new Map(),
            spaBatch: [],
            availableUserPlaces: [],
            availableSports: [],
            userSports: [],
            modalCreation: false,
            modalEdition: false,
        };
    }

    componentDidMount() {
        console.log('my sport page');
        this.props.getSports(this.props.currentuser);
        this.props.getUserSports(this.props.currentuser);
        this.props.getUserPlaces(this.props.currentuser);
        this.props.readSportPlaceAssociations(this.props.currentuser);
        this.setState(previousState => ({ availableUserPlaces: [...previousState.availableUserPlaces, this.props.userplaces] }));
        this.setState(previousState => ({ availableSports: [...previousState.availableSports, this.props.sports] }));
        console.log(this.state);
    }

    resetState = () => {
        this.setState({
            newPlaces: new Map(),
            spaBatch: [],
            newUserSport: {
                idUser: this.props.currentuser.id,
                idSport: null,
                preferenceOrder: null
            },
        })
        this.setState(prevState => ({ newPlaces: prevState.newPlaces.set("1", false) }));
        this.setState(prevState => ({ newPlaces: prevState.newPlaces.set("2", false) }));
        console.log("RESET");
        console.log(this.state);
    }

    toggleModalCreation = () => {
        this.setState({
            modalCreation: !this.state.modalCreation
        });
      }

    toggleModalEdition = () => {
        console.log("EDIT")
        this.setState({
            modalEdition: !this.state.modalEdition
        });
      }

    handleSubmit = (event) => {
        event.preventDefault();
        const spa = [];
        for (let [key, value] of this.state.newPlaces) {
            if(value === true){
                spa.push({idUserSport:1, idUserPlace:key})
            }
          }
        console.log(spa);
        this.props.createUserSportWithSportPlaceAssociationBatch(this.props.currentuser, this.state.newUserSport, spa);
        this.toggleModalCreation();
    }

    handleAddUserSport = (e) => {
        this.setState({
            newUserSport: {
                idUser: this.props.currentuser.id,
                idSport: e.target.value,
                preferenceOrder: this.props.usersports.length + 1,
            }
        });
    }

    handleChange = (e) => {
        const change = this.state;
        change[e.target.name] = e.target.value;
        this.setState(change);
        console.log(this.state)
    }

    handleAddLocation = (e) => {
        const item = e.target.value;
        const isChecked = e.target.checked;
        this.setState(prevState => ({ newPlaces: prevState.newPlaces.set(item, isChecked) }));
        console.log(this.state);
    }

    onSortEnd = ({oldIndex, newIndex}) => {
        const prevItems = this.props.usersports.sort(function (a, b) {
            let prefA = a.preferenceOrder;
            let prefB = b.preferenceOrder;
            if (prefA < prefB) return -1;
            if (prefA > prefB) return 1;
            return 0;
        })
       const items = arrayMove(prevItems, oldIndex, newIndex);
       items.map((item,index) => item.preferenceOrder = index + 1);
       console.log("reorder");
       console.log(items);
       this.props.updateUserSportBatch(this.props.currentuser, items);
        
      };

    render() {
        return (
            <MainLayout title="Your Favorite Sports" icon={icon}>
                <div>
                    <SortableList items={this.props.usersports.sort(function (a, b) {
                        let prefA = a.preferenceOrder;
                        let prefB = b.preferenceOrder;
                        if (prefA < prefB) return -1;
                        if (prefA > prefB) return 1;
                        return 0;
                    })
                        .map((item) => item.sportDto.sportName)} onSortEnd={this.onSortEnd} onClick = {this.toggleModalEdition} distance={5}/>
                    <Fab dataToggle="modal" dataTarget="#modalAddSports" onClick={this.toggleModalCreation} />
                    <Modal isOpen={this.state.modalCreation} toggle={this.toggleModalCreation} centered={true} onOpened={this.resetState} onClosed={this.resetState} className="custom-modal">
                    <ModalHeader toggle={this.toggleModalCreation}>Add a sport</ModalHeader>
                    <ModalBody>
                        <form onSubmit={this.handleSubmit}>
                            <div className="form-group">
                                <CustomSelectSports options={this.props.sports.filter(sport => {
                                    let toKeep = true;
                                    this.props.usersports.forEach(element => {
                                        if(sport.id === element.sportDto.id){
                                            toKeep = false;
                                        }
                                    });
                                    return toKeep;
                                })} name="idnewUserSport" label="Sport" handleChange={this.handleAddUserSport} />
                            </div>
                            <div className="form-group">Select practice locations</div>
                            <div className="form-group">
                                {this.props.userplaces.map((place) =>
                                    <Checkbox key={place.idUserplace} id={place.idUserplace} value={place.idUserplace} name={place.placeDto.name} checked={this.state.newPlaces.get(place.idUserplace)} handleChange={this.handleAddLocation} />
                                )}
                            </div>
                            <ButtonForm name="Add Sport" type="submit" />
                        </form>
                        </ModalBody>
                    </Modal>

                    <Modal isOpen={this.state.modalEdition} toggle={this.toggleModalEdition} centered={true} onOpened={this.resetState} onClosed={this.resetState} className="custom-modal">
                    <ModalHeader toggle={this.toggleModalEdition}>Edit your sport</ModalHeader>
                    <ModalBody>
                        <form onSubmit={this.handleSubmit}>
                            <div className="form-group">Select practice locations</div>
                            <div className="form-group">
                                {this.props.userplaces.map((place) =>
                                    <Checkbox key={place.idUserplace} id={place.idUserplace} value={place.idUserplace} name={place.placeDto.name} checked={this.state.newPlaces.get(place.idUserplace)} handleChange={this.handleAddLocation} />
                                )}
                            </div>
                            <ButtonForm name="Save" type="submit" />
                        </form>
                        </ModalBody>
                    </Modal>
                </div>
            </MainLayout>
        )
    }
}

const mapStateToProps = state => ({
    currentuser: state.currentuser,
    sports: state.sports,
    usersports: state.usersports,
    userplaces: state.userplaces,
    sportplaceassociations: state.sportplaceassociations
});

const mapDispatchToProps = dispatch => {
    return {
        getSports: (user) => {
            dispatch(SportActions.getSports(user))
        },
        getUserSports: (user) => {
            dispatch(SportActions.getUserSports(user))
        },
        getUserPlaces: (user) => {
            dispatch(PlaceActions.getUserPlaces(user))
        },
        createUserSport: (user, userSport) => {
            dispatch(SportActions.createUserSport(user, userSport))
        },
        updateUserSportBatch: (user, userSportBatch) => {
            dispatch(SportActions.updateUserSportBatch(user, userSportBatch))
        },
        createUserSportWithSportPlaceAssociationBatch: (user, userSport, sportPlaceAssociationBatch) => {
            dispatch(SportPlaceActions.createUserSportWithSportPlaceAssociationBatch(user, userSport, sportPlaceAssociationBatch))
        },
        readSportPlaceAssociations: (user) => {
            dispatch(SportPlaceActions.readSportPlaceAssociations(user))
        },
        
    }
}

export const MySportsConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(MySports)

export const MySportsPage = MySportsConnected;