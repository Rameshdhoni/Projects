import React from 'react';
import { Container, Typography, Box } from '@material-ui/core';
import '../App.css'

const Home = () => {
    return (
        <Container maxWidth="lg">
            <Box my={5}>
                <Typography variant="h4" component="h2" align="center">WELCOME</Typography>
            </Box>
            <Box>
                <img className='img1' src = './Images/Breakfast.jpg' alt='./Images/Breakfast.jpg' ></img>
                <img className='img2' src = './Images/Lunch.jpg' alt='./Images/Lunch.jpg'></img>
            </Box>
        </Container>
    )
}

export default Home;