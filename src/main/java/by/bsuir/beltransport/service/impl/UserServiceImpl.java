package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.User;
import by.bsuir.beltransport.exception.EntityAlreadyExistsException;
import by.bsuir.beltransport.persistance.UserRepository;
import by.bsuir.beltransport.persistance.VehicleRepository;
import by.bsuir.beltransport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private VehicleRepository vehicleRepository;
  @Autowired
  public UserServiceImpl(UserRepository userRepository, VehicleRepository vehicleRepository) {
    this.userRepository = userRepository;
    this.vehicleRepository = vehicleRepository;
  }

  @Override
  public Optional<User> findByLoginAndPassword(User user) {
    return Optional.ofNullable(
        userRepository.findUserByLoginAndPassword(user.getLogin(), user.getPassword()));
  }

  public Optional<User> findByLogin(String login){
    return userRepository.findUserByLogin(login);
  }

  @Override
  public User save(User user) throws EntityAlreadyExistsException {
    if(userRepository.findUserByLogin(user.getLogin()).isPresent()){
      throw new EntityAlreadyExistsException("User with login : "+user.getLogin()+" already exists");
    }
    return userRepository.save(user);

  }
}
