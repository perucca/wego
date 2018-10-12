import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import LoginLayout from '../_hoc/LoginLayout';
import { TextField, ButtonForm, Checkbox } from '../_components';
import { UserActions } from '../_actions';
import Axios from 'axios';

class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state = {username:  '', password: ''};
    }

    onClick = (event) => {
        event.preventDefault();
        Axios.post('/login',{}, {auth: { username: this.state.username,
                                         password: this.state.password }}
        )
        .then(function (response) {
            //Trace de la réponse
            console.log(response);

            //On code ici le routing sur HOME

        })
        .catch(function (error) {
            //on trace l'erreur au maximum
            this.logError(error);

            //Gérer le code 401 ici pour retourner un message d'erreur
        });
    }


    handleSubmit = (e) => {
        e.preventDefault();
        console.log('clic')
        this.props.login();
      };

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <TextField id="login-email" placeholder="Email" type="email" />
                <TextField id="login-password" placeholder="Password" type="password" />
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
      login: () => {
        dispatch(UserActions.login())
      }
    }
  }
  
  export const LoginConnected = connect(
    mapStateToProps,
    mapDispatchToProps)(Login)
  
export const LoginPage = LoginLayout(LoginConnected);