
import './HomePage.css';
import React from 'react'
import { Link } from 'react-router-dom'
import { Button } from 'react-bootstrap';
import BackgroundImage from './bgp.jpg'
import logo from '../images/logo.png'
function HomePage() {
  return (
    <>
    <header style={ HeaderStyle }>
       <div>
            <h1  style={{color:'',textAlign:"center",paddingTop:70,fontSize:50,fontFamily:'ui-sans-serif'}} > <img src = {logo} alt="logo" width={100} height={100} />WELCOME TO PROFILE PAGE APPLICATION</h1>
            {/* <img src = {logo} alt="logo" width={100} height={100} /> */}
                <br/>
                <div className="Butt">
                    <Button>
                    <Link to="/userlogin" className="links">User</Link>
                    </Button>
                    <Button>
                    <Link to="/adminlogin" className="links">Admin</Link>
                    </Button><br></br>
                </div>

        </div>
        </header>
        <div className='footer'>
        <p style={{color:"red"}} >Profile Page Application is intended to the act of privacy according to the  government of India under the act of 199 ACT.Terms and Conditions are kept and defined to the Team-3 of HCL</p>
         </div>
         </>
  );
}

export default HomePage;
const HeaderStyle = {
  width: "100%",
  height: "100vh",
  background: `url(${BackgroundImage})`,
  backgroundPosition: "center",
  backgroundRepeat: "no-repeat",
  backgroundSize: "cover"
}
