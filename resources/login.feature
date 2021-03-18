Feature: Login

 Login should be quick and friendly.
 
 Scenario Outline: Successful Login
  Users should be logged in successfully by providing correct matricule and password.
  
  Given User enter his matricule <matricule> and password <password>
  When searching users in the data base
  Then The result should be <result>
  
  
    Examples: 
    | matricule   |                        password                            | result
    | "74229"     |                         "$2y$1URq"                         |      "ok"
    | "72189"     |                     "$2y$10$9AVhTB."                       |  "non ok"
       