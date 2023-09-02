import logo from './logo.svg';
import './App.css';
import Dashboard from './Dashboard.jpg'
import Home from './Home';

function App() {
  return (
    <div className="App">
      <h1 className='APP' style={{color:"red"}}>Welcome to Leader Dashboard online application</h1>
      <Home></Home>

     
     <img src={Dashboard} alt="mypic"></img> 
    
    </div>
  );
}

export default App;
