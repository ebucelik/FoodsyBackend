package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import java.util.List;

public class ChatList {
    private List<Chat> chatList;

    public ChatList(List<Chat> chatList){
        this.chatList = chatList;
    }

    public List<Chat> getChatList() {
        return chatList;
    }
}
