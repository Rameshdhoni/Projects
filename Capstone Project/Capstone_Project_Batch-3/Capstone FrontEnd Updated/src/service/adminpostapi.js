import axios from 'axios';

const addadmin = "http://localhost:9002/admin/register";

export const addAdmin = async (admin) => {
    return await axios.post(addadmin,admin);
}

const approveinsert="http://localhost:9002/approve/insert"
const approveposts="http://localhost:9002/approve/posts"
const approvedelete="http://localhost:9002/approve/delete";

//Reportin user Api

const reportinsert="http://localhost:9002/report/insert"
const reportusers="http://localhost:9002/report/users"



export const addReportUser = async (user) => {
    return await axios.post(reportinsert,user);
}

//getting all waitingPost  from url

export const getallReportUsers = async (userId) => {
    userId = userId || '';
    return await axios.get(`${reportusers}/${userId}`);

}



export const addApprove = async (approve) => {
    return await axios.post(approveinsert,approve);
}

//getting all waitingPost  from url

export const getallWaitingApprove = async (id) => {
    id = id || '';
    return await axios.get(`${approveposts}/${id}`);

}

//deleting waitingPost using url

export const deleteWaitingPost = async (id) => {
    return await axios.delete(`${approvedelete}/${id}`);
}