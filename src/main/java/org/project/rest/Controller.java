package org.project.rest;

import org.project.domain.dto.user.LogginData;
import org.project.domain.dto.user.ChangePasswordDto;
import org.project.domain.dto.user.AccountData;
import org.project.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/platform-server")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    LoggingService loggingService;

    @CrossOrigin
    @PostMapping(value = "/user/registerUser")
    public ResponseEntity registerUser(@RequestBody AccountData accountData){


        return loggingService.register(accountData) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity("login already taken",HttpStatus.FORBIDDEN);
    }

    @CrossOrigin
    @PutMapping(value = "/user/loginUser")
    public ResponseEntity loginUser(@RequestBody LogginData logginData){

        return loggingService.logging(logginData) ? new ResponseEntity(HttpStatus.OK): new ResponseEntity("bad login or password",HttpStatus.FORBIDDEN) ;
    }

    @CrossOrigin
    @PutMapping(value = "/user/forgetPasswordIsUser/{nick}")
    public ResponseEntity forgetPasswordIsUser(@PathVariable String nick){

        Map<String,String> message = loggingService.isUser(nick);
        return message != null ? new ResponseEntity(message,HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @CrossOrigin
    @PutMapping(value = "/user/forgetPasswordChange")
    public ResponseEntity forgetPasswordChange(@RequestBody LogginData fpChangeData){
        return loggingService.fpChange(fpChangeData) ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity("Bad answer",HttpStatus.FORBIDDEN);
    }

    @CrossOrigin
    @PutMapping(value = "/user/changePassword")
    public ResponseEntity changePassword(@RequestBody ChangePasswordDto changePasswordDto){
        return loggingService.userChangingPassword(changePasswordDto) ? new ResponseEntity(HttpStatus.OK):new ResponseEntity("Bad password",HttpStatus.FORBIDDEN);
    }


}
