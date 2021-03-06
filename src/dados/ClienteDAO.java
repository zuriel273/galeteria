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

/**
 *
 * @author Arlindo
 */
public class ClienteDAO {
    
    Statement stmt;
    
    //NO CADASTRA SE O CPF EXISTE NAO CADASTRO.
    public boolean cadastraCliente (Cliente m){
        if(m != null){
            ResultSet rs_nome;
            String comandoSql_nome = "SELECT * FROM cliente WHERE NOME like '"+m.getNome()+"'";
            String comandoSql = "INSERT INTO cliente (NOME,ENDERECO,TELEFONE) "
                                +"VALUES ('"+m.getNome()+"','"+m.getEndereco()+"','"+m.getTelefone()+"');"; 
//            System.out.println(comandoSql_nome);
//            System.out.println(comandoSql);
            try{
                stmt = (Statement)Myconnection.getStatement();
                rs_nome = stmt.executeQuery(comandoSql_nome);
                if(rs_nome.first() == false){
                    
                    stmt.executeUpdate(comandoSql);
                    stmt.close();
                    
                    return true;
                }
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }        
        }        
        return false;
    }
    
    public Cliente buscaCliente(String nome){
        String sql = "SELECT * FROM Cliente WHERE NOME like '"+nome+"'";
        ResultSet rs;
        try{
            stmt = (Statement) Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            Cliente m = new Cliente(rs.getString("NOME"), rs.getString("ENDERECO"),rs.getString("TELEFONE"));
            int id = Integer.parseInt(rs.getString("id"));
            m.setId(id);
            stmt.close();
            return m;
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return null;
    }
     
    public Cliente buscaClienteId(int id){
        String sql = "SELECT * FROM cliente WHERE ID = "+ id;
        ResultSet rs;
        try{
            stmt = (Statement) Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            
            Cliente m = new Cliente(rs.getString("NOME"), rs.getString("ENDERECO"),rs.getString("TELEFONE"));
            m.setId(id);
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
        String sql = "SELECT * FROM cliente WHERE NOME like '%"+ nome +"%' ORDER BY NOME";
        try{
            stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                                 
                Cliente m = new Cliente(rs.getString("NOME"), rs.getString("ENDERECO"),rs.getString("TELEFONE"));
                int id = Integer.parseInt(rs.getString("id"));
//                System.out.println(rs.getString("NOME"));
//                System.out.println(rs.getString("ENDERECO"));
//                System.out.println(rs.getString("TELEFONE"));
                m.setId(id);
                lista.add(m);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
    public boolean editarCliente(Cliente m) throws Exception {
        if(m!=null) {
            String comandoSQL = "UPDATE cliente SET nome='"+m.getNome()+"', ENDERECO='"+m.getEndereco()+"',TELEFONE='"+m.getTelefone()+"' WHERE id = "+m.getId();
//            System.out.println(comandoSQL);
            try {
                stmt = (Statement) Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                stmt.close();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao alterar cadastro."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                
        }
        return false;
    }
    
    public boolean addNumPedidos(Cliente c) throws Exception {
        if(c != null) {
            String comandoSQL = "UPDATE cliente SET numeroPedidos='"+c.getNumPedidos()+1+"' WHERE id = "+c.getId();
//            System.out.println(comandoSQL);
            try {
                    stmt = (Statement) Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                    stmt.close();
                    return true;
            } catch (SQLException e) {
                //JOptionPane.showMessageDialog(null,"Erro ao alterar cadastro."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                
        }
        return false;
    }
    
    public void excluiCliente(int id){
         String comandoSQL;

        comandoSQL ="DELETE FROM `cliente` WHERE id = "+ id;
        try{
            stmt =  Myconnection.getStatement();
            stmt.executeUpdate(comandoSQL);
            stmt.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no excluir!");
            e.printStackTrace();
        }
    }
    
    public int getNumPedidoClienteById(int id){
        int numPedido = 0;
        String consulta = "SELECT COUNT(*) AS numPedido FROM cliente AS c "
                        + "INNER JOIN pedido AS p ON p.id_cliente = c.id WHERE c.id = "+id;
        
        try{
            stmt =  Myconnection.getStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            while(rs.next()){
                 numPedido = Integer.parseInt(rs.getString("numPedido"));
            }
            stmt.close();

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no excluir!");
            e.printStackTrace();
        }
        return numPedido;
    }
}
