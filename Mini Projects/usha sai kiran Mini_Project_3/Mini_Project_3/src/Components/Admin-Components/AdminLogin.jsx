import React, { useState, useEffect } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button } from '@material-ui/core';
import { useHistory } from 'react-router-dom';

const initialValue = {
    username: "",
    password: ""
}
//used to check the login
function AdminLogin() {
    const [db, setDb] = useState(initialValue);
    const { username, password } = db;
    const history = useHistory();
    // useEffect(() => {
    //     if (localStorage.getItem('user-info')) {
    //         history.push("/allmenu");
    //     }
    // }, [])
    const onValueChange = (e) => {
        //  console.log(e);
        // console.log(e.target.value);
        setDb({ ...db, [e.target.name]: e.target.value });
        console.log(db);
    }
    //login method
    async function userPresent(data) {
        let check_data = await fetch("http://127.0.0.1:3003/admin");
        let check = await check_data.json();
        let flag = false;
        console.log(check);
        for(let i=0;i<check.length;i++) {
            if(check[i].username === data.username && check[i].password === data.password) {
                flag = true;
                sessionStorage.setItem("admin",JSON.stringify(check[i]));
            }
        }
        if(flag===true)
        {
            alert("Login success")
            history.push("/adminpage")
        }
        else {
            alert("Admin Credentials are Incorrect !!!!!!\nPlease check admin credentials in the db.json file")
        }
    }
    return (
        <Container maxWidth="sm">
            <Box my={5}>
                <Typography variant="h5" align="center">Admin Login</Typography>
                <FormGroup>
                    <FormControl>
                        <InputLabel>Adminname</InputLabel>
                        <Input onChange={(e) => onValueChange(e)} name="username" value={db.username} />
                    </FormControl>
                    <FormControl>
                        <InputLabel>Password</InputLabel>
                        <Input onChange={(e) => onValueChange(e)} name="password" value={db.password} type="password" />
                    </FormControl>
                    <Box my={3}>
                        <Button variant="contained" onClick={() => userPresent(db)} color="primary" align="center">Login</Button>
                        <Button onClick={() => history.push("/")} variant="text" color="secondary" align="center" style={{ margin: '0px 20px' }}>Cancel</Button>
                        <br></br><br></br>
                    </Box>
                </FormGroup>
            </Box>
        </Container>
    )
}
export default AdminLogin;
