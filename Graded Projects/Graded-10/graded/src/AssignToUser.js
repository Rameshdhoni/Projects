import React, { Component, useState } from 'react'

import axios from 'axios'
 



export default class AssignToUser extends Component {
  

    constructor(props)
    {
        super(props);

        this.state={
                "id": "", 
                "name": "",
                "email": "",
                "password": ""
        }
    }

    changeHandler=(e)=>
    {
        this.setState({[e.target.name]:e.target.value})
    }

    submitHandler=e =>
    {
        e.preventDefault();
        console.log(this.state);
        axios.post(' http://localhost:3000/Users',this.state)
        .then(response=>
            {
                console.log(response);
            })
            .catch(error=>
                {
                    console.log(error)
                })           
    }

  render() {
    const {id, name, email, password}=this.state;

    return (
      <div className='container col-md-4'>
            <h2>Add Form</h2>

          <form   onSubmit={this.submitHandler}>
            <div>
             Enter ID: <input type="text" name="id"  className='form-control'
                value={id}
                onChange={this.changeHandler}/>
           
            Enter  username: <input type="text" name="name"   className='form-control'
                value={name}
                onChange={this.changeHandler}/>
            
             Enter email:    <input type="email" name="email"  className='form-control bm-8'
                value={email}
                onChange={this.changeHandler}/>
            
           Enter  password: <input type="password" name="password"  className='form-control bm-8'
                value={password}
                onChange={this.changeHandler}/>
              </div>
            <button type="submit"  className='btn btn-primary '>submit</button>
          </form>
      </div>
    )
  }

}