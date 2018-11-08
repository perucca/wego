import React from 'react';
import {HomeLayout} from '../_hoc/HomeLayout';
import { TextField, ButtonForm } from '../_components';
import './App.css';
import { connect } from 'react-redux';
import { UserActions } from '../_actions/user-actions';

class Profile extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            updateUser: {
                firstName: this.props.currentuser.firstName,
                lastName : this.props.currentuser.lastName,
                mail: null,
                password: null
            },
        };
    }

    componentDidMount=()=>{
        console.log(this.state);
    }

    handleChangeFirstName=(event)=>{
        this.setState({updateUser:{firstName:event.target.value, lastName:this.state.updateUser.lastName, mail:this.state.updateUser.mail, password:this.state.updateUser.password }});
        console.log(this.state);
    }

    handleChangeLastName=(event)=>{
        this.setState({updateUser:{firstName:this.state.updateUser.firstName, lastName:event.target.value, mail:this.state.updateUser.mail, password:this.state.updateUser.password }});
        console.log(this.state);
    }

    submitChange= (event) => {
        event.preventDefault();
        console.log("dto sent");
        console.log(this.state);
        this.props.updateUserProfile(this.props.currentuser, this.state.updateUser);
    }

    render() {
        return(
            <form onSubmit={this.submitChange}>
                <div className="form-group">
                <h3>Update my profile</h3>
                </div>
                <TextField id="signin-firstname" value={this.state.updateUser.firstName} type="text" onChange={this.handleChangeFirstName}/>
                <TextField id="signin-lastname" value={this.state.updateUser.lastName} type="text" onChange={this.handleChangeLastName} />
                {/* <TextField id="signin-password" placeholder="Password" type="password" /> */}
                <ButtonForm name="Update" type="submit" />
                
            </form>)}
}

const mapStateToProps = state => ({
    currentuser: state.currentuser
});

const mapDispatchToProps = dispatch => {
    return {
        updateUserProfile: (user, dto) => {
            dispatch(UserActions.updateUserProfile(user, dto))
        }
    }
}

export const MyProfileConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(Profile);

export const ProfilePage = HomeLayout(MyProfileConnected);