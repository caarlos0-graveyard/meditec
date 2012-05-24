package br.net.meditec.client.inject;

/**
 * NameTokens da app.
 *
 * @author Carlos A Becker
 */
public class Tokens {

  public static final String home = "home";
  public static final String cadastroContato = "cadastroContato";
  public static final String consultaContato = "consultaContato";
  public static final String cadastroEvento = "cadastroEvento";

  public static String getCadastroEvento() {
    return cadastroEvento;
  }

  public static String getHome() {
    return home;
  }

  public static String getCadastroContato() {
    return cadastroContato;
  }

  public static String getConsultaContato() {
    return consultaContato;
  }
}

