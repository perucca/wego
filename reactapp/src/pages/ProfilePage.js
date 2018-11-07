import React from 'react';
import {HomeLayout} from '../_hoc/HomeLayout';
import { TextField, ButtonForm } from '../_components';
import icon from '../_img/profile.svg';

export const ProfilePage = () => (
    <HomeLayout title="Update your profile" icon={icon}>
        <form>
            <div className="form-group">
                Update my profile
            </div>
            <TextField id="signin-firstname" placeholder="First Name" type="text" />
            <TextField id="signin-lastname" placeholder="Last Name" type="text" />
            <TextField id="signin-password" placeholder="Password" type="password" />
            <ButtonForm name="Update" type="submit" />
        </form>
    </HomeLayout>
)
