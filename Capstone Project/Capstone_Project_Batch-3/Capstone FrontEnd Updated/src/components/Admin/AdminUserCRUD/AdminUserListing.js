import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";

const AdminUserListing = () => {
    const [userdata, userdatachange] = useState(null);
    const navigate = useNavigate();
    const LoadDetail = (userId) => {
        navigate("/user/detail/" + userId);
    }
    const LoadEdit = (userId) => {
        navigate("/user/update/" + userId);
    }
    const Removefunction = (userId) => {
        if (window.confirm('Do you want to remove?')) {
            fetch("http://localhost:9001/user/delete/" + userId, {
                method: "DELETE"
            }).then((res) => {
                alert('Removed successfully.')
                window.location.reload();
            }).catch((err) => {
                console.log(err.message)
            })
        }
    }
    useEffect(() => {
        fetch("http://localhost:9001/user/users").then((res) => {
            return res.json();
        }).then((resp) => {
            userdatachange(resp);
        }).catch((err) => {
            console.log(err.message);
        })
    }, [])
    return (
        <div className="container">
            <div className="card">
                <div className="card-title">
                    <h2>User Listing</h2>
                </div>
                <div className="card-body">
                    <div className="divbtn">
                        <Link to="/user/create" className="btn btn-success">Add New (+)</Link>
                    </div>
                    <table className="table table-bordered">
                        <thead className="bg-dark text-white">
                            <tr>
                                <td>ID</td>
                                <td>Name</td>
                                <td>Email</td>
                                <td>Password</td>
                                <td>Phone Number</td>
                                <td>Action</td>
                            </tr>
                        </thead>
                        <tbody>
                            {userdata &&
                                userdata.map(item => (
                                    <tr key={item.userId}>
                                        <td>{item.userId}</td>
                                        <td>{item.userName}</td>
                                        <td>{item.userEmail}</td>
                                        <td>{item.userPassword}</td>
                                        <td>{item.userPhone}</td>
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

export default AdminUserListing;