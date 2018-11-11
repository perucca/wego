import React, { Component } from 'react';
import './App.css';
import { MainLayout } from '../_hoc/MainLayout';
import { PlaceActions } from '../_actions/place-actions';
import icon from '../_img/place.svg';
import { ButtonForm, CustomSelectNewPlace } from '../_components';
import { SortableContainer, SortableElement, arrayMove } from 'react-sortable-hoc';
import { Fab } from '../_components';
import { connect } from 'react-redux';
import deleteBtn from '../_img/trash.svg';
import { Modal, ModalHeader, ModalBody } from 'reactstrap';
import Select from 'react-select';
import AsyncSelect from 'react-select/lib/Async';

const SortableItem = SortableElement(({ value, onClick }) => {
    return (
        <li className="list-group-item text-left">{value.placeDto.name}
            <span><img className="edit-btn float-right" onClick={(e) => onClick(e, value.idUserplace)} src={deleteBtn} alt="delete button" /></span>
        </li>
    )
});

const SortableList = SortableContainer(({ items, onClick }) => {
    return (
        <ul className="list-group">
            {items.map((value, index) => (
                <SortableItem key={`item-${index}`} index={index} value={value} onClick={onClick} />
            ))}
        </ul>
    );
});


class MyPlaces extends Component {
    constructor(props) {
        super(props);
        this.state = {
            newUserPlace: {
                idUser: this.props.currentuser.id,
                idPlace: null,
                preferenceOrder: null
            },
            searchedCityName: "",
            modalCreation: false,
        };
    }

    toggleModalCreation = () => {
        this.setState({
            modalCreation: !this.state.modalCreation
        });
    }

    componentDidMount() {
        console.log('my places page');
        this.props.getUserPlaces(this.props.currentuser);
    }

    handleChangeCityName = (e) => {
        this.setState({ newUserPlace: this.state.newUserPlace, searchedCityName: e.target.value });
    }

    onClickDelete = (e, idUserPlace) => {
        console.log(idUserPlace)
        e.preventDefault();
        this.props.deleteUserPlace(this.props.currentuser, idUserPlace);
    }

    handleSubmitCityName = (e) => {
        e.preventDefault();
        if (this.state.searchedCityName !== "") {
            this.props.searchPlace(this.props.currentuser, this.state.searchedCityName);
        }
    }

    handleChangeUserPlace = (event) => {
        this.setState({ newUserPlace: { idUser: this.state.newUserPlace.idUser, idPlace: event.target.value, preferenceOrder: this.state.newUserPlace.preferenceOrder }, searchedCityName: this.state.searchedCityName });
    }

    handleSubmitUserPlace = (event) => {
        event.preventDefault();
        if (this.state.newUserPlace.idPlace != null && this.props.userplaces.length < 5) {
            this.setState({
                newUserPlace: {
                    idUser: this.state.newUserPlace.idUser,
                    idPlace: this.state.newUserPlace.idPlace,
                    preferenceOrder: this.props.userplaces.length + 1
                }
            });
            this.props.createUserPlace(this.props.currentuser, this.state.newUserPlace);
            this.toggleModalCreation();
        }

        this.setState({ newUserPlace: { idUser: this.state.newUserPlace.idUser, idPlace: null, preferenceOrder: null }, searchedCityName: "" });
    }

    onSortEnd = ({ oldIndex, newIndex }) => {
        const prevItems = this.props.userplaces.sort(function (a, b) {
            let prefA = a.preferenceOrder;
            let prefB = b.preferenceOrder;
            if (prefA < prefB) return -1;
            if (prefA > prefB) return 1;
            return 0;
        })
        const items = arrayMove(prevItems, oldIndex, newIndex);
        items.map((item, index) => item.preferenceOrder = index + 1);
        console.log("reorder");
        console.log(items);
        this.props.updateUserPlaceBatch(this.props.currentuser, items);
    };

    handleInputChange = (input) => {
        this.setState({searchedCityName: input});
        console.log("INPUT", input);
        if (input.length > 2) {
            console.log("SEARCH");
            this.props.searchPlace(this.props.currentuser, input);
        }
        
    }

    searchCity = (input) => {
        console.log("UPDATE");
        return this.props.places.map(place => {
            const labelPlace = "" + place.name + " - " + place.postCode;
            console.log(labelPlace);
            return {value: place.id, label: labelPlace};
        });
    }

    loadOptions = (input, callback)=>{
        if (input.length > 2) {
        setTimeout(() => {callback(this.searchCity(input));},1000);
        }else{
            callback(this.searchCity(input));
        }
        
    }

    submitUserPlace = (object, type) => {

        console.log("CHANGE",object.value,type)
        if (type.action === "select-option" && object.value !== 0 && this.props.userplaces.length < 5) {
            const newUserPlace = {
                idUser: this.props.currentuser.id,
                idPlace: object.value,
                preferenceOrder: this.props.userplaces.length + 1
            };
            console.log("SUBMIT");
            this.props.createUserPlace(this.props.currentuser, newUserPlace);
        }

        this.setState({ newUserPlace: { idUser: this.state.newUserPlace.idUser, idPlace: null, preferenceOrder: null}});
    }

    render() {

        return (
            <MainLayout title="Your Favorite Places" icon={icon}>
            <Select options={this.props.places.map(place => {
            const labelPlace = "" + place.name + " - " + place.postCode;
            console.log(labelPlace);
            return {value: place.id, label: labelPlace};
        })} onInputChange={this.handleInputChange} onChange = {this.submitUserPlace}/>
            {/* <AsyncSelect isMulti cacheOptions loadOptions={this.loadOptions} defaultOptions onInputChange={this.handleInputChange}/> */}
                <div>
                    <SortableList items={this.props.userplaces.sort((a, b) => {
                        let prefA = a.preferenceOrder;
                        let prefB = b.preferenceOrder;
                        if (prefA < prefB) return -1;
                        if (prefA > prefB) return 1;
                        return 0;
                    })} onSortEnd={this.onSortEnd} onClick={this.onClickDelete} distance={5} />

                    <Fab onClick={this.toggleModalCreation} />
                    <Modal isOpen={this.state.modalCreation} toggle={this.toggleModalCreation} centered={true} className="custom-modal">
                        <ModalHeader toggle={this.toggleModalCreation}>Add a place</ModalHeader>
                        <ModalBody>
                            <form onSubmit={this.handleSubmitCityName}>
                                <div className="form-group">First, search a place name</div>
                                <div className="form-group row w-100">
                                    <div className="d-inline col-1"></div>
                                    <input className="d-inline float-center text-left col-8 input-group" placeholder="Place Name" type="text" value={this.state.searchedCityName} onChange={this.handleChangeCityName} />
                                    <button className="d-inline float-right text-center col-3 btn" type="submit">Search</button>
                                </div>
                            </form>
                            <form onSubmit={this.handleSubmitUserPlace}>
                                <div className="form-group">Then, select the right place in the list</div>
                                <CustomSelectNewPlace options={this.props.places} name="idPlace" label="Location" handleChange={this.handleChangeUserPlace} />
                                <ButtonForm name="Add Place" type="submit" />
                            </form>
                        </ModalBody>
                    </Modal>
                </div>
            </MainLayout>
        );
    }
}

const mapStateToProps = state => ({
    currentuser: state.currentuser,
    places: state.places,
    userplaces: state.userplaces
});

const mapDispatchToProps = dispatch => {
    return {
        getPlaces: (user) => {
            dispatch(PlaceActions.getPlaces(user))
        },
        getUserPlaces: (user) => {
            dispatch(PlaceActions.getUserPlaces(user))
        },
        searchPlace: (user, cityname) => {
            dispatch(PlaceActions.searchPlace(user, cityname))
        },
        createUserPlace: (user, place) => {
            dispatch(PlaceActions.createUserPlace(user, place))
        },
        updateUserPlaceBatch: (user, userPlaceBatch) => {
            dispatch(PlaceActions.updateUserPlaceBatch(user, userPlaceBatch))
        },
        deleteUserPlace: (user, id) => {
            dispatch(PlaceActions.deleteUserPlace(user, id))
        },
    }
}

export const MyPlacesConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(MyPlaces)

export const MyPlacesPage = MyPlacesConnected;