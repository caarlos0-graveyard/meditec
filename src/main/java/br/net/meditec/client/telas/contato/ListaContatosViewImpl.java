package br.net.meditec.client.telas.contato;

import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

import com.github.gwtbootstrap.client.ui.Button;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.gwtplatform.mvp.client.ViewImpl;

import java.util.ArrayList;
import java.util.List;

import br.net.meditec.client.telas.ClickEnterUpHandler;
import br.net.meditec.shared.dto.ContatoDTO;

/**
 * @author: Carlos A Becker
 */
public class ListaContatosViewImpl extends ViewImpl
    implements ListaContatosPresenter.ListaContatosView {

  private Widget w;

  @UiField
  Button bt_pesquisar;

  @UiField
  TextBox txt_pesquisar;

  @UiField
  CellTable<ContatoDTO> tabela;

  @UiField
  SimplePager paginador;

  private ListDataProvider<ContatoDTO> provider = new ListDataProvider<ContatoDTO>();


  public ListaContatosViewImpl() {
    w = ourUiBinder.createAndBindUi(this);
    paginador.setDisplay(tabela);
  }

  @UiFactory
  public CellTable<ContatoDTO> getTabela() {
    CellTable<ContatoDTO> table = new CellTable<ContatoDTO>();
    TextColumn<ContatoDTO> c_id = new TextColumn<ContatoDTO>() {
      @Override
      public String getValue(ContatoDTO object) {
        return object.getId() + "";
      }
    };

    TextColumn<ContatoDTO> c_nome = new TextColumn<ContatoDTO>() {
      @Override
      public String getValue(ContatoDTO object) {
        return object.getSobrenome() + ", " + object.getNome();
      }
    };
    TextColumn<ContatoDTO> c_tel = new TextColumn<ContatoDTO>() {
      @Override
      public String getValue(ContatoDTO object) {
        return object.getNumero();
      }
    };
    TextColumn<ContatoDTO> c_email = new TextColumn<ContatoDTO>() {
      @Override
      public String getValue(ContatoDTO object) {
        return object.getEmail();
      }
    };

    final DateTimeFormat sdf = DateTimeFormat.getFormat("dd/MM");
    TextColumn<ContatoDTO> c_aniversario = new TextColumn<ContatoDTO>() {
      @Override
      public String getValue(ContatoDTO object) {
        return sdf.format(object.getDataNascimento());
      }
    };

    table.addColumn(c_id, "ID");
    table.addColumn(c_nome, "Nome");
    table.addColumn(c_tel, "Telefone");
    table.addColumn(c_email, "EMail");
    table.addColumn(c_aniversario, "Aniversário");

    provider.addDataDisplay(table);
    provider.setList(new ArrayList<ContatoDTO>());

    return table;
  }


  @Override
  public Widget asWidget() {
    return w;
  }

  @Override
  public void setContatos(List<ContatoDTO> contatos) {
    provider.setList(contatos);
  }

  @Override
  public HasValue<String> campo() {
    return txt_pesquisar;
  }

  @Override
  public void addBuscarHandler(ClickEnterUpHandler handler) {
    txt_pesquisar.addKeyUpHandler(handler);
    bt_pesquisar.addClickHandler(handler);
  }

  interface ListaContatosViewImplUiBinder extends
                                          UiBinder<HTMLPanel, ListaContatosViewImpl> {

  }

  private static
  ListaContatosViewImplUiBinder
      ourUiBinder =
      GWT.create(ListaContatosViewImplUiBinder.class);


}