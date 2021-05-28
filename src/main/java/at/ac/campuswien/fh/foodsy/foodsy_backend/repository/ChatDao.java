package at.ac.campuswien.fh.foodsy.foodsy_backend.repository;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Chat;
import at.ac.campuswien.fh.foodsy.foodsy_backend.model.ChatList;

import java.util.List;
import java.util.Optional;

public interface ChatDao {
    Chat sendMessage(Chat chat);

    Optional<Chat> getChatMessageById(long id);

    List<Chat> getChatListById(long id);
}
