
import React from 'react'
import { BrowserRouter, Link, Routes , Route } from 'react-router-dom'

import AddProject from './AddProject'
import AssignToUser from './AssignToUser'

import GetProject from './GetProject'
import GetUser from './GetUser'
import SortedProject from './SortedProject'

import Update from './Update'

function Home() {
  return (
    <div>

    <BrowserRouter>

           <header>
    <nav class="navbar navbar-default">

       <button  type="button" class="btn btn-warning" ><Link  to="/" >Home</Link></button>
       <button  type="button" class="btn btn-success" ><Link  to="/add" >AddProject</Link></button>
       <button  type="button" class="btn btn-secondary" ><Link  to="/assign" >AssignToUser</Link></button>
       <button  type="button" class="btn btn-warning" ><Link  to="/getuser" >GetUser</Link></button>
       <button  type="button" class="btn btn-danger" ><Link  to="/update" >UpdateProject</Link></button>
       <button  type="button" class="btn btn-danger" ><Link  to="/sorted" >SortedProject</Link></button>
    </nav>
    </header>


        
        <Routes>

            <Route exact path="/" element={<GetProject/>}></Route>

            <Route path="/add"  element={<AddProject />} > </Route>

            <Route path="/update"  element={<Update/>} > </Route>

            <Route path="/assign"  element={<AssignToUser/>} > </Route>
            <Route path="/getuser"  element={<GetUser/>} > </Route>
            <Route path="/sorted"  element={<SortedProject/>} > </Route>
        </Routes>
    
    
    
    </BrowserRouter>



     

      
    </div>
  )
}

export default Home
