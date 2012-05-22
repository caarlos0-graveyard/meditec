package br.net.meditec.client.telas;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;

/**
 * @author Carlos A Becker
 */
public abstract class ClickEnterUpHandler implements ClickHandler, KeyUpHandler {

  public abstract void doAction();

  @Override
  public void onClick(ClickEvent event) {
    doAction();
  }

  @Override
  public void onKeyUp(KeyUpEvent event) {
    if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
      doAction();
    }
  }
}
