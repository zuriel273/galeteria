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
    String  pedido1, pedido2, pedido3, pedido4, pedido5, pedido6, pedido7, pedido8;
    String  endereco;
    int id;
    float valor;
    Cliente cliente;

    public Pedido() {
    }

    public Pedido(String pedido1, String pedido2, String pedido3, String pedido4, String pedido5, String pedido6, String pedido7, String pedido8, String endereco, int id, float valor, Cliente cliente) {
        this.pedido1 = pedido1;
        this.pedido2 = pedido2;
        this.pedido3 = pedido3;
        this.pedido4 = pedido4;
        this.pedido5 = pedido5;
        this.pedido6 = pedido6;
        this.pedido7 = pedido7;
        this.pedido8 = pedido8;
        this.endereco = endereco;
        this.id = id;
        this.valor = valor;
        this.cliente = cliente;
    }
 
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
        
    public String getPedido1() {
        return pedido1;
    }

    public void setPedido1(String pedido1) {
        this.pedido1 = pedido1;
    }

    public String getPedido2() {
        return pedido2;
    }

    public void setPedido2(String pedido2) {
        this.pedido2 = pedido2;
    }

    public String getPedido3() {
        return pedido3;
    }

    public void setPedido3(String pedido3) {
        this.pedido3 = pedido3;
    }

    public String getPedido4() {
        return pedido4;
    }

    public void setPedido4(String pedido4) {
        this.pedido4 = pedido4;
    }

    public String getPedido5() {
        return pedido5;
    }

    public void setPedido5(String pedido5) {
        this.pedido5 = pedido5;
    }

    public String getPedido6() {
        return pedido6;
    }

    public void setPedido6(String pedido6) {
        this.pedido6 = pedido6;
    }

    public String getPedido7() {
        return pedido7;
    }

    public void setPedido7(String pedido7) {
        this.pedido7 = pedido7;
    }

    public String getPedido8() {
        return pedido8;
    }

    public void setPedido8(String pedido8) {
        this.pedido8 = pedido8;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

     
}
