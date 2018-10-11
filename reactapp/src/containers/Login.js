import React from 'react';
import { Link } from 'react-router-dom';
import LoginLayout from '../hoc/LoginLayout';
import TextField from '../components/TextField';
import ButtonForm from '../components/ButtonForm';
import Checkbox from '../components/Checkbox';
import Axios from 'axios';

class Login extends React.Component {

    constructor(props) {
        super(props);
        this.state = {username:  '', password: ''};
    }

    onClick = (event) => {
        event.preventDefault();
        Axios({
            url:'http://localhost:8080/login',  
            method: 'post',
            data:{}, 
            auth: {
                    username: this.state.username,
                    password: this.state.password
            }
        })
        .then(function (response) {
            console.log(response);

            Axios({
                url:'http://localhost:8080/places',  
                method: 'get',
                data:{ }, 
           
            }).then(function (response) {
                console.log(response);
            }).catch(function (error){console.log(error)})
        })
        .catch(function (error) {
            if (error.response) {
                // The request was made and the server responded with a status code
                // that falls out of the range of 2xx
                console.log(error);
                console.log(error.response.data);
                console.log(error.response.status);
                console.log(error.response.headers);
              } else if (error.request) {
                // The request was made but no response was received
                // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
                // http.ClientRequest in node.js
                console.log(error);
                console.log(error.request);
              } else {
                // Something happened in setting up the request that triggered an Error
                console.log('Error', error.message);
              }
              console.log(error.config);
        });
    }

    onChange = (event) => {event.persist();
        console.log(event.target.name); 
        this.setState({[event.target.name]: event.target.value})}

    render() { return (
       <form>
        <TextField name="username" id="login-email" placeholder="Email" type="email"  onChange={this.onChange} />
        <TextField name="password" id="login-password" placeholder="Password" type="password" onChange={this.onChange}/>
        <Checkbox id="login-rememberme" value="Remember me" />
        <ButtonForm name="Log In" type="submit" onClick={this.onClick}/>
    </form>

    )}
}

const LoginInLayout = LoginLayout(Login);

export default LoginInLayout;