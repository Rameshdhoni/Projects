import React from 'react';
import { AppBar, makeStyles, Toolbar } from '@material-ui/core';
import { NavLink } from 'react-router-dom';

const useStyles = makeStyles({
    header: {
        backgroundColor: 'goldred',
        fontSize: '30px',
        alignItems: 'center'
    },
    spacingadmin: {
        paddingLeft: 950,
        color: '#fff',
        fontSize: '18px',
        textDecoration: 'none',
    },
    spacinguser: {
        paddingLeft: 50,
        color: '#fff',
        fontSize: '18px',
        textDecoration: 'none',
    },
    spacingmain: {
        paddingLeft: 0,
        color: '#fff',
        fontSize: '18px',
        textDecoration: 'none',
    }
});

// Main Navigations Method
const Navbar = () => {
    const classes = useStyles();
    return (
        <AppBar className={classes.header} position="static">
            ONLINE SURABHI RESTAURANT
            <Toolbar >
                <NavLink to="/" className={classes.spacingmain}>HOME</NavLink>
                <NavLink to="users" className={classes.spacinguser}>USER</NavLink>
                <NavLink to="admin" className={classes.spacingadmin}>ADMIN</NavLink>
            </Toolbar>
        </AppBar>
    )
}

export default Navbar;