package pe.jmejia.pattern.strategy.impl;

import pe.jmejia.pattern.strategy.util.OnMemoryDataBase;
import pe.jmejia.pattern.strategy.util.User;

public class OnMemoryAuthStrategy implements IAuthStrategy {
  @Override
  public Principal authenticate(String username, String password) {
    User userByName = OnMemoryDataBase.findUserByName(username);
    if (userByName == null) {
      return null;
    } else if (!userByName.getPassword().equals(password)) {
      return null;
    } else {
      return new Principal(userByName.getUserName(), userByName.getRol());
    }
  }
}
