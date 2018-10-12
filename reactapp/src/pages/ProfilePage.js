import React from 'react';
import { Link } from 'react-router-dom';
import HomeLayout from '../_hoc/HomeLayout';
import { TextField, ButtonForm } from '../_components';

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

export const ProfilePage = HomeLayout(Profile);
