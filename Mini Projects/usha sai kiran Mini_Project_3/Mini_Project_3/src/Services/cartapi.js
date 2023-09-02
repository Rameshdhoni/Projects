import axios from 'axios';
const url = "http://127.0.0.1:3003/cart";

// Fetch the Cart Items from the JSON File
export const getallCart = async (id) => {
    id = id || '';
    return await axios.get(`${url}/${id}`);
}

// Add the Cart Items
export const addCart = async (cart) => {
    return await axios.post(url,cart);
}

// Edit or Update the Cart Item Details
export const editCart = async (id, cart) => {
    return await axios.put(`${url}/${id}`,cart);
}

// Delete the Item from the JSON file
export const deleteCart = async (id) => {
    return await axios.delete(`${url}/${id}`);
}