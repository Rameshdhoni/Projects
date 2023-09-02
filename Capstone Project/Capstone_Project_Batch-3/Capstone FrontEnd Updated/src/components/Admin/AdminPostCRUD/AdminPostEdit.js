import { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";

const AdminPostEdit = () => {
    const { userId } = useParams();
    //const [postdata, postdatachange] = useState({});

    useEffect(() => {
        fetch("http://localhost:9001/post/update/" + userId).then((res) => {
            return res.json();
        }).then((resp) => {
            idchange(resp.id);
            namechange(resp.userName);
            postchange(resp.postName);
            imagechange(resp.image);
            datechange(resp.date);
            activechange(resp.isactive);
        }).catch((err) => {
            console.log(err.message);
        })
    }, []);

    const [id, idchange] = useState("");
    const [userName, namechange] = useState("");
    const [postName, postchange] = useState("");
    const [image, imagechange] = useState("");
    const [date, datechange] = useState("");
    const [active, activechange] = useState(true);
    const [validation, valchange] = useState(false);

    const navigate = useNavigate();

    const handlesubmit = (e) => {
        e.preventDefault();
        const postdata = { userId, userName, postName, image, date, active };

        fetch("http://localhost:9001/post/update/" + userId, {
            method: "PUT",
            headers: { "content-type": "application/json" },
            body: JSON.stringify(postdata)
        }).then((res) => {
            alert('Saved successfully.')
            navigate('/postcrud');
        }).catch((err) => {
            console.log(err.message)
        })
    }
    return (
        <div>
            <div className="row">
                <div className="offset-lg-3 col-lg-6">
                    <form className="container" onSubmit={handlesubmit}>
                        <div className="card" style={{ "textAlign": "left" }}>
                            <div className="card-title">
                                <h2>post Edit</h2>
                            </div>
                            <div className="card-body">
                                <div className="row">
                                    <div className="col-lg-12">
                                        <div className="form-group">
                                            <label>ID</label>
                                            <input value={id} disabled="disabled" className="form-control"></input>
                                        </div>
                                    </div>
                                    <div className="col-lg-12">
                                        <div className="form-group">
                                            <label>User Name</label>
                                            <input value={userName} onChange={e => namechange(e.target.value)} className="form-control"></input>
                                        </div>
                                    </div>
                                    <div className="col-lg-12">
                                        <div className="form-group">
                                            <label>Post Name</label>
                                            <input required value={postName} onMouseDown={e => valchange(true)} onChange={e => postchange(e.target.value)} className="form-control"></input>
                                            {postName.length == 0 && validation && <span className="text-danger">Enter the name</span>}
                                        </div>
                                    </div>
                                    <div className="col-lg-12">
                                        <div className="form-group">
                                            <label>Image</label>
                                            <input type='url' value={image} onChange={e => imagechange(e.target.value)} className="form-control"></input>
                                            {/* <img className="product-image" src={data.image} alt="img" style={{height:'150px' }}/><br></br>
        <InputLabel>Upload the Image</InputLabel>
        <Input type='url' onChange={(e) => onValueChange(e)} name="image" value={image} /> */}
                                        </div>
                                    </div>
                                    <div className="col-lg-12">
                                        <div className="form-group">
                                            <label>date</label>
                                            <input value={date} onChange={e => datechange(e.target.value)} className="form-control"></input>
                                        </div>
                                    </div>
                                    <div className="col-lg-12">
                                        <div className="form-check">
                                            <input checked={active} onChange={e => activechange(e.target.checked)} type="checkbox" className="form-check-input"></input>
                                            <label className="form-check-label">Is Active</label>

                                        </div>
                                    </div>
                                    <div className="col-lg-12">
                                        <div className="form-group">
                                            <button className="btn btn-success" type="submit">Save</button>
                                            <Link to="/postcrud" className="btn btn-danger">Back</Link>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}

export default AdminPostEdit;