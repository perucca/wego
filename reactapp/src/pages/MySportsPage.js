import React, { Component } from 'react';
import { MainLayout } from '../_hoc/MainLayout';
import { SportActions, PlaceActions, SportPlaceActions } from '../_actions';
import { connect } from 'react-redux';
import { ButtonForm, CustomSelectSports, Checkbox, Fab } from '../_components';
import { SortableContainer, SortableElement, arrayMove } from 'react-sortable-hoc';
import { Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';

const SortableItem = SortableElement(({ value }) =>
    <li className="list-group-item text-left">{value}</li>
);

const SortableList = SortableContainer(({ items }) => {
    return (
        <ul className="list-group">
            {items.map((value, index) => (
                <SortableItem key={`item-${index}`} index={index} value={value} />
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
            modal: false
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
        // this.props.getUserPlaces(this.props.currentuser);
        this.setState(prevState => ({ newPlaces: prevState.newPlaces.set("1", false) }));
        this.setState(prevState => ({ newPlaces: prevState.newPlaces.set("2", false) }));
        console.log("reset");
        console.log(this.state);
    }

    toggle = () => {
        this.setState({
          modal: !this.state.modal
        });
      }

    handleSubmit = (event) => {
        event.preventDefault();
        this.setState({
            newUserSport: {
                idUser: this.props.currentuser.id,
                idSport: this.props.usersports.length + 1,
                preferenceOrder: this.state.idnewUserSport
            },
            newSportPlaceAssociation: {
                idUserSport: null,
                idUserPlace: this.state.idUserPlace,
            },
        });

        this.state.newPlaces.forEach(location => {
            console.log("yolo" + location)
        });

        this.props.createUserSportWithSportPlaceAssociation(this.props.currentuser, this.state.newUserSport, this.state.newSportPlaceAssociation);
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
        console.log("YOLOOOOOOOOOOOOOOOOOOOOOO");
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
            <MainLayout title="Your Favorite Sports">
                <div>
                    <SortableList items={this.props.usersports.sort(function (a, b) {
                        let prefA = a.preferenceOrder;
                        let prefB = b.preferenceOrder;
                        if (prefA < prefB) return -1;
                        if (prefA > prefB) return 1;
                        return 0;
                    })
                        .map((item) => item.sportDto.sportName)} onSortEnd={this.onSortEnd} />


                    <Fab dataToggle="modal" dataTarget="#modalAddSports" onClick={this.toggle} />


                    <Modal isOpen={this.state.modal} toggle={this.toggle}>
                    <ModalHeader toggle={this.toggle}>Add a Favorite Sport</ModalHeader>
                    <ModalBody>
                        <form onSubmit={this.handleSubmit}>
                            <div className="form-group">
                                <CustomSelectSports options={this.props.sports} name="idnewUserSport" label="Sport" handleChange={this.handleChange} />
                            </div>
                            <div className="form-group">Add practice locations</div>
                            <div className="form-group">
                                {this.props.userplaces.map((place) =>
                                    <Checkbox key={place.idUserplace} id={place.idUserplace} value={place.idUserplace} name={place.placeDto.name} checked={this.state.newPlaces.get(place.idUserplace)} handleChange={this.handleAddLocation} />
                                )}
                            </div>
                            <ButtonForm name="Add Sport" type="submit" />
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
        createUserSportWithSportPlaceAssociation: (user, userSport, sportPlaceAssociation) => {
            dispatch(SportPlaceActions.createUserSportWithSportPlaceAssociation(user, userSport, sportPlaceAssociation))
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