package org.project.rest;

import org.project.domain.classes.user.ChatMessage;
import org.project.domain.classes.user.LogginData;
import org.project.domain.classes.user.ChangePasswordDto;
import org.project.domain.classes.user.AccountData;
import org.project.service.LoggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/platform-server/user")
public class Controller {
    private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    LoggingService loggingService;

    @CrossOrigin
    @PostMapping(value = "/registerUser")
    public ResponseEntity registerUser(@RequestBody AccountData accountData){


        return loggingService.register(accountData) ? new ResponseEntity(true,HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @CrossOrigin
    @PutMapping(value = "/loginUser")
    public ResponseEntity loginUser(@RequestBody LogginData logginData){

        return loggingService.logging(logginData) ? new ResponseEntity(true,HttpStatus.OK): new ResponseEntity("bad login or password",HttpStatus.FORBIDDEN) ;
    }

    @CrossOrigin
    @PutMapping(value = "/forgetPasswordIsUser/{nick}")
    public ResponseEntity forgetPasswordIsUser(@PathVariable String nick){

        Map<String,String> message = loggingService.isUser(nick);
        return message != null ? new ResponseEntity(message,HttpStatus.OK) : new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @CrossOrigin
    @PutMapping(value = "/forgetPasswordChange")
    public ResponseEntity forgetPasswordChange(@RequestBody LogginData fpChangeData){
        loggingService.fpChange(fpChangeData);
        return  new ResponseEntity(true,HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/changePassword")
    public ResponseEntity changePassword(@RequestBody ChangePasswordDto changePasswordDto){
        System.out.println("########################################################################################");
        return loggingService.userChangingPassword(changePasswordDto) ? new ResponseEntity(HttpStatus.OK):new ResponseEntity("Bad password",HttpStatus.FORBIDDEN);
    }

    @CrossOrigin
    @GetMapping(value = "/getLogins")
    public ResponseEntity getLogins(){
        List<String> message = loggingService.getLogins();
        return new ResponseEntity(message,HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/deleteUser/{nick}")
    public ResponseEntity deletePlayer(@PathVariable String nick){
        loggingService.deletePlayer(nick);
        return new ResponseEntity(true,HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/getScoreTable")
    public ResponseEntity getScoreTable(){
        return new ResponseEntity(loggingService.sendScores(),HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/resetScore/{nick}")
    public ResponseEntity getScoreTable(@PathVariable String nick){
        loggingService.resetPlayerStats(nick);
        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/updateStats")
    public ResponseEntity updateStats(@RequestBody Map<String,String> data){
        loggingService.updatePlayerStats(data.get("nick"),data.get("operation"));
        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/sendMessage")
    public ResponseEntity sendMessage(@RequestBody ChatMessage chatMessage){
        System.out.println("w controllerze"+chatMessage.toString());
        loggingService.saveNewMessage(chatMessage);
        return new ResponseEntity(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/getChatMessages")
    public ResponseEntity getChatMessages(){
        return new ResponseEntity(loggingService.sendMsgToClient(),HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/clearChat")
    public ResponseEntity clearChat(){
        loggingService.clearChatHistory();
        return new ResponseEntity(HttpStatus.OK);
    }

}
