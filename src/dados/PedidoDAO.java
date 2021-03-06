/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import negocio.Cliente;
import negocio.Pedido;


/**
 *
 * @author Arlindo
 */
public class PedidoDAO {
    public boolean cadastraPedido (Pedido m) throws Exception{
        if(m != null){
                        
            String comandoSql = "INSERT INTO pedido (PEDIDO1,PEDIDO2,PEDIDO3,PEDIDO4,PEDIDO5,PEDIDO6,PEDIDO7,PEDIDO8,VALOR,ID_CLIENTE,ENDERECO,OBSERVACAO) " +
            "VALUES ('"+m.getPedido1()+"','"+m.getPedido2()+"','"+m.getPedido3()+"','"+m.getPedido4()+"','"+m.getPedido5()+"','"+m.getPedido6()+"','"+m.getPedido7()+"','"+m.getPedido8()+"','"+m.getValor()+"',"+m.getCliente().getId()+",'"+m.getEndereco()+"','"+m.getObservacao()+"');"; 
          
//            System.out.println(comandoSql);
            try{
                java.sql.Statement stmt = (Statement)Myconnection.getStatement();
                stmt.executeUpdate(comandoSql);
                stmt.close();
                return true;                
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }        
        }        
        return false;
    }
    
    public Pedido buscaPedido(String nome){ // fazer um inner join com o nome do cliente
        String sql = "SELECT * FROM pedido INNER JOIN cliente WHERE  cliente.ID = pedido.ID_CLIENTE AND cliente.NOME like '%"+nome+"%'";
        
        ResultSet rs, rs2;
        try{
            java.sql.Statement  stmt = (Statement) Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            String sql2 = "SELECT * FROM cliente WHERE id ="+ rs.getInt("id");
            
            java.sql.Statement  stmt2 = (Statement) Myconnection.getStatement();
            rs2 = stmt2.executeQuery(sql2);
            rs2.next();
            
            Cliente c = new Cliente(rs2.getString("NOME"), rs2.getString("ENDERECO"),rs2.getString("TELEFONE"));
            Pedido p = new Pedido(c);
            
            stmt.close();
            stmt2.close();
            
            return p;
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
    
    public List listaPedido(String nome){
        ResultSet rs, rs2;
        List lista = new ArrayList();
        String sql = "SELECT * FROM pedido INNER JOIN cliente WHERE  cliente.ID = pedido.ID_CLIENTE AND cliente.NOME like '%"+nome+"%' ORDER BY pedido.id DESC";
        try{
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                                 
                String sql2 = "SELECT * FROM cliente WHERE id ="+ rs.getInt("id_cliente");

                java.sql.Statement  stmt2 = (Statement) Myconnection.getStatement();
                rs2 = stmt2.executeQuery(sql2);
                rs2.next();

                Cliente c = new Cliente(rs2.getString("NOME"), rs2.getString("ENDERECO"),rs2.getString("TELEFONE"));
                Pedido p = new Pedido(rs.getString("pedido1"),rs.getString("pedido2"),rs.getString("pedido3"),rs.getString("pedido4"),rs.getString("pedido5"),rs.getString("pedido6"),rs.getString("pedido7"),rs.getString("pedido8"),rs.getString("endereco"),rs.getInt("id"),rs.getFloat("valor"),c);
                p.setObservacao(rs.getString("observacao"));
                lista.add(p);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
    public List listaPedidoIdCliente(Cliente cliente){
        ResultSet rs;
        List lista = new ArrayList();
        String sql = "SELECT * FROM pedido WHERE id_cliente ="+ cliente.getId() + " ORDER BY id DESC";
//        System.out.println(sql);
        try{
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                            
                Pedido p = new Pedido(cliente);
                p.setEndereco(rs.getString("endereco"));
                p.setId(rs.getInt("id"));
                p.setValor(rs.getFloat("valor"));
                p.setObservacao(rs.getString("observacao"));
                lista.add(p);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
    public Pedido getPedidoById(int id){
        Pedido pedido = new Pedido(null);
        ResultSet rs;
        try{
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery("SELECT * FROM pedido WHERE id = "+id);
            while(rs.next()){
                ClienteDAO cDAO = new ClienteDAO();
                Cliente c = cDAO.buscaClienteId(rs.getInt("id_cliente"));
                pedido = new Pedido(rs.getString("pedido1"),rs.getString("pedido2"),rs.getString("pedido3"),rs.getString("pedido4"),rs.getString("pedido5"),rs.getString("pedido6"),rs.getString("pedido7"),rs.getString("pedido8"),rs.getString("endereco"),rs.getInt("id"),rs.getFloat("valor"),c);
                pedido.setObservacao(rs.getString("observacao"));
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return pedido;
    }
    
    public boolean atualizaPedido(Pedido m) throws Exception{
        if(m != null){
                        
            String comandoSql = "UPDATE pedido SET PEDIDO1='"+m.getPedido1()+"',PEDIDO2='"+m.getPedido2()+"',PEDIDO3='"+m.getPedido3()+"',PEDIDO4='"+m.getPedido4()+"',PEDIDO5='"+m.getPedido5()+"'"
                    + ",PEDIDO6='"+m.getPedido6()+"',PEDIDO7='"+m.getPedido7()+"',PEDIDO8='"+m.getPedido8()+"',VALOR='"+m.getValor()+"',ID_CLIENTE="+m.getCliente().getId()+",ENDERECO='"+m.getEndereco()+"',OBSERVACAO='"+m.getObservacao()+"' WHERE id="+m.getId(); 
            
            try{
                java.sql.Statement stmt = (Statement)Myconnection.getStatement();
                stmt.executeUpdate(comandoSql);
                stmt.close();
                return true;                
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }        
        }        
        return false;
    }
    
    
    public void excluirPedido(int id){
         String comandoSQL;

        comandoSQL ="DELETE FROM `pedido` WHERE id = "+ id;
        try{
            java.sql.Statement stmt = Myconnection.getStatement();
            stmt =  Myconnection.getStatement();
            stmt.executeUpdate(comandoSQL);
            stmt.close();
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao excluir pedido!");
            e.printStackTrace();
        }
    }
    
}
