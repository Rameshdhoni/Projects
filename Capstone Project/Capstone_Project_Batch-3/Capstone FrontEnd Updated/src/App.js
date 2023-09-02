import AllPosts from './components/User/AllPost';
import React from 'react';
import { Route, Routes } from 'react-router-dom';
import './App.css';
import HomePage from './components/HomePage';
import UserRegister from './components/User/UserRegister';
import UserLogin from './components/User/UserLogin';
import UserLogout from './components/User/UserLogout';
import AdminRegister from './components/Admin/AdminRegister';
import AdminLogin from './components/Admin/AdminLogin';
import AdminLogout from './components/Admin/AdminLogout';
import Addpost from './components/User/AddPost';
import UserListing from './components/User/UserListing';
import ReportUser from './components/User/ReportUser';
import AdminAllPost from './components/Admin/AdminAllPost';
import AdminAddPost from './components/Admin/AdminAddPost';
import AdminPostApproval from './components/Admin/AdminPostApproval';
import UserProfile from './components/User/UserProfile';
import ViewReportUser from './components/User/ViewReportUser';
import PostListing from './components/User/PostListing';
import PostDetail from './components/User/PostDetail';
import PostEdit from './components/User/PostEdit';
import PostCreate from './components/User/PostCreate';
import AdminProfile from './components/Admin/AdminProfile';
import AdminPostListing from './components/Admin/AdminPostCRUD/AdminPostListing';
import ConfirmApproval from './components/Admin/AdminConfirmApproval';
import AdminUserListing from './components/Admin/AdminUserCRUD/AdminUserListing';
import UserCreate from './components/Admin/AdminUserCRUD/AdminUserCreate';
import UserDetail from './components/User/UserDetail';
import UserEdit from './components/User/UserEdit';
import ListReportUser from './components/Admin/AdminListReportUser';
import UserSearch from './components/User/UserSearch';
import Messages from './components/User/Messages';




function App() {
  return (
    <>
    <div className="App">
       <Routes>
        <Route path='/' element={<HomePage/>}></Route>
        {/* User Part */}
        <Route path='/userregister' element={<UserRegister></UserRegister>}></Route>
        <Route path='/userlogin' element={<UserLogin/>}></Route>
        <Route path='/userlogout' element={<UserLogout/>}></Route>
        <Route path='/allpost' element={<AllPosts/>}></Route>
        <Route path='/addpost' element={<Addpost/>}></Route>
        <Route path='/usercrud' element={<UserListing />}></Route>
        <Route path='/reportuser' element={<ReportUser/>}></Route>
        <Route path='/userprofile' element={<UserProfile/>}></Route>
        <Route path='/reported/:id' element={<ViewReportUser/>}></Route>
        <Route path='/postcrud' element={<PostListing/>}></Route>
        <Route path='/post/create' element={<PostCreate/>}></Route>
        <Route path='/post/detail/:userId' element={<PostDetail/>}></Route>
        <Route path='/post/update/:userId' element={<PostEdit/>}></Route>
        <Route path='/user/create' element={<UserCreate />}></Route>
        <Route path='/user/update/:userId' element={<UserEdit />}></Route>
        <Route path='/user/detail/:userId' element={<UserDetail />}></Route>
        <Route path='/report/users/:id' element={<ListReportUser/>}></Route>
        <Route path='/repotuser' element={<ReportUser/>}></Route>
        <Route path='/reported/:id' element={<ViewReportUser/>}></Route>
        <Route path='/message' element={<Messages/>}></Route>
         <Route path='/user/search/:userName' element={<UserSearch/>}></Route>
        {/* Admin Part */}
        <Route path='/adminlogin' element={<AdminLogin/>}></Route>
        <Route path='/adminregister' element={<AdminRegister/>}></Route>
        <Route path='/adminlogout' element={<AdminLogout/>}></Route>
        <Route path='/admin/allposts' element={<AdminAllPost/>}></Route>
        <Route path='/adminaddpost' element={<AdminAddPost/>}></Route>
        <Route path='/admin/postcrud' element={<AdminPostListing/>}></Route>
        <Route path='/admin/postapprove' element={<AdminPostApproval/>}></Route>
        <Route path="/approved/:id" element={<ConfirmApproval/>}></Route>
        <Route path='/admin/usercrud' element={<AdminUserListing/>}></Route>
        <Route path='/adminprofile' element={<AdminProfile/>}></Route>
        </Routes>
        </div>
        
        </>
  );
  
  }
export default App;
