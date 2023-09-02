
import React, { useState } from 'react';
import { Container, Typography, FormControl, InputLabel, Input, Box, FormGroup, Button, Card } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import { addMessages } from '../../service/userapi';

const initialValue = {
    id: "",
    content: "",
    date: "",
    fromUser: "",
    toUser: "",
    
}

const Messages = () => {
    const [messages, setMessages] = useState(initialValue);
    const { id, content, date, fromUser, toUser} = messages;
    //declering history as useNavigate()
    const navigate = useNavigate();

    
    //onchange value ()
    const onValueChange = (e) => {
        e.preventDefault();
        setMessages({ ...messages, [e.target.name]: e.target.value });
        console.log(messages);
    }

    //used to addMessages details to table
    const MessagesDetails = async () => {
            await addMessages(messages);
            alert("Message sent Successfully!!!!!!")
           navigate('/allpost')
    }

    return (
        <div className='form'>
            <div className='form-body'>
                <Card>
                    <Container maxWidth="sm">
                        <Box my={5}>
                            <Typography variant="h5" align="center">Message</Typography><br></br>
                            <FormGroup>
                                <FormControl>
                                    <InputLabel>Id</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="id" value={id} />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>Content</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="content" value={content}  type="text" />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>date</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="date" value={date}  />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>fromUser</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="fromUser" value={fromUser} type="text" />
                                </FormControl><br></br>
                                <FormControl>
                                    <InputLabel>TO User</InputLabel>
                                    <Input onChange={(e) => onValueChange(e)} name="toUser" value={toUser} />
                                </FormControl><br></br>
                                
                                <Box my={3}>
                                    {/* this button is used to call addUserDetails() */}
                                    <Button variant="contained" onClick={() => MessagesDetails()} color="primary" align="center">Sent Message</Button>
                                  
                                    

                                </Box>
                            </FormGroup>
                        </Box>
                    </Container>
                </Card>
            </div>
        </div>
    )
}


export default Messages;