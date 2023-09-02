import React, { useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button, Card } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { addUser } from '../../service/userapi';
const initialValue = {
    userName: "",
    userEmail: "",
    userPassword: "",
    userPhone: "",

}
//used to register user
const UserRegister = () => {

    const [user, setUser] = useState(initialValue);
    const { userName, userEmail, userPassword, userPhone } = user;
    //declering history as useNavigate()
    const history = useNavigate();

    const handleLogin = () => {
        history('/userlogin')
    }
    const handleCancle = () => {
        history('/userlogin')
    }
    //onchange value ()
    const onValueChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
        console.log(user);
    }

    //used to adduser details to table
    const addUserDetails = async () => {
        alert("User has been Registered Successfully")
        if (userName.length <= 2) {
            alert("Username required and it shoud be more than 2 characters")
        }
        else if (userEmail.length <= 2) {
            alert("Email required and it shoud be more than 2 characters")
        }
        else if (userPassword.length <= 2) {
            alert("Password required and it shoud be more than 2 characters")
        }
        else if (userPhone.length <= 2) {
            alert("Phone required and it shoud be more than 2 characters")
        }
        else {
            await addUser(user);//adding user details to table
            alert("User Register Successfully!!!!!! Now You can Login")//notifies user register successfully
            history('/userlogin');//naviate to another page using history
        }
    }

    return (
        <div className='form'>
            <div className='form-body'>
                <Card>
                    <Container maxWidth="sm">
                        <Box my={5}>
                            <Typography variant="h5" align="center">User Registration Form</Typography><br></br>
                            <div className='img text-center' >

                                <img
                                    src="https://th.bing.com/th/id/OIP.Bcm1scAvDvySfbnNuHHAsgHaHa?w=189&h=189&c=7&r=0&o=5&dpr=1.5&pid=1.7"
                                    alt="" class="center" style={{ height:'120px',paddingLeft:'160px',paddingTop:'20px'}}
                                /></div>
                            <FormGroup>
                                <FormControl>
                                    <InputLabel>Full Name</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="userName" value={userName} />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Email address</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="userEmail" value={userEmail} />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Password</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="userPassword" value={userPassword} type="password" />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Mobile Number</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="userPhone" value={userPhone} />
                                </FormControl><br></br>
                                <Box my={3}>
                                    {/* this button is used to call addUserDetails() */}
                                    <Button variant="contained" onClick={() => addUserDetails()} color="primary" align="center">Register</Button>
                                    <Button onClick={handleCancle} variant="contained" color="secondary" align="center" style={{ margin: '0px 20px' }}>Cancel</Button>
                                    <br></br><br></br>
                                    Already Registered ? Please Login <Button variant="contained" onClick={handleLogin} color="primary" align="center">Login</Button>

                                </Box>
                            </FormGroup>
                        </Box>
                    </Container>
                </Card>
            </div>
        </div>
    )
}

//exporting UserRegister
export default UserRegister;
