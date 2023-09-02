import React, { useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button, Select, MenuItem } from '@mui/material';
import { addPost } from '../../service/postapi';
import { useNavigate } from 'react-router-dom';
import '../../App.css'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './AdminLogin.css';
const initialValue = {
    userName: "",
    postName: "",
    //ownerName: localStorage.getItem('OName'),
    date: "",
    image: ""
}
//used to add post details to table
const AdminAddPost = () => {

    const [post, setpost] = useState(initialValue);
    var[newImage,addImage]=useState([]);
    const { userName, postName, date, image } = post;
    //declaring navigate as useNavigate
    const navigate = useNavigate();
    //used to value change in form
    const onValueChange = (e) => {
        //changing post details
        setpost({ ...post, [e.target.name]: e.target.value });
        //displaying post details in console
        console.log(post);
    }
    //used to add post details for calling addpost Method
    const addpostDetails = async () => {
        //calling addpost method present in postapi.js
        await addPost(post);
        //notifying post is added successfully
        alert("post Added Successfully")
        //navigating to another page using navigate
        navigate('/admin/allposts');
    }
    const handlePosts = () => {
        navigate('/admin/postcrud')
    }
    return (
        <div className='form'>
            <div className='form-body'>
                <Container maxWidth="sm">
                    <Box my={5}>
                        <Typography variant="h5" align="center">Adding post</Typography>
                        <FormGroup>
                            <FormControl>
                                <InputLabel>Enter User Name</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="userName" value={userName} />
                            </FormControl><br></br>
                            <FormControl>
                                <InputLabel>Enter post Name</InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="postName" value={postName} />
                            </FormControl><br></br>
                            <FormControl>
                                <InputLabel>Enter Date and Time </InputLabel>
                                <Input onChange={(e) => onValueChange(e)} name="date" value={date} />
                            </FormControl><br></br>
                            {/* <FormControl> */}
                            <input type='file' value={newImage} onChange={e=>addImage(e.target.value)}></input>
                                <InputLabel>Upload the Image</InputLabel>
                                {/* <Input type='url' onChange={(e) => onValueChange(e)} name="image" value={image} />
                            </FormControl><br></br> */}

                            <Box my={3}>
                                {/* calling addpostDetails() when button is clicked */}
                                <Button variant="contained" onClick={() => addpostDetails()} color="primary" align="center">Add post</Button>
                                <Button onClick={() => addpostDetails()} variant="contained" color="secondary" align="center" style={{ margin: '0px 20px' }}>Cancel</Button>
                                <br></br><br></br>
                                <Button onClick={handlePosts}>Update or Remove Post</Button>
                            </Box>
                        </FormGroup>
                    </Box>
                </Container>
            </div>
        </div>
    )
}

//exporting Addpost 
export default AdminAddPost;