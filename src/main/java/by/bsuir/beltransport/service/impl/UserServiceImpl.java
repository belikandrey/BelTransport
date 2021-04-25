package by.bsuir.beltransport.service.impl;

import by.bsuir.beltransport.entity.User;
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
  @Override
  public User save(User user){
    return userRepository.save(user);
    //return userRepository.save(user);
  }
}
