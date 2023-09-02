import React, { useEffect, useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button, Select, MenuItem } from '@mui/material';
import { useParams } from 'react-router-dom';
import { deleteWaitingPost } from '../../service/adminpostapi';
import { getallWaitingApprove } from '../../service/adminpostapi'
import { addPost } from '../../service/postapi';
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './AdminRegister.css'
import { useNavigate } from 'react-router-dom/dist';
const notify = (msg) => {
    toast.success(msg, {

        position: 'top-right', autoClose: 2500, hideProgressBar: true, closeOnClick: false,
        pauseOnHover: true, draggable: false, progress: undefined, theme: 'colored'

    });

}

const myComponent = {
    width: '1000px',
    height: '500px',
    overflowX: 'hidden',
};

const initialValue = {

    userName: "",
    postName: "",

    image: "",
    date: "",

}

//Adding Post to approve conformation from admin
const ConfirmApproval = () => {

    const navigate = useNavigate();
    const [post, setPost] = useState(initialValue);
    const { postName, image, date, userName } = post;
    //getting id from adminApprovePost method by using useParam() 
    const { id } = useParams();
    useEffect(() => {

        //loading approve needed Post 
        loadPostData();

        // eslint-disable-next-line

    }, []);

    //load Post data
    const loadPostData = async () => {

        //getting and storing waitingapprovePost details 
        const response = await getallWaitingApprove(id);
        //assigning waitingapprovePost details to Post by using setPost 
        setPost(response.data);
    }
    //useHistory
    // const history = useHistory();
    //onvaluechange method 
    const onValueChange = (e) => {
        setPost({ ...post, [e.target.name]: e.target.value });
        // displaying waitingapprovePost details in console
        console.log(post);
    }
    //used to Approved the Post 
    const confirmApproval = async () => {
        //adding that waitingapprovePost details to Post table
        addPost(post);
        //deleting waitingapprovePost details from waitingApprove table using id
        deleteWaitingPost(id);
        //notifies Approved Successfully

        alert('Approved Successfully !!!!!!!');
        //navigating to anothor page using navigate method
        navigate('/admin/allposts')


    }
    return (
        <div className='form'>
            <div className='form-body'>
                <Container maxWidth="sm">
                    <Box my={5}>
                        <Typography variant="h5" align="center">Post Approval Confirmation </Typography>
                        <FormGroup>
                            <FormControl>
                                <InputLabel>User Name</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="userName" value={userName} />
                            </FormControl><br></br>
                            <FormControl>
                                <InputLabel>Post Name</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="postname" value={postName} />
                            </FormControl><br></br>
                            <FormControl>
                                <InputLabel>Image</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="image" value={image} />
                            </FormControl><br></br>


                            <FormControl>
                                <InputLabel>Date and Time</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="date" value={date} />
                            </FormControl><br></br>


                            <Box my={3}>

                                {/* calling confirmApproval() when button is clicked */}
                                <Button variant="text" onClick={() => confirmApproval()} color="primary" align="center">Confirm Approval</Button>

                            </Box>
                        </FormGroup>
                    </Box>
                </Container>
            </div>
        </div>

    )
}
//exporting ApproveConfirm
export default ConfirmApproval;