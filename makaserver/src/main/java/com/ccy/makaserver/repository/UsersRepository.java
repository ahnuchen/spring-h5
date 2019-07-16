package com.ccy.makaserver.repository;


import com.ccy.makaserver.document.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersRepository extends MongoRepository<Users, String> {
  public Boolean existsUsersByLoginId(String loginId);
  public Users findUsersByToken(String token);
  public Users findByLoginIdAndPassword(String loginId,String password);
}
