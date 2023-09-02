import React, { useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button, Select, MenuItem } from '@mui/material';
import { addPost } from '../../service/postapi';
import { useNavigate } from 'react-router-dom';
import '../../App.css'
import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './Login.css'

import { addApprove } from '../../service/adminpostapi';



const initialValue = {
    userId: "",
    userName: "",
    postName: "",
    date: "",
    image: ""


}
//used to add post details to table
const Addpost = () => {

    const [post, setpost] = useState(initialValue);
    const { userName, postName, date, image } = post;
    var[newImage,addImage]=useState([]);
    var[newName,addName]=useState([]);

    //declaring history as useHistory
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
        //alert("post Added Successfully")
        alert('The Post has been sent to Admin for Approval')
        //navigating to another page using history.push
        navigate('/allPost');
    }
    const handlePosts = () => {
        navigate('/postcrud')
    }
    const handleCancle = () => {
        navigate('/allpost')
    }

    //add post
    const addpost = async () => {


        let post_items = {

            postName: post.postName,
            image: post.image,
            date: post.date,
            userName: post.userName,

        }
        var addNew={
            image:newImage.replace("C:\Users\rames\OneDrive\Pictures\Saved Pictures",""),
           
            "postName":postName,
            "userName":userName
        }
        
        //sent to admin for approval
        await addApprove(post_items);
        alert('The post has been sent to Admin Approval !!!!')
        navigate('/allpost')
    }


    return (
        <div className='form'>
            <div className='form-body'>
            <img src="logo.png" alt="pic"></img><br></br>
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
                            <input type='file' value={newImage} onChange={e=>addImage(e.target.value)} /><br></br>
                        
                            {/* <FormControl> */}
                                {/* Enter URL  */}
                                <InputLabel >Upload the Image  </InputLabel>

                                {/* <Input type='url' onChange={(e) => onValueChange(e)} name="image" value={image} /> */}
                            {/* </FormControl><br></br> */}

                            <Box my={3}>

                                {/* calling addpostDetails() when button is clicked */}
                                <Button variant="contained" onClick={() => addpost()} color="primary" align="center">Add post</Button>
                                <Button onClick={handleCancle} variant="contained" color="secondary" align="center" style={{ margin: '0px 20px' }}>Cancel</Button>
                                <br></br><br></br>
                                <Button onClick={handlePosts}>Update Or Delete Post</Button>


                            </Box>
                        </FormGroup>
                    </Box>
                </Container>
            </div>
        </div>
    )
}

//exporting Addpost 
export default Addpost;