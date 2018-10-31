import React from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { UserActions } from '../_actions';
import logo from '../_img/WeGo-Logo-01.png';
import './Header.css';

class HeaderBase extends React.Component {

    handleLogout = (event) => {
        event.preventDefault();
        this.props.logout();

    }

    render() {
        return (
            <header className="wego-header">
                <nav className="navbar navbar-expand-lg navbar-light">
                    <Link className="navbar-brand" to="/home">
                        <img src={logo} alt="WeGo logo" className="logo" />
                    </Link>
                    <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>

                    <div className="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul className="navbar-nav mr-auto">
                            <li className="nav-item active">
                                <Link className="nav-link" to="/home">Home<span className="sr-only">(current)</span></Link>
                            </li>
                            <li className="nav-item">
                                <Link className="nav-link" to="/profile">Profile</Link>
                            </li>
                            </ul>
                            <ul className="navbar-nav ml-auto">
                            <li className="nav-item">
                                <a className="nav-link" onClick={this.handleLogout} href="#">Logout</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </header>
        )
    }
}

const mapStateToProps = state => ({
});

const mapDispatchToProps = dispatch => {
    return {
        logout: () => {
            dispatch(UserActions.logout())
        }
    }
}

export const Header = connect(
    mapStateToProps,
    mapDispatchToProps)(HeaderBase);