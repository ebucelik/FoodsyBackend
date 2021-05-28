package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.ChatPool;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.User;

import java.util.List;

public interface ChatPoolDao {
    public List<ChatPool> getChatPool(String uuid);

    public ChatPool createChatPool(ChatPool chatPool);
}
