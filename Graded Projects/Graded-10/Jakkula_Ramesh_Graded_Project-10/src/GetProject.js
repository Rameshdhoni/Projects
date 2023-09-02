
import React, { useState } from 'react'
import Delete from './Delete';

function GetProject() {

        const[data,setData]  = useState([]);


        function getApi(){

                fetch(" http://localhost:3000/Milestones")
                .then((response)=> response.json())
                .then((jsonData)=>{console.log(jsonData.sort()); setData(jsonData);
                });

        }



  return (
    <div>

        <button type="submit"  onClick={getApi} className="btn btn-warning" >Get Projects</button>
        
        {/* <h1>{ JSON.stringify(data)}</h1> */}


        <table  className='table table-striped col-md-4'>
            <thead> <tr><th>Id</th> <th>Milestone</th>  <th>project</th> <th>stage</th> <th>complitionDate</th> <th>TL</th> <th>assignedTo</th> <th>Delete</th>  </tr> </thead>

             <tbody>   {
                        
                        

                        data.map((item)=>{ 

                           

           return  <tr  key={item.id}><td>{item.id}</td> <td>{item.milestone}</td>  <td>{item.project}</td>  <td>{item.stage}</td> <td>{item.complitionDate}</td>  <td>{item.TL}</td> <td>{item.assignedTo}</td>   <Delete pid={item.id}></Delete>  </tr>
   


                         })



                   } 

                </tbody>

        </table>



      
    </div>
  )
}

export default GetProject
