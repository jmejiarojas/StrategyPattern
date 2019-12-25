package pe.jmejia.pattern.strategy.impl;

import pe.jmejia.pattern.strategy.util.XMLUserUtil;

public class XmlAuthStrategy implements IAuthStrategy {
  @Override
  public Principal authenticate(String username, String password) {
    String rolByPrincipal = XMLUserUtil.getRolByPrincipal(username, password);

    if (rolByPrincipal.trim().isEmpty()) {
      return null;
    } else {
      return new Principal(username, rolByPrincipal);
    }
  }
}
