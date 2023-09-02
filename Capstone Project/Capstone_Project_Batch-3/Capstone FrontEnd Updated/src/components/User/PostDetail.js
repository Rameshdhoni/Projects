import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";


const PostDetail = () => {
    const { userId } = useParams();

    const [postdata, postdatachange] = useState({});

    //fetch specific post details by id 
    useEffect(() => {
        fetch("http://localhost:9001/post/detail/" + userId).then((res) => {
            return res.json();
        }).then((resp) => {
            postdatachange(resp);
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
                        <h2>post Creation</h2>
                    </div>
                    <div className="card-body"></div>

                    {postdata &&
                        <div>
                            <h2>The post name is : <b>{postdata.postName}</b>  ({postdata.userId})</h2>
                            <h3>Post Details</h3>
                            <h5>User name {postdata.userName}</h5>
                            <h5>Date and Time : {postdata.date}</h5>
                            <img className="product-image" src={postdata.image} alt="img" style={{ height: '150px' }} /><br></br>
                            <Link className="btn btn-danger" to="/postcrud">Back to Listing</Link>
                        </div>
                    }
                </div>
            </div>
            {/* </div>
            </div> */}
        </div >
    );
}

export default PostDetail;