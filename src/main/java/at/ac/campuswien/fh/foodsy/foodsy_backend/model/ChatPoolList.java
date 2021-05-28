package at.ac.campuswien.fh.foodsy.foodsy_backend.model;

import java.util.List;

public class ChatPoolList {

    private List<ChatPool> chatPoolList;

    public ChatPoolList(List<ChatPool> chatPoolList){
        this.chatPoolList = chatPoolList;
    }

    public List<ChatPool> getChatPoolList() {
        return chatPoolList;
    }
}
