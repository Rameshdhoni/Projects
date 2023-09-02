
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button, Card } from '@mui/material';
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import './UserLogin.css'


const initialValue = {
    userEmail: "",
    userPassword: "",
}
export default function UserLogin() {
    const [db, setDb] = useState(initialValue);

    const history = useNavigate();
    const navigate = useNavigate();

    const handleRegister = () => {
        history('/userregister')
    }

    const handleCancle = () => {
        history('/')
    }
    const onValueChange = (e) => {

        setDb({ ...db, [e.target.name]: e.target.value });
        console.log(db);

    }
    //used to check the user is present in user table ot not
    async function userPresent(data) {

        if (data.userEmail.length <= 2) {
            alert("Email Should be more than 2 characters")
        }
        else if (data.userPassword.length <= 2) {
            alert("Password Should be more than 2 characters")
        }
        else {
            //fethcing all users data using API
            let check_data = await fetch("http://localhost:9001/user/users");
            let check = await check_data.json();
            let flag = false;
            console.log(check);
            for (let i = 0; i < check.length; i++) {
                //here checking user login
                if (check[i].userEmail === data.userEmail && check[i].userPassword === data.userPassword) {
                    flag = true;
                    //storing all user details in localstorage
                    localStorage.setItem('UName', check[i].userName);
                    localStorage.setItem('UId', check[i].userId);
                    localStorage.setItem('UEmail', check[i].userEmail);
                    localStorage.setItem('UPhone', check[i].userPhone);
                }
            }
            if (flag === true) {
                alert("Login success")
                //navigate to another page using history.push
                navigate('/allpost')
            }
            else {
                alert("Please Enter corect username and password")
            }
        }
    }



  return (
    <div className='form'>
       <div className='form-body'>
                <Card>
                    <Container maxWidth="sm">
                        <Box my={5}>
                            <Typography variant="h5" align="center">User Login</Typography>
                            <div className='img text-center' >
                                <img
                                    src="https://th.bing.com/th/id/OIP.Bcm1scAvDvySfbnNuHHAsgHaHa?w=189&h=189&c=7&r=0&o=5&dpr=1.5&pid=1.7"
                                    alt="" class="center" style={{ height: '120px',paddingLeft:'160px',paddingTop:'20px'}}
                                /></div>
                            <FormGroup>
                                <FormControl>
                                    <InputLabel>Enter Email</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="userEmail" value={db.userEmail} />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Enter Password</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="userPassword" value={db.userPassword} type="password" />
                                </FormControl><br></br>
                                <Box my={3}>
                                    {/* this button is used to call userPresent() */}
                                    <Button variant="contained" onClick={() => userPresent(db)} color="primary" align="center">Login</Button>
                                    <Button onClick={handleCancle} variant="contained" color="secondary" align="center" style={{ margin: '0px 20px' }}>Cancel</Button>
                                    <br></br><br></br>
                                    New User? Please Register
                                    <Button variant="contained" onClick={handleRegister} color="primary" align="center">Register</Button>
                                    {/* <Link to ="/register">Register</Link> */}
                                    <br></br><br></br>

                                </Box>
                            </FormGroup>
                        </Box>
                    </Container>
                </Card>
            </div>
    </div>
  )
}
