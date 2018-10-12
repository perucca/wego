import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import LoginLayout from '../_hoc/LoginLayout';
import { TextField, ButtonForm, Checkbox } from '../_components';
import { UserActions } from '../_actions';


class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state = { username: '', password: '' };
    }

    handleSubmit = (event) => {
        event.preventDefault();
        this.props.login(this.state.username, this.state.password);

    }

    handleChange = (e) => {
        const change = {};
        change[e.target.name] = e.target.value;
        this.setState(change);
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <TextField id="login-email" placeholder="Email" type="email" name="username" value={this.state.username} onChange={this.handleChange} />
                <TextField id="login-password" placeholder="Password" type="password" name="password" value={this.state.password} onChange={this.handleChange} />
                <Checkbox id="login-rememberme" value="Remember me" />
                <ButtonForm name="Log In" type="submit" />
                <div className="form-group">
                    <Link to="/signin">Create an account</Link>
                </div>
                <div className="form-group">
                    <a href="#">Forgot your password?</a>
                </div>
            </form>
        )
    }
}

const mapStateToProps = state => ({
});

const mapDispatchToProps = dispatch => {
    return {
        login: (username, password) => {
            dispatch(UserActions.login(username, password))
        }
    }
}

export const LoginConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(Login)

export const LoginPage = LoginLayout(LoginConnected);