import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import Dashboard from './Dashboard';
import { Router, Route,  browserHistory, IndexRoute } from 'react-router';


import ReactDOM from 'react-dom';
import GoogleLogin from 'react-google-login';



const responseGoogle = (response) => {
  console.log(response);
}

class App extends Component {
  
  constructor(){
    super();
        this.state={
        appName: "Office Meals",
    }
    }

  render() {
    return (
    
      <div className="App">

    
      
        <Dashboard>

        


        </Dashboard>
      </div>
    );
  }
}

export default App;

