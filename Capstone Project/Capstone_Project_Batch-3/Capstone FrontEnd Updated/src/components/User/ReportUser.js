import React, { useEffect, useState } from 'react';

import { Table, TableCell, TableRow, TableHead, TableBody, makeStyles, Button } from '@mui/material';
import { Link } from 'react-router-dom';
import { deleteWaitingPost, getallUsers, getallWaitingApprove } from '../../service/userapi'
import '../../App.css'
import { addPost } from '../../service/postapi';
import { addApprove, getallReportUsers } from '../../service/adminpostapi';


//displays all User bookigs need his approval
const ReportUser = () => {

    const [user, setUser] = useState([]);
    useEffect(() => {
        //calling getUser()
        getUser();
    }, [])

    //getting all User bookigs need his approval
    const getUser = async () => {
        //getting and storing that Users to variable
        const response = await getallUsers();
        //displaying all User bookigs need his approval in console
        console.log(response);
        //assiging that all Users to User using setUser
        setUser(response.data);
    }

    return (

        <div className="container">
            <div className="card">
                <div className="card-title">
                    <h2>Report User</h2>
                </div>
                <div className="card-body">
                    <div className="divbtn">
                        {/* <Link to="/post/create" className="btn btn-success">Add New (+)</Link> */}
                    </div>
                    <table className="table table-bordered">
                        <thead className="bg-dark text-white">
                            <tr>
                                <td>UserId</td>
                                <td>User Name</td>
                                <td>User Email</td>
                                <td>User Password</td>
                                <td>User Phone</td>
                                <td>Action</td>

                            </tr>
                        </thead>
                        <tbody>

                            {user &&
                                user.map(item => (
                                    <tr key={item.userId}>
                                        <td>{item.userId}</td>
                                        <td>{item.userName}</td>
                                        <td>{item.userEmail}</td>
                                        <td> {item.userPassword}</td>
                                        <td>{item.userPhone}</td>


                                        {/* this button is used to Approve the pending User booking  */}

                                        <td>  <Button variant="contained" color="error" style={{ margin: '0px 20px' }} component={Link} to={`/reported/${item.userId}`}>Report User</Button></td>
                                    </tr>
                                ))
                            }

                        </tbody>

                    </table>
                </div>
            </div>
        </div>
    );
}

//exporting OwnerApproveUser
export default ReportUser;
