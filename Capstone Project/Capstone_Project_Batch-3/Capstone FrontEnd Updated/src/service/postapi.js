import axios from 'axios';


const addpost = "http://localhost:9001/post/new"
const allposts = "http://localhost:9001/post/posts";
const deletepost = "http://localhost:9001/post/delete";
const updatepost = "http://localhost:9001/post/update";


//getting all posts from url
export const getallPosts = async (id) => {
    id = id || '';
    return await axios.get(`${allposts}/${id}`);
}
//adding post in that url
export const addPost = async (post) => {
    return await axios.post(addpost, post);
}

//editing post details using url
export const editPost = async (id, post) => {
    return await axios.put(`${updatepost}/${id}`, post);
}

//deleting post using url
export const deletePost = async (id) => {
    return await axios.delete(`${deletepost}/${id}`);
}



