import React, { useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button, Card } from '@mui/material';
import { useNavigate, Link } from 'react-router-dom';
import './AdminRegister.css'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

const initialValue = {

    adminEmail: "",
    adminPassword: "",
}

//used to check the login
function AdminLogin() {

    const [db, setDb] = useState(initialValue);
    const history = useNavigate();
    const navigate = useNavigate();
    const handleRegister = () => {
        history('/adminregister')
    }
    const handleCancle = () => {
        history('/')
    }
    const onValueChange = (e) => {
        setDb({ ...db, [e.target.name]: e.target.value });
        console.log(db);
    }
    //used to check the admin is present in admin table ot not
    async function adminPresent(data) {
        if (data.adminEmail.length <= 2) {
            alert("Email Should be more than 2 characters")
        }
        else if (data.adminPassword.length <= 2) {
            alert("Password Should be more than 2 characters")
        }

        else {
            //fethcing all admin data using API
            let check_data = await fetch("http://localhost:9002/admin/admins");
            let check = await check_data.json();
            let flag = false;
            console.log(check);
            for (let i = 0; i < check.length; i++) {
                //here checking admin login
                if (check[i].adminEmail === data.adminEmail && check[i].adminPassword === data.adminPassword) {
                    flag = true;
                    //storing all admin details in localstorage
                    localStorage.setItem('UName', check[i].adminName);
                    localStorage.setItem('UId', check[i].adminId);
                    localStorage.setItem('UEmail', check[i].adminEmail);
                    localStorage.setItem('UPhone', check[i].adminPhone);
                }
            }
            if (flag === true) {
                alert("Login success")
                //navigate to another page using history.push
                navigate('/admin/allposts')
            }
            else {
                alert("Please Enter correct adminname and password")
            }
        }
    }
    return (
        <div className='form'>
            <div className='form-body'>
                <Card>
                    <Container maxWidth="sm">
                        <Box my={5}>
                            <Typography variant="h5" align="center">Admin Login</Typography><br></br>
                            <div className='img text-center' >
                                <img
                                    src="https://th.bing.com/th/id/OIP.Bcm1scAvDvySfbnNuHHAsgHaHa?w=189&h=189&c=7&r=0&o=5&dpr=1.5&pid=1.7"
                                    alt="" class="center" style={{ height: '120px',paddingLeft:'160px',paddingTop:'20px' }}
                                /></div>
                            <FormGroup>
                                <FormControl>
                                    <InputLabel>Enter Email</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="adminEmail" value={db.adminEmail} />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Enter Password</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="adminPassword" value={db.adminPassword} type="password" />
                                </FormControl><br></br>
                                <Box my={3}>
                                    {/* this button is used to call adminPresent() */}
                                    <Button variant="contained" onClick={() => adminPresent(db)} color="primary" align="center">Login</Button>
                                    <Button onClick={handleCancle} variant="contained" color="secondary" align="center" style={{ margin: '0px 20px' }}>Cancel</Button>
                                    <br></br><br></br>
                                    New Admin? Please Register
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
//exporting adminLogin
export default AdminLogin;