package pe.jmejia.pattern.strategy.run;

import pe.jmejia.pattern.strategy.impl.*;

public class Main {
  public static void main(String[] args) {
    AuthProvider authProvider = new AuthProvider(new XmlAuthStrategy());
    String username = "jmejiarojas";
    String password = "1234";

    Principal principal = authProvider.authenticate(username, password);
    System.out.println(principal);

    // Cambiamos en tiempo de ejecucion a SqlAuthStrategy
    authProvider.setAuthStrategy(new SqlAuthStrategy());
    Principal principalDb = authProvider.authenticate(username, password);
    System.out.println(principalDb);
  }
}
