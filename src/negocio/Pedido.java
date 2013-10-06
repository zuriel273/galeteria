/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Arlindo
 */
public class Pedido {
    String dataPedido, dataEntrega, horaPedido, horaEntrega, descricao;
    boolean entregue;
    int id;
    Cliente c;

    public Pedido(String dataPedido, String dataEntrega, String horaPedido, String horaEntrega, String descricao, boolean entregue, Cliente c) {
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.horaPedido = horaPedido;
        this.horaEntrega = horaEntrega;
        this.descricao = descricao;
        this.entregue = entregue;
        this.c = c;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getHoraPedido() {
        return horaPedido;
    }

    public void setHoraPedido(String horaPedido) {
        this.horaPedido = horaPedido;
    }

    public String getHoraEntrega() {
        return horaEntrega;
    }

    public void setHoraEntrega(String horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isEntregue() {
        return entregue;
    }

    public void setEntregue(boolean entregue) {
        this.entregue = entregue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }
    
    
    
}
