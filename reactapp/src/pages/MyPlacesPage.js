import React, { Component } from 'react';
import './App.css';
import { MainLayout } from '../_hoc/MainLayout';
import { PlaceActions } from '../_actions/place-actions';
import icon from '../_img/place.svg';
import { SortableContainer, SortableElement, arrayMove } from 'react-sortable-hoc';
import { connect } from 'react-redux';
import deleteBtn from '../_img/trash.svg';
import Select from 'react-select';

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

    componentDidMount() {
        console.log('my places page');
        this.props.getUserPlaces(this.props.currentuser);
    }

    onClickDelete = (e, idUserPlace) => {
        console.log(idUserPlace)
        e.preventDefault();
        this.props.deleteUserPlace(this.props.currentuser, idUserPlace);
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

    submitUserPlace = (object, type) => {
        if (type.action === "select-option" && object.value !== 0 && this.props.userplaces.length < 5) {
            const newUserPlace = {
                idUser: this.props.currentuser.id,
                idPlace: object.value,
                preferenceOrder: this.props.userplaces.length + 1
            };
            this.props.createUserPlace(this.props.currentuser, newUserPlace);
        }
        this.setState({ newUserPlace: { idUser: this.state.newUserPlace.idUser, idPlace: null, preferenceOrder: null}});
    }

    render() {

        return (
            <MainLayout title="Your Favorite Places" icon={icon}>
            <Select  isClearable isLoading={this.props.arePlacesLoading} options={this.props.places.map(place => {
            const labelPlace = "" + place.name + " - " + place.postCode;
            return {value: place.id, label: labelPlace};
        })} onInputChange={this.handleInputChange} onChange = {this.submitUserPlace} className= "mb-4 mt-5" isDisabled={(this.props.userplaces.length >= 5)}/>
                <div>
                    <SortableList items={this.props.userplaces.sort((a, b) => {
                        let prefA = a.preferenceOrder;
                        let prefB = b.preferenceOrder;
                        if (prefA < prefB) return -1;
                        if (prefA > prefB) return 1;
                        return 0;
                    })} onSortEnd={this.onSortEnd} onClick={this.onClickDelete} distance={5} />
                </div>
            </MainLayout>
        );
    }
}

const mapStateToProps = state => ({
    currentuser: state.currentuser,
    places: state.places,
    userplaces: state.userplaces,
    arePlacesLoading: state.arePlacesLoading
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