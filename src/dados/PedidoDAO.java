/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.Pedido;


/**
 *
 * @author Arlindo
 */
public class PedidoDAO {
    public boolean cadastraPedido (Pedido m){
        if(m != null){
                        
            String comandoSql = "INSERT INTO PEDIDO (DESCRICAO,ENTREGUE,ID_CLIENTE,VALOR) " +
            "VALUES ('"+m.getDescricao()+"','"+m.isEntregue()+"', '"+m.getCliente().getId()+"', '"+m.getValor()+"');"; 
          
            System.out.println(comandoSql);
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
        String sql = "SELECT * FROM Cliente WHERE NOME like '"+nome+"'";
        ResultSet rs;
        try{
            stmt = (Statement) Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            Cliente m = new Cliente(rs.getString("NOME"), rs.getString("ENDERECO"),rs.getString("TELEFONE"));
            stmt.close();
            return m;
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
    
    public List listaCliente(String nome){
        ResultSet rs;
        List lista = new ArrayList();
        String sql = "SELECT * FROM CLIENTE WHERE NOME like '%"+ nome +"%' ORDER BY NOME";
        try{
            stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                                 
                Cliente m = new Cliente(rs.getString("NOME"), rs.getString("ENDERECO"),rs.getString("TELEFONE"));
                lista.add(m);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
}
