import axios from 'axios';
//User Api
const adduser = "http://localhost:9002/admin/register";
//User API
const allusers = "http://localhost:9002/admin/users";
const searchusers = "http://localhost:9002/admin/search";
//user message API
//const addmessage= "http://localhost:9002/adminmsg/add";

//adding user in that url
export const addUser = async (admin) => {
    return await axios.post(adduser, admin);
}

//getting all User from url
export const getallUsers = async (id) => {
    id = id || '';
    return await axios.get(`${allusers}/${id}`);
}
export const searchUser = async (adminName) => {
    adminName = adminName || '';
    return await axios.get(`${searchusers}/${adminName}`);
}
