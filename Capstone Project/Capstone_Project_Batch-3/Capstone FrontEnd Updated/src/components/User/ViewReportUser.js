import React, { useEffect, useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button } from '@mui/material';
import { useParams } from 'react-router-dom';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { addReportUser } from '../../service/adminpostapi';
import { getallUsers } from '../../service/userapi';
import './Login.css'

const initialValue = {
    userId: "",
    userName: "",
    userEmail: "",
    userPassword: "",
    userPhone: "",
}


//Adding User to report conformation 
const ViewReportUser = () => {

    const [user, setUser] = useState(initialValue);
    const { userName, userEmail, userPassword, userPhone } = user;
    //getting id from user  by using useParam() 
    const { userId } = useParams();
    useEffect(() => {
        loadUserData();

        // eslint-disable-next-line

    }, []);

    //load User data
    const loadUserData = async () => {

        //getting user details 
        const response = await getallUsers(userId);

        setUser(response.data);
    }

    //onvaluechange method 
    const onValueChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });

        console.log(user);
    }
    //used to Report the  User
    const ConfirmReport = async () => {

        addReportUser(user);

        //notifies Reported Successfully
        alert('Reported Successfully !!!!!!!')



    }
    return (
        <div className='form'>
            <div className='form-body'>
                <Container maxWidth="sm">
                    <Box my={5}>
                        <Typography variant="h5" align="center">Report User Conformation</Typography><br></br>
                        <FormGroup>

                            <FormControl>
                                <InputLabel>User Name</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="userName" value={userName} />
                            </FormControl><br></br>
                            <FormControl>
                                <InputLabel>User Email</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="userEmail" value={userEmail} />
                            </FormControl><br></br>
                            <FormControl>
                                <InputLabel>User Phone</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="userPhone" value={userPhone} />
                            </FormControl><br></br>



                            <FormControl>
                                <InputLabel>User Password</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="userPassword" value={userPassword} />
                            </FormControl>

                            <Box my={3}>

                                {/* calling ConfirmReport() when button is clicked */}
                                <Button variant="text" onClick={() => ConfirmReport()} color="primary" align="center">Confirm Report</Button>

                            </Box>
                        </FormGroup>
                    </Box>
                </Container>
            </div>
        </div>
    )
}
//exporting ApproveConfirm
export default ViewReportUser;