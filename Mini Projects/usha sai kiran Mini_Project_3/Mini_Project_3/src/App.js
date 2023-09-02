import './App.css';
import Home from './Components/Home';
import Navbar from  './Components/Navbar';
import AdminLogin from './Components/Admin-Components/AdminLogin';
import AdminPage from './Components/Admin-Components/AdminPage';
import UserRegister from './Components/User-Components/UserRegister';
import UserLogin from './Components/User-Components/UserLogin';
import UserPage from './Components/User-Components/UserPage';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

function App() {
  return (
    <Router>
      {/* The Apis to redirect ot the respective page */}
      <Navbar />
      <Switch>
        <Route path="/" component={Home} exact />
        <Route path="/adminpage" component={AdminPage} exact />
        <Route path="/admin" component={AdminLogin} exact />
        <Route path="/userpage" component={UserPage} exact />
        <Route path="/users" component={UserRegister} exact />
        <Route path="/login" component={UserLogin} exact />
      </Switch>
    </Router>
  );
}

export default App;
