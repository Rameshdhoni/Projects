import React, { Component } from 'react'
import axios from 'axios'
import Suggestions from './SearchSuggestions'

//search user by username
class Search extends Component {
  constructor(){
    super()
  this.state = {
    userName: '',
    results: []
  }
}

// fetch user details by username
  getInfo = () => {
    axios.get(`http://localhost:9001/user/search/${this.state.userName}`)
      .then( response  => {
          console.log(111,response)
        this.setState({
          results: response.data               
        })
      })
  }
 
  clearResults = () => {

    this.setState({
      results:[],
      query: ''
    })
  }

  handleInputChange = () => {
    this.setState({
      userName: this.search.value
    }, () => {
      if (this.state.userName && this.state.userName.length >= 1) {

          this.getInfo()
        
      }else if(this.state.userName.length === 0){
      this.clearResults()
      }
    })
    
  }

  render() {
    return (
        <div>
        <form class="navbar-form navbar-left">
            <div class="form-group">
              <input type="text" class="form-control" value={this.state.userName}
              placeholder="Search for..."
              ref={input => this.search = input}
              onChange={this.handleInputChange}
            />
            </div>
            {/* <p>{this.state.userName}</p> */}
      </form>
      <Suggestions
      results={this.state.results} 
      onClick={this.clearResults}/>
      </div>
    )
  }
}

export default Search;

