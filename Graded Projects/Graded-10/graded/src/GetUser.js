import React, { useState } from 'react'

import axios from 'axios'




export default function GetUser() {


    const[data,setData]  = useState([]);


 

    function getApi(){

            axios.get("http://localhost:3000/Users")

           .then((response)=>{ setData(response.data);})  // return data if success

            .catch((error)=>{setData(error) }); // handling error in case of failure

    }



return (
<div>

    <button type="submit"  onClick={getApi} className="btn btn-warning" >display user</button>
    
    {/* <h1>{ JSON.stringify(data)}</h1> */}


    <table  className='table table-striped col-md-4'>
        <thead> <tr><th>Id</th> <th>name</th>  <th>email</th> <th>password</th>  </tr> </thead>

         <tbody>   {
                    
                    

                    data.map((item)=>{ 

                       

       return  <tr  key={item.id}><td>{item.id}</td> <td>{item.name}</td>  <td>{item.email}</td> <td>{item.password}</td> </tr>



                     })



               } 

            </tbody>

    </table>



  
</div>
)


            }


