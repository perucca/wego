import React from 'react';
import { Link } from 'react-router-dom';
import LoginLayout from '../hoc/LoginLayout';
import TextField from '../components/TextField';
import ButtonForm from '../components/ButtonForm';

const Profile = () => (
    <form>
        <div className="form-group">
          Update my profile
        </div>
        <TextField id="signin-firstname" placeholder="First Name" type="text" />
        <TextField id="signin-lastname" placeholder="Last Name" type="text" />
        <TextField id="signin-password" placeholder="Password" type="password" />
        <ButtonForm name="Update" type="submit" />
        
    </form>
)

const ProfileInLayout = LoginLayout(Profile);

export default ProfileInLayout;