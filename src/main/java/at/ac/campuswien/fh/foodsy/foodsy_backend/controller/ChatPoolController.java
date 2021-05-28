package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.ChatPool;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.ChatPoolList;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.ChatPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Validated
@RestController
public class ChatPoolController {

    @Autowired
    ChatPoolService chatPoolService;

    @GetMapping(value = "/chatpool", params = {"uuid"})
    @ResponseStatus(HttpStatus.OK)
    public ChatPoolList getChats(@Valid @NotNull @Size(min = 36, max = 36) @RequestParam String uuid){
        try{
            ChatPoolList chatPoolList = new ChatPoolList(chatPoolService.getChatPool(uuid));

            for (ChatPool chatPool:chatPoolList.getChatPoolList()) {
                if(chatPool.getUser().getUserUUID().equals(uuid))
                    chatPool.getUser().setProfileImage(null);
                else
                    chatPool.getWithUser().setProfileImage(null);

                chatPool.getWithUser().setPassword(null);
                chatPool.getUser().setPassword(null);
            }

            return chatPoolList;
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }

    @PostMapping("/chatpool")
    @ResponseStatus(HttpStatus.CREATED)
    public ChatPool createChatPool(@Valid @RequestBody ChatPool chatPool){
        try{
            return chatPoolService.createChatPool(chatPool);
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Internal Error while handling request", unexpected);
        }
    }
}
