import axios from 'axios';

//User Api
const adduser = "http://localhost:9001/user/register";
//User API
const allusers="http://localhost:9001/user/users";
const searchusers="http://localhost:9001/user/search";
//user message API
const addmessage="http://localhost:9004/message/add";

//adding user in that url
export const addUser = async (user) => {
    return await axios.post(adduser,user);
}

//getting all Users from url
export const getallUsers = async (id) => {
    id = id || '';
    return await axios.get(`${allusers}/${id}`);
}
export const searchUser = async (userName) => {
    userName = userName || '';
    return await axios.get(`${searchusers}/${userName}`);
}
//adding message
export const addMessages = async (message) => {
    return await axios.post(addmessage,message);
}