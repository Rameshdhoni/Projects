************************************BACK END************************* 

Maven Project Created with Required dependencies:
i)Spring Web
ii)Spring Data Jpa
iii)Spring Actuator
iv)Spring Dev-Tools
v)Lombok
vi)Spring Rest 
vii)Swagger(open -api)
viii)Spring Validations
ix)H2-Database


AMS Service: Having port number=2233.

Entities/model Created...
-->Admin
-->Plane
-->Pilot
-->Hangar

Controllers

.Admin{ url--@RequestMapping("/admin") =>
           --(/register) => to register the admin
           --(/login)   => to login the admin
          }

.Plane{ url--@RequestMapping("/plane") =>
           --(/add) => for adding the new plane
           --(/update) => updating existing plane 
           --(/delete/{planeId}) => deleting plane using id
           --(/planes) => getting all planes
          }
.Pilot{ url--@RequestMapping("/pilot") =>
           --(/add) => for adding the new pilot
           --(/update) => updating existing pilot 
           --(/delete/{pilotId}) => deleting pilot using id
           --(/pilots) => getting all pilots
          }
.Hangar{ url--@RequestMapping("/hangar") =>
           --(/add) => for adding the new hangar
           --(/update) => updating existing hangar 
           --(/delete/{hangarId}) => deleting hangar using id
           --(/hangars) => getting all hangars
          }
}
---------------------------------------------------------------
LOGGER FILE NAME :ams.log

*******************************************Data Base *************************************
DATA BASE USED:   H2
---table names----

                              1.admin
                              2.plane
                              3.pilot
                              4.hangar
                            










