import React, { useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button, Card } from '@mui/material';
import { addUser } from '../../service/adminapi';
import { useNavigate } from 'react-router-dom';
import '../../App.css'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './AdminRegister.css'
//toast.configure();
const notify = (msg) => {

    toast.success(msg, {
        position: 'top-right', autoClose: 2500, hideProgressBar: true, closeOnClick: false,
        pauseOnHover: true, draggable: false, progress: undefined, theme: 'colored'

    });

}

const initialValue = {
    adminName: "",
    adminEmail: "",
    adminPassword: "",
    adminPhone: "",

}
//used to register user
const AdminRegister = () => {

    const [admin, setUser] = useState(initialValue);
    const { adminName, adminEmail, adminPassword, adminPhone } = admin;
    //declering history as useNavigate()
    const history = useNavigate();

    const handleLogin = () => {
        history('/adminlogin')
    }
    const handleCancle = () => {
        history('/adminlogin')
    }
    //onchange value ()
    const onValueChange = (e) => {
        setUser({ ...admin, [e.target.name]: e.target.value });
        console.log(admin);
    }

    //used to adduser details to table
    const addUserDetails = async () => {
        //alert("User has been Registered Successfully")
        if (adminName.length <= 2) {
            alert("Username required and it shoud be more than 2 characters")
        }
        else if (adminEmail.length <= 2) {
            alert("Email required and it shoud be more than 2 characters")
        }
        else if (adminPassword.length <= 2) {
            alert("Password required and it shoud be more than 2 characters")
        }
        else if (adminPhone.length <= 2) {
            alert("Phone required and it shoud be more than 2 characters")
        }
        else {
            await addUser(admin);//adding user details to table
            notify("User Register Successfully!!!!!! Now You can Login")//notifies user register successfully
            history('/adminlogin');//naviate to another page using history.push()
        }
    }

    return (
        <div className='form'>
            <div className='form-body'>
                <Card>
                    <Container maxWidth="sm">
                        <Box my={5}>
                            <Typography variant="h5" align="center">Admin Registration Form</Typography><br></br>
                            <div className='img text-center' >

                                <img

                                    src="https://th.bing.com/th/id/OIP.Bcm1scAvDvySfbnNuHHAsgHaHa?w=189&h=189&c=7&r=0&o=5&dpr=1.5&pid=1.7"

                                    alt="" class="right" style={{ height: '100px', alignSelf:'center',paddingRight:100}}

                                /></div>
                            <FormGroup>
                                <FormControl>
                                    <InputLabel>Full Name</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="adminName" value={adminName} />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Email address</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="adminEmail" value={adminEmail} type='email' />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Password</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="adminPassword" value={adminPassword} type="password" />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Mobile Number</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="adminPhone" value={adminPhone} />
                                </FormControl><br></br>
                                <Box my={3}>
                                    {/* this button is used to call addUserDetails() */}
                                    <Button variant="contained" onClick={() => addUserDetails()} color="primary" align="center">Register</Button>
                                    <Button onClick={handleCancle} variant="contained" color="secondary" align="center" style={{ margin: '0px 20px' }}>Cancel</Button>
                                    <br></br><br></br>
                                    Already Registered ? Please Login

                                    <Button variant="contained" onClick={handleLogin} color="primary" align="center">Login</Button>

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
export default AdminRegister;