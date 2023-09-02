************************************BACK END************************* 

Micro Services Created:

1)User Micro Service: Having port number=9001.

Entities Created...
-->User
-->Post

Controllers

.User{ url--@RequestMapping("/user") =>
           --(/register) => to register the users
           --(/login)   => to login the users
           --(/users)   => to get all the users
           --(/update/{id}) => to update user by id
           --(/detail/{id}) => to get the user details
           --(/delete/{id}) => to delete the user by id
           --(/searchs/{userName})=> to search the alluser by name
           --(/search/{userName}) => to search only one user by name
          }

.Post{ url--@RequestMapping("/post") =>
           --(/new) => for adding the new post
           --(/posts) =>  to show the post
           --(/update/{id}) => to 
           --(/delete/{id}) =>
           --(/searchs/{userName}) =>
           --(/search/{userName}) =>
           --(/detail/{id}) =
          }
.Message{url--@RequestMapping("usermsg") =>
           --(/add) => for adding the new message
           --(/search/id/{id}) => searching message by id
           --(/delete/id/{id}) => for deleting message
           --(/messages) =>for getting messages
}
---------------------------------------------------------------
2)Admin Micro Services: Having port number=9002.

Entities Created...
-->Admin
-->ReportUser
-->AdminPostApproval

   .Admin {  url--@RequestMapping("/admin")=>
            --(/register)=> for register
            --(/login)=> for login
            --(/admins) => listing admins
            --(/update/{id}) => updating by id
            --(/delete/{id) => for deleting by id
           } 
    .Report_User{ url--@RequestMapping("/report")=>
           --(/insert) => adding user who has to be reported
           --(/users) => users who has reported
           --(/delete/{id}) => deleting the repored user by id                                      
           }
     .Post_Approval {url--@RequestMapping("/approve") =>
           --(/insert) => to add the post
           --(/posts) => to get the post
            --(/posts/{id})=> to get the post by id
            --(/delete/{id}) => to delete the post by id
            }
.Message{url--@RequestMapping("usermsg") =>
           --(/add) => for adding the new message
           --(/search/id/{id}) => searching message by id
           --(/delete/id/{id}) => for deleting message
           --(/messages) =>for getting messages
}
-------------------------------------------------------------------
3)Message Micro services: Having port number=9002.

Entities Created...
-->Message

.Message{url--@RequestMapping("usermsg") =>
           --(/add) => for adding the new message
           --(/search/id/{id}) => searching message by id
           --(/delete/id/{id}) => for deleting message
           --(/messages) =>for getting messages

All Three Micro services are Connected Using Rest Template Logic.

We Used SWAGGER OPEN-API for Analysis of Backend .

****************************************************Front End **************************************

COMMANDS USED: It start at 3000

->npm install react -g  create-react-app
->create-react-app front
->npm install --saver react-router-dom
->npm install axios
->npm install react-bootstrap

**used material UI so to install it we we have commands i.e,

npm install @mui/material 
            @emotion/react 
            @emotion/styled
            npm i @mui/joy
            npm i react-toastify


Created Service And Components for better demonstration.

******Admin******

1. As an admin, I should be able to log in, log out, and register into the application.
                                       login - `http://localhost:3000/adminlogin`
                                       register - `http://localhost:3000/adminregister`
                                       logout-`by clicking logout button in the header`


                             2. As an admin, I should be allowed to do CRUD on users
                                     `http://localhost:3000/admin/usercrud`

                             3. As an Admin, I should be able to receive the message for posts approval.
                                     `used alert message`

                             4. As an Admin, I should allow the user to post .
                                     `http://localhost:3000/admin/postapprove`

                             5. As an admin, I should be able to see the reported users.
                                    `http://localhost:3000/report/users/:id`


***User*******

1. As an User, I should be able to login, log out and register into the application
                                     login-`http://localhost:3000/login`
                                     register-`http://localhost:3000/register`
                                     logout-`by clicking logout button in the header`

2. As an User, I should be able see the posts that are shared
                                     user all post - `http://localhost:3000/allpost`

3. As an User, I should be able to post by getting approval from the admin only after admin approves then only we can view a new post that are shared
                                     `http://localhost:3000/admin/postapprove`
                                     `the user can view the posts after the admin approves`

 4. As an User, I should be able to message the other User `click the message or mail icon on the header
                                     `http://localhost:3000/message` enter user name `ex: user1`
                                      then open it again enter user name `ex: user2`

5. As an User, I should be able to report another user.

                                     `http://localhost:3000/repotuser`




*******************************************Data Base *************************************

---table names----

                              1.admin
                              2.message
                              3.post_approve
                              4.posts
                              5.reporteduser
                              6.users










