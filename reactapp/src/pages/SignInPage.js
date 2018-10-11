import React from 'react';
import { Link } from 'react-router-dom';
import LoginLayout from '../_hoc/LoginLayout';
import { TextField, ButtonForm } from '../_components';

const SignIn = () => (
    <form>
        <TextField id="signin-firstname" placeholder="First Name" type="text" />
        <TextField id="signin-lastname" placeholder="Last Name" type="text" />
        <TextField id="signin-email" placeholder="Email" type="email" />
        <TextField id="signin-password" placeholder="Password" type="password" />
        <ButtonForm name="Create" type="submit" />
        <div className="form-group">
            <Link to="/login">Already have an account?</Link>
        </div>
    </form>
)

export const SignInPage = LoginLayout(SignIn);