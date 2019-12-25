package pe.jmejia.pattern.strategy.util;

import java.util.HashMap;

public class OnMemoryDataBase {

  private static final HashMap<String, User> USER_MAP = new HashMap<>();

  static {
    USER_MAP.put("jmejiarojas",new User("jmejiarojas", "1234", "admin"));
    USER_MAP.put("julio",new User("julio", "1234", "cajero"));
    USER_MAP.put("lcastro",new User("lcastro", "2345", "Supervisor"));
  }

  public static User findUserByName(String name){
    return USER_MAP.get(name);
  }

}
