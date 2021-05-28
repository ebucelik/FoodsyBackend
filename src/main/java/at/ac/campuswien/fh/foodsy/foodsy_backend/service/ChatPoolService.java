package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.ChatPool;

import java.util.List;

public interface ChatPoolService {
    public List<ChatPool> getChatPool(String uuid);

    public ChatPool createChatPool(ChatPool chatPool);
}
