import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
//used to Dispalay Admin profile details 
export default function AdminProfile() {
    return (
        <div className='box'>
            <Card sx={{ width: '500px', height: '500px', backgroundColor: 'white', position: 'absolute' }}>
                <CardContent>
                    <Typography gutterBottom variant="h4" component="div">
                        <AccountCircleIcon sx={{ fontSize: 40, color: "blue" }} />Admin Profile
                    </Typography>
                    <hr></hr>
                    <Typography gutterBottom variant="h6" component="div">
                        <b>Admin Id: {localStorage.getItem('UId')}</b>
                    </Typography>
                    <Typography gutterBottom variant="h6" component="div">
                        Username: {localStorage.getItem('UName')}
                    </Typography>
                    <Typography gutterBottom variant="h6" component="div">
                        Email: {localStorage.getItem('UEmail')}
                    </Typography>
                    <Typography gutterBottom variant="h6" component="div">
                        PhoneNumber: {localStorage.getItem('UPhone')}
                    </Typography>
                </CardContent>
            </Card>
        </div>
    );
}