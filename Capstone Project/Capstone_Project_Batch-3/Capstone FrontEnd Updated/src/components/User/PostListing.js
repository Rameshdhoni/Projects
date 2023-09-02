import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const PostListing = () => {
    const [postdata, postdatachange] = useState(null);
    const navigate = useNavigate();

    //loads the post details
    const LoadDetail = (userId) => {
        navigate("/post/detail/" + userId);
    }
    //maps to update post
    const LoadEdit = (userId) => {
        navigate("/post/update/" + userId);
    }
    //post removing function
    const Removefunction = (userId) => {
        if (window.confirm('Do you want to remove?')) {
            fetch("http://localhost:9001/post/delete/" + userId, {
                method: "DELETE"
            }).then((res) => {
                alert('Removed successfully.')
                window.location.reload();
            }).catch((err) => {
                console.log(err.message)
            })
        }
    }
    //used to fetch all posts

    useEffect(() => {
        fetch("http://localhost:9001/post/posts").then((res) => {
            return res.json();
        }).then((resp) => {
            postdatachange(resp);
        }).catch((err) => {
            console.log(err.message);
        })
    }, [])

    return (
        <div className="container">
            <div className="card">
                <div className="card-title">
                    <h2>Post Listing</h2>
                </div>
                <div className="card-body">
                    {/* <div className="divbtn">
                        <Link to="/post/create" className="btn btn-success">Add New (+)</Link>
                    </div> */}
                    <table className="table table-bordered">
                        <thead className="bg-dark text-white">
                            <tr>
                                <td>ID</td>
                                <td>User Name</td>
                                <td>Post Name</td>
                                <td>Image</td>
                                <td>Date and Time</td>
                                <td>Action</td>
                            </tr>
                        </thead>
                        <tbody>

                            {postdata &&
                                postdata.map(item => (
                                    <tr key={item.userId}>
                                        <td>{item.userId}</td>
                                        <td>{item.userName}</td>
                                        <td>{item.postName}</td>
                                        <td><img className="product-image" src={item.image} alt="img" style={{ height: '150px' }} /><br></br></td>
                                        <td>{item.date}</td>
                                        <td><a onClick={() => { LoadEdit(item.userId) }} className="btn btn-success">Edit</a>
                                            <a onClick={() => { Removefunction(item.userId) }} className="btn btn-danger">Remove</a>
                                            <a onClick={() => { LoadDetail(item.userId) }} className="btn btn-primary">Details</a>
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

export default PostListing;