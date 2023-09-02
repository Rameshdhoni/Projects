import React, { useEffect, useState } from 'react';

import { Button } from '@mui/material';
import { Link } from 'react-router-dom';
import { deleteWaitingPost, getallWaitingApprove } from '../../service/adminpostapi'
import { addPost } from '../../service/postapi';

//displays all Post bookigs need his approval
const AdminPostApproval = () => {
    //getting Ownername form localstorage
    const adminName = localStorage.getItem('adminName');
    const [post, setPost] = useState([]);
    useEffect(() => {
        //calling getPost()
        getPost();
    }, [])

    //getting all Post bookigs need his approval
    const getPost = async () => {
        //getting and storing that Posts to variable
        const response = await getallWaitingApprove();
        //displaying all Post bookigs need his approval in console
        console.log(response);
        //assiging that all Posts to Post using setPost
        setPost(response.data);
    }
    const addpost = async () => {

        let post_items = {

            postName: post.postName,
            image: post.image,
            date: post.date,
            userName: post.userName,

        }
        await addPost(post_items);
        alert('Approved!!!!')
    }
    const deleteWaitingPosts = async (id) => {
        await deleteWaitingPost(id);//delete from waiting Posts
        //calling getPost()
        getPost();
        alert('The Post has been Rejected by the Admin')
    }

    return (
        <div className="container">
            <div className="card">
                <div className="card-title">
                    <h2>Post Listing</h2>
                </div>
                <div className="card-body">
                    <div className="divbtn">
                        {/* <Link to="/post/create" className="btn btn-success">Add New (+)</Link> */}
                    </div>
                    <table className="table table-bordered">
                        <thead className="bg-dark text-white">
                            <tr>
                                <td>ID</td>
                                <td>User Name</td>
                                <td>Post Name</td>
                                <td>Image</td>
                                <td>Date and Time</td>
                                <td>Status</td>
                                <td>Action</td>

                            </tr>
                        </thead>
                        <tbody>

                            {post &&
                                post.map(item => (
                                    <tr key={item.id}>

                                        <td>{item.id}</td>
                                        <td>{item.userName}</td>
                                        <td>{item.postName}</td>
                                        <td><img className="product-image" src={item.image} alt="img" style={{ height: '150px' }} /><br></br></td>
                                        <td>{item.date}</td>
                                        <td> Waiting for your Approval</td>
                                        <td>
                                            {/* <Button variant="contained" onClick={() => addpost()} color="primary" align="center">Approve</Button><br></br><br></br> */}
                                            {/* this button is used to Approve the pending Post booking  */}
                                            <Button variant="contained" color="secondary" style={{ margin: '0px 20px' }} onClick={() => deleteWaitingPosts(item.id)}>Cancel</Button>
                                            <Button variant="contained" color="primary" style={{ margin: '0px 20px' }} component={Link} to={`/approved/${item.id}`}>Approve</Button>
                                        </td>
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

//exporting OwnerApprovePost
export default AdminPostApproval;
