import { Card } from '@mui/material';
import React, { Component } from 'react'
import { Link } from 'react-router-dom';

class Suggestions extends Component {
    constructor() {
        super()
        this.state = {

        }
    }
    render() {
        const options = this.props.results.map(r => (
            //maps to get user by specific username
            <Link to={{ pathname: `/user/search/${r.userName}` }} onClick={this.props.onClick}>
                <Card key={r.userName} class="search-suggestion">
                    <p class="search-suggestion-name">{r.userName}</p>
                    {/* <h3>{r.userEmail}</h3> */}

                </Card>
            </Link>
        ))
        return <Card class="search-suggestions">{options}</Card>
    }
}

export default Suggestions;