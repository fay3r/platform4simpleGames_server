# platform4simpleGames_server

About:
App is allowing to register ,login into platform and chat, play games (ticktacktoe(ttt), ships, rock paper scissors (rps) ) and see scores of all users. <br>
one of first servers made by me in a group, learning mechanics, Spring ,maven
server is connecting to postgreSQL database

| Method  |       URL                    |  Request body                          | Response body | Comment|
| ------------- | ------------- | ------------- | ------------- | ------------- | 
| POST | /platform-server/user/registerUser | {"nick":"nick", "password":"password", "question":"question", "answer":"answer" } |HTTP 200 -  registered, HTTP 403 - can't register | used to register account in a app's database |
| PUT | /platform-server/user/loginUser | { "nick":"nick", "password":"password" } | HTTP 200 - success HTTP 403 - bad login or password| used to login into app |
| PUT | /platform-server/user/forgetPasswordIsUser/{nick} | <center><b> ---  | HTTP 200 - { "question":"question", "answer":"answer" } , HTTP 403 | checks if user is in database, if so returns question and answer |
| PUT | /platform-server/user/forgetPasswordChange | { "nick":"nick", "password":"password" } | HTTP 200 | change account's password |
| PUT | /platform-server/user/changePassword | { "nick":"nick", "password":"password", "newPassword":"newPassword" } | HTTP 200 | change account's password using old password |
| GET | /platform-server/user/getLogins | <center><b> --- | HTTP 200 | returns logins of all users|
| DELETE | /platform-server/user/deleteUser/{nick} | <center><b> --- | HTTP 200 - true| delete user using login |
| GET | /platform-server/user/getScoreTable | <center><b> --- |  | returns users scores |
| PUT | /platform-server/user/resetScore/{nick} | <center><b> --- | | allows to reset scores assigned to an account |
| PUT | /platform-server/user/updateStats | { "nick":"nick", "operation":"operation" } | | updates account scores |
| PUT | /platform-server/user/sendMessage | { "nick":"nick", "text":"text", "data":"data" } | | saves message in chat |
| GET | /platform-server/user/getChatMessages | <center><b> --- | | returns chat messages|
| DELETE | /platform-server/user/clearChat | | | clears chat messages |
