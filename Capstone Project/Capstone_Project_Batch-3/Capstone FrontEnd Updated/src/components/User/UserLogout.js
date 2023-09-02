import { toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import { useNavigate } from 'react-router-dom';

const notify = (msg) => {

    toast.success(msg, {

        position: 'top-right', autoClose: 2500, hideProgressBar: true, closeOnClick: false,
        pauseOnHover: true, draggable: false, progress: undefined, theme: 'colored'

    });

}
//used to perform user logout operation
const UserLogout = () => {

    const history = useNavigate()
    //notifies Logout successfully
    alert(" User Logout Successfully")
    //navigating to another page using history.push()
    history("/")


}
//exporting UserLogout
export default UserLogout;