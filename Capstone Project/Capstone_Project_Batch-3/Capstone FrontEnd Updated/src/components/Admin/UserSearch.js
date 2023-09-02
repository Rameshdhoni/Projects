import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

const UserSearch = () => {
    const { userName } = useParams();
    const [userdata, userdatachange] = useState({});

    useEffect(() => {
        fetch("http://localhost:9001/user/searchs/" + userName).then((res) => {
            return res.json();
        }).then((resp) => {
            userdatachange(resp);
        }).catch((err) => {
            console.log(err.message);
        })
    }, []);
    return (
        <div>
            {/* <div className="row">
<div className="offset-lg-3 col-lg-6"> */}

            <div className="container">
                <div className="card row" style={{ "textAlign": "left" }}>
                    <div className="card-title">
                    </div>
                    <div className="card-body"></div>
                    {userdata &&
                        <div>
                            <h2>The User name is : <b>{userdata.userName}</b>  ({userdata.userId})</h2>
                            <h3>User Details</h3>
                            <h5>Email is : {userdata.userEmail}</h5>
                            <h5>Password is : {userdata.userPassword}</h5>
                            <h5>Phone Number : {userdata.userPhone}</h5>
                        </div>
                    }
                </div>
            </div>
            {/* </div>
</div> */}
        </div >
    );
}

export default UserSearch;