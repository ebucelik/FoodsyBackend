package at.ac.campuswien.fh.foodsy.foodsy_backend.service;

import at.ac.campuswien.fh.foodsy.foodsy_backend.model.ChatPool;
import at.ac.campuswien.fh.foodsy.foodsy_backend.repository.ChatPoolDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatPoolServiceImpl implements ChatPoolService{

    @Autowired
    ChatPoolDao chatPoolDao;

    @Override
    public List<ChatPool> getChatPool(String uuid) {
        return chatPoolDao.getChatPool(uuid);
    }

    @Override
    public ChatPool createChatPool(ChatPool chatPool) {
        return chatPoolDao.createChatPool(chatPool);
    }
}
