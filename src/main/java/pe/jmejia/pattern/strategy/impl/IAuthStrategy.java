package pe.jmejia.pattern.strategy.impl;

public interface IAuthStrategy {

  Principal authenticate(String username, String password);

}
