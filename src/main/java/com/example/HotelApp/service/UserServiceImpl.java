package com.example.HotelApp.service;

import com.example.HotelApp.exception.NotFoundException;
import com.example.HotelApp.exception.UserNameIsNotAvailableException;
import com.example.HotelApp.model.User;
import com.example.HotelApp.repository.UserRepository;
import com.example.HotelApp.service.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        User saveUser = userRepository.save(user);
        log.info("Сохранен {}", user);
        return saveUser;
    }

    @Override
    public User create(User user) {
        if(checkValidNameAndEmail(user)){
            throw new UserNameIsNotAvailableException("Имя пользователя не доступно! Введите другое имя пользовтеля!");
        }
        User createUser = save(user);
        log.info("Создан {}",createUser);
        return createUser;
    }

    @Override
    public User update(User user) {
        User updateUser = userRepository.save(user);
        log.info("Обновлен пользователь c ID - {} ", user.getId());
        return updateUser;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()
                        -> new NotFoundException(MessageFormat.format("Пользователь с ID - {} не найден", id)));
        log.info("Найден пользователь с ID - {}", id);
        return user;
    }

    @Override
    public User findByName(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new NotFoundException(MessageFormat.format("Пользователь с именем {} не найден", name));
        }
        log.info("Найден пользователь с именем {}", name);
        return user;
    }

    @Override
    public User findByNameAndEmail(String name, String email) {
        User user = userRepository.findByNameAndEmail(name, email);
        if (user == null) {
            throw new NotFoundException(MessageFormat
                    .format("Пользователь с именем {0} и email {1}  не найден", name, email));
        }
        log.info("Найден пользователь с именем {0} и email {1}", name, email);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("Удален порльзователь с ID - {}", id);
    }


    private boolean checkValidNameAndEmail(User user){
        User userFind = findByNameAndEmail(user.getName(), user.getEmail());
        if(userFind == null){
            return true;
        }
        return  false;

    }
}
