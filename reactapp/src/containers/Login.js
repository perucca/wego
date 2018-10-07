import React from 'react';
import { Link } from 'react-router-dom';
import LoginLayout from '../hoc/LoginLayout';

const Login = () => (
    <form>
        <div className="form-group">
            <h1>Log In to WeGo</h1>
        </div>
        <div className="form-group">
            <label htmlFor="login-email">Email</label>
            <input type="email" className="form-control" id="login-email" placeholder="Enter your email" />
        </div>
        <div className="form-group">
            <label htmlFor="login-password">Password</label>
            <input type="password" className="form-control" id="login-password" placeholder="Enter your password" />
        </div>
        <div className="form-group">
            <div className="form-check">
                <input type="checkbox" className="form-check-input" id="login-rememberme" />
                <label className="form-check-label" htmlFor="login-rememberme">Remember me</label>
            </div>
        </div>
        <div className="form-group">
            <button type="submit" className="btn btn-primary">Log In</button>
        </div>
        <div className="form-group">
            <Link to="/signin">Create an account</Link>
        </div>
        <div className="form-group">
            <a href="#">Forgot your password ?</a>
        </div>
    </form>
)

const LoginInLayout = LoginLayout(Login);

export default LoginInLayout;