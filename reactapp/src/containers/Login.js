import React from 'react';
import { Link } from 'react-router-dom';
import LoginLayout from '../hoc/LoginLayout';
import TextField from '../components/TextField';
import ButtonForm from '../components/ButtonForm';
import Checkbox from '../components/Checkbox';
import Axios from 'axios';

class Login extends React.Component {


    onClick = () => {
        Axios.post('/login',  {}, {auth: {
            username: 'toto@toto.fr',
            password: 'pss'
          }})
          .then(function (response) {
            console.log(response);
          })
          .catch(function (error) {
            console.log(error);
          });
    }

    render() { return (
    <form>
        <TextField id="login-email" placeholder="Email" type="email" />
        <TextField id="login-password" placeholder="Password" type="password" />
        <Checkbox id="login-rememberme" value="Remember me" />
        <ButtonForm name="Log In" type="submit" value={this.onClick} />
        <div className="form-group">
            <Link to={this.onClick}>Create an account</Link>
        </div>
    </form>
    )}
}

const LoginInLayout = LoginLayout(Login);

export default LoginInLayout;