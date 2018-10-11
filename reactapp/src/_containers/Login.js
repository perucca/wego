import React from 'react';
import { Link } from 'react-router-dom';
import LoginLayout from '../hoc/LoginLayout';
import { TextField, ButtonForm, Checkbox } from '../_components';


const Login = () => (
    <form>
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

const LoginInLayout = LoginLayout(Login);

export default LoginInLayout;