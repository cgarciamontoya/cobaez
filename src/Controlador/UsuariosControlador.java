/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cgarcia
 */
public class UsuariosControlador extends ControladorBase {

    public UsuariosControlador() {
        super();
    }
    
    public boolean login(String username, String password) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("select count(*) conteo from usuarios where username = '")
                    .append(username).append("' and password = '")
                    .append(password).append("'");
            ResultSet rs = getConnection().prepareStatement(sb.toString()).executeQuery();
            rs.next();
            return rs.getInt("conteo") > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
}
