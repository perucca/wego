import React from 'react';
import { Link } from 'react-router-dom';
import LoginLayout from '../_hoc/LoginLayout';
import { TextField, ButtonForm, Checkbox } from '../_components';
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

    onChange = (event) => {event.persist();
        console.log(event.target.name); 
        this.setState({[event.target.name]: event.target.value})}

    logError(error) {
        if (error.response) {
            console.log(error);
            console.log(error.response.data);
            console.log(error.response.status);
            console.log(error.response.headers);
        }
        else if (error.request) {
            console.log(error);
            console.log(error.request);
        }
        else {
            console.log('Error', error.message);
        }
        console.log(error.config);
    }

    render() { return (
       <form>
        <TextField name="username" id="login-email" placeholder="Email" type="email"  onChange={this.onChange} />
        <TextField name="password" id="login-password" placeholder="Password" type="password" onChange={this.onChange}/>
        <Checkbox id="login-rememberme" value="Remember me" />
        <ButtonForm name="Log In" type="submit" onClick={this.onClick}/>
        <div className="form-group">
            <Link to="/signin">Create an account</Link>
        </div>
        <div className="form-group">
            <a href="#">Forgot your password?</a>
        </div>

    </form>

    )}
}

export const LoginPage = LoginLayout(Login);
