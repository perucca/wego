import React from 'react';
import { Link } from 'react-router-dom';
import LoginLayout from '../_hoc/LoginLayout';
import { TextField, ButtonForm } from '../_components';
import { connect } from 'react-redux';
import { UserActions } from '../_actions';

class SignIn extends React.Component {

constructor(props) {
    super(props);
    this.state = { username: '', password: '' };
}

handleSubmit = (event) => {
    event.preventDefault();
    this.props.add(this.state.firstName, this.state.lastName, this.state.mail, this.state.password);

}

handleChange = (e) => {
    const change = {};
    change[e.target.name] = e.target.value;
    this.setState(change);
}

render() {return (
    <form onSubmit={this.handleSubmit}>
        <TextField id="signin-firstname" placeholder="First Name" name="firstName" onChange={this.handleChange} type="text" />
        <TextField id="signin-lastname" placeholder="Last Name" name="lastName" onChange={this.handleChange} type="text" />
        <TextField id="signin-email" placeholder="Email" name="mail" onChange={this.handleChange} type="email" />
        <TextField id="signin-password" placeholder="Password" name="password" onChange={this.handleChange} type="password" />
        <ButtonForm name="Create" type="submit" />
        <div className="form-group">
            <Link to="/login">Already have an account?</Link>
        </div>
    </form>
)}
}

const mapStateToProps = state => ({
});

const mapDispatchToProps = dispatch => {
    return {
        add: (firstName, lastName, mail, password) => {
            dispatch(UserActions.add({firstName: firstName, lastName: lastName, mail: mail, password: password}))
        }
    }
}

export const SignInConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(SignIn)


export const SignInPage = LoginLayout(SignInConnected);