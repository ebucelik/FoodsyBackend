package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Chat;

import java.util.List;
import java.util.Optional;

public interface ChatService {
    Chat sendMessage(Chat chat);

    Optional<Chat> getChatMessageById(long id);

    List<Chat> getChatListById(long id);
}
