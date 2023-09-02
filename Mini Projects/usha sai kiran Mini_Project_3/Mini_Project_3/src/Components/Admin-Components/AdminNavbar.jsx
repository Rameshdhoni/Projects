import React from 'react';
import { AppBar, makeStyles, Toolbar } from '@material-ui/core';
import { NavLink } from 'react-router-dom';

// Styling for the Navigations
const useStyles = makeStyles({
    header: {
        backgroundColor: 'goldred',
    },
    spacing :{
        paddingLeft: 350,
        color: '#fff',
        fontSize: '18px',
        textDecoration: 'none', 
    },
    spacingr :{
        paddingLeft: 0,
        color: '#fff',
        fontSize: '18px',
        textDecoration: 'none',
    },
    spacingnewuser :{
        paddingLeft: 50,
        color: '#fff',
        fontSize: '18px',
        textDecoration: 'none', 
    },
    spacingnewitem :{
        paddingLeft: 50,
        color: '#fff',
        fontSize: '18px',
        textDecoration: 'none', 
    },
    spacinglogout :{
        paddingLeft: 300,
        color: '#fff',
        fontSize: '25px',
        textDecoration: 'none', 
    }
  });
// Admin Navigations Method
const AdminNavbar = () => {
    const classes = useStyles();
    return (
        <AppBar className={classes.header} position="static">
            <Toolbar >
                <NavLink to="allusers" className={classes.spacingr}> All Users</NavLink>
                <NavLink to="adduser" className={classes.spacingnewuser}> Add New User</NavLink>                
                <NavLink to="/" className={classes.spacinglogout}>LOGOUT</NavLink>
                <NavLink to="allmenu" className={classes.spacing}>All Items</NavLink>
                <NavLink to="addmenu" className={classes.spacingnewitem}>Add New Item</NavLink>
            </Toolbar>
        </AppBar>
    )
}

export default AdminNavbar;