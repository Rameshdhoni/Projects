


import React, { Component, useState } from 'react'

import axios from 'axios'
 



export default class UodateComponent extends Component {
  

    constructor(props)
    {
        super(props);

        this.state={
                "id": "", 
                "milestone":"", 
                "project":"", 
                "stage":"", 
                "complitionDate":"",
                "TL": "", 
                "assignedTo":"" 
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
        axios.put('http://localhost:3000/Milestones/3',this.state)
        .then(response=>
            {
              this.setState({ updatedAt: response.data.updatedAt })
            })
            .catch(error=>
                {
                    console.log(error)
                })           
    }

  render() {
    const {id, milestone, project, stage, complitionDate, TL, assignedTo}=this.state;

    return (
      <div className='container col-md-4'>
            <h2>update(add)Form</h2>

          <form   onSubmit={this.submitHandler}>
            <div>
             Enter ID: <input type="text" name="id"  className='form-control'
                value={id}
                onChange={this.changeHandler}/>
           
            Enter  milestone: <input type="text" name="milestone"   className='form-control'
                value={milestone}
                onChange={this.changeHandler}/>
            
             Enter project:    <input type="text" name="project"  className='form-control bm-8'
                value={project}
                onChange={this.changeHandler}/>
            
           Enter  stage:    <input type="text" name="stage"  className='form-control bm-8'
                value={stage}
                onChange={this.changeHandler}/>
           Enter complitionDate:    <input type="date" name="complitionDate"  className='form-control bm-8'
                value={complitionDate}
                onChange={this.changeHandler}/>
                Enter  TL :    <input type="text" name="TL"  className='form-control bm-8'
                                value={ TL}
                                onChange={this.changeHandler}/>
                                
                Enter  assignedTo :    <input type="text" name="assignedTo"  className='form-control bm-8'
                                value={assignedTo}
                onChange={this.changeHandler}/>
              </div>
            <button type="submit"  className='btn btn-primary '>submit</button>
          </form>
      </div>
    )
  }



}