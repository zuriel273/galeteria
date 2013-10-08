/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.Cliente;

/**
 *
 * @author Arlindo
 */
public class ClienteDAO {
    
    Statement stmt;
    
    //NO CADASTRA SE O CPF EXISTE NAO CADASTRO.
    public boolean cadastraMembro (Cliente m){
        if(m != null){
            ResultSet rs_nome;
            String comandoSql_nome = "SELECT * FROM CLIENTE WHERE NOME like '"+m.getNome()+"'";
            String comandoSql = "INSERT INTO CLIENTE (NOME,ENDERECO,TELEFONE,COMPLEMENTO) "
                                +"VALUES ('"+m.getNome()+"','"+m.getEndereco()+"','"+m.getTelefone()+"','"+m.getComplemento()+"');"; 
            System.out.println(comandoSql_nome);
            System.out.println(comandoSql);
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
        String sql = "SELECT * FROM Cliente WHERE ID = "+ id;
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
        String sql = "SELECT * FROM CLIENTE WHERE NOME like '%"+ nome +"%' ORDER BY NOME";
        try{
            stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                                 
                Cliente m = new Cliente(rs.getString("NOME"), rs.getString("ENDERECO"),rs.getString("TELEFONE"));
                int id = Integer.parseInt(rs.getString("id"));
                System.out.println(rs.getString("NOME"));
                System.out.println(rs.getString("ENDERECO"));
                System.out.println(rs.getString("TELEFONE"));
                m.setId(id);
                lista.add(m);
            }
            stmt.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }            
        return lista;
    }
    
    
}
