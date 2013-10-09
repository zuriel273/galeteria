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
                        
            String comandoSql = "INSERT INTO pedido (PEDIDO1,PEDIDO2,PEDIDO3,PEDIDO4,PEDIDO5,PEDIDO6,PEDIDO7,PEDIDO8,ENTREGUE,ID_CLIENTE) " +
            "VALUES ('"+m.getPedido1()+"','"+m.getPedido2()+"','"+m.getPedido3()+"','"+m.getPedido4()+"','"+m.getPedido5()+"','"+m.getPedido6()+"','"+m.getPedido7()+"','"+m.getPedido8()+"',false, '"+m.getCliente().getId()+"');"; 
          
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
            
            Cliente c = new Cliente(rs2.getString("NOME"), rs2.getString("ENDERECO"),rs2.getString("TELEFONE"),rs2.getString("COMPLEMENTO"));
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

                Cliente c = new Cliente(rs2.getString("NOME"), rs2.getString("ENDERECO"),rs2.getString("TELEFONE"),rs2.getString("COMPLEMENTO"));
                Pedido p = new Pedido(c);
                lista.add(p);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
}
