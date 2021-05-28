package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.Chat;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.ChatDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChatService{

    @Autowired
    ChatDao chatDao;

    @Override
    public Chat sendMessage(Chat chat) {
        return chatDao.sendMessage(chat);
    }

    @Override
    public Optional<Chat> getChatMessageById(long id) {
        return chatDao.getChatMessageById(id);
    }

    @Override
    public List<Chat> getChatListById(long id) {
        return chatDao.getChatListById(id);
    }
}
