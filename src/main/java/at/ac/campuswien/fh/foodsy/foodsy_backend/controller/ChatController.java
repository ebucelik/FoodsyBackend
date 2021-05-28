package at.ac.campuswien.fh.foodsy.foodsy_backend.controller;

import at.ac.campuswien.fh.foodsy.foodsy_backend.exception.ApiInternalProcessingException;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Chat;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.ChatList;
import at.ac.campuswien.fh.foodsy.foodsy_backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Validated
@RestController
public class ChatController {

    @Autowired
    ChatService chatService;

    @PostMapping("/chat")
    @ResponseStatus(HttpStatus.OK)
    public Chat sendMessage(@Valid @RequestBody Chat chat){
        try{
            Chat responseChat = chatService.sendMessage(chat);

            responseChat.getChatPool().setUser(null);
            responseChat.getChatPool().setWithUser(null);

            return responseChat;
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Send Message does not work.");
        }
    }

    @GetMapping(value = "/chat", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public Optional<Chat> getMessageById(@Valid @NotNull @RequestParam long id){
        try{
            return chatService.getChatMessageById(id);
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Get Message does not work.");
        }
    }

    @GetMapping(value = "/chatList", params = {"id"})
    @ResponseStatus(HttpStatus.OK)
    public ChatList getChatListById(@Valid @NotNull @RequestParam long id){
        try{
            ChatList chatList = new ChatList(chatService.getChatListById(id));

            for (Chat chat:chatList.getChatList()) {
                chat.setChatPool(null);
            }

            return chatList;
        }catch (Exception unexpected){
            unexpected.printStackTrace();
            throw new ApiInternalProcessingException("Get Message does not work.");
        }
    }
}
