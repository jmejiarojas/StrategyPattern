package pe.jmejia.pattern.strategy.impl;

public class AuthProvider {

  private IAuthStrategy authStrategy;

  public AuthProvider(IAuthStrategy authStrategy) {
    this.authStrategy = authStrategy;
  }

  // No necesitamos un get porque el usuario no tiene porque obtener un strategy, mas si setearlo
  public void setAuthStrategy(IAuthStrategy authStrategy) {
    this.authStrategy = authStrategy;
  }

  // Este es el metodo que va a conocer el cliente
  public Principal authenticate(String username, String password) {
    return this.authStrategy.authenticate(username, password);
  }
}
