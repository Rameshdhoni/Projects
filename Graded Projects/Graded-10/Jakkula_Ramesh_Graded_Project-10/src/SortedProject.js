import { useState } from "react";

function SortedProject() {

    const[data,setData]  = useState([]);


    function getApi(){

            fetch(" http://localhost:3000/Milestones")
            .then((response)=> response.json())
            .then((jsonData)=>{console.log(jsonData.sort()); setData(jsonData);
            });

    }



return (
<div>

    <button type="submit"  onClick={getApi} className="btn btn-warning" >Sort Projects</button>
    
    {/* <h1>{ JSON.stringify(data)}</h1> */}


    <table  className='table table-striped col-md-4'>
        <thead> <tr><th>Id</th> <th>Milestone</th>  <th>project</th> <th>stage</th> <th>complitionDate</th> <th>TL</th> <th>assignedTo</th>   </tr> </thead>

         <tbody>   {
                    
                    

                    data.map((item)=>{ 

                       

       return  <tr  key={item.id}><td>{item.id}</td> <td>{item.milestone}</td>  <td>{item.project}</td>  <td>{item.stage}</td> <td>{item.complitionDate}</td>  <td>{item.TL}</td> <td>{item.assignedTo}</td>     </tr>



                     })



               } 

            </tbody>

    </table>



  
</div>
)
}

export default SortedProject
