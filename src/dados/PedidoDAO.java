/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.Cliente;
import negocio.Pedido;


/**
 *
 * @author Arlindo
 */
public class PedidoDAO {
    public boolean cadastraPedido (Pedido m) throws Exception{
        if(m != null){
                        
            String comandoSql = "INSERT INTO pedido (PEDIDO1,PEDIDO2,PEDIDO3,PEDIDO4,PEDIDO5,PEDIDO6,PEDIDO7,PEDIDO8,VALOR,ID_CLIENTE,ENDERECO) " +
            "VALUES ('"+m.getPedido1()+"','"+m.getPedido2()+"','"+m.getPedido3()+"','"+m.getPedido4()+"','"+m.getPedido5()+"','"+m.getPedido6()+"','"+m.getPedido7()+"','"+m.getPedido8()+"','"+m.getValor()+"',"+m.getCliente().getId()+",'"+m.getEndereco()+"');"; 
          
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
        String sql = "SELECT * FROM pedido INNER JOIN cliente WHERE  cliente.ID = pedido.ID_CLIENTE AND cliente.NOME like '%"+nome+"%'";
        try{
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                                 
                String sql2 = "SELECT * FROM cliente WHERE id ="+ rs.getInt("id");

                java.sql.Statement  stmt2 = (Statement) Myconnection.getStatement();
                rs2 = stmt2.executeQuery(sql2);
                rs2.next();

                Cliente c = new Cliente(rs2.getString("NOME"), rs2.getString("ENDERECO"),rs2.getString("TELEFONE"));
                Pedido p = new Pedido(rs.getString("pedido1"),rs.getString("pedido2"),rs.getString("pedido3"),rs.getString("pedido4"),rs.getString("pedido5"),rs.getString("pedido6"),rs.getString("pedido7"),rs.getString("pedido8"),rs.getString("endereco"),rs.getInt("id"),rs.getFloat("valor"),c);
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
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return pedido;
    }
}
