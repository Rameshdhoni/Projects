import React, { Component } from 'react'
import { Redirect, Link, Switch, Route } from 'react-router-dom'
import axios from 'axios'


class Profile extends Component {
    constructor() {
        super()
        this.state = {
            profilePage: "timeline",
            viewedUser: {}
        }
    }
    componentWillMount() {
        this.loadProfile()
    }
    componentDidUpdate(prevProps) {
        if (prevProps.match.params.userId !== this.props.match.params.userId) {
            this.loadProfile()
        }
    }
    checkConnection() {
        if (this.props.user.userId === this.state.viewedUser.userId) {
            return true
        } else {
            return false
        }
    }
    loadProfile(val) {
        let { userName } = val ? val : this.props.match.params
        // console.log('Id in load profile', id)
        axios.get(`http://localhost:9001/user/search/${userName}`).then(response => {
            if (response.data[0].userName === +this.props.match.params.userName) {
                this.setState({
                    viewedUser: response.data[0]
                })
            }
        })

        axios.get(`http://localhost:9001/user/search/${userName}`).then(response => {
            if (response.data[0] === this.props.match.params.userName) {
                response.data.shift()
                this.setState({
                    friends: response.data
                })
            }
        })
    }
    render() {

        return (

            <div className="profile-header col-xs-12">
                <img alt={this.state.viewedUser.fisrt_name} src={this.state.viewedUser.profile_img} />
                <h3>{this.state.viewedUser.userName}</h3>
                <h1>hi</h1>
            </div>
        )
    }

}
export default Profile;