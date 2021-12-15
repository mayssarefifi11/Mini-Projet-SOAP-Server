package iset.dsi32.metier;

import iset.dsi32.Interface.ActionInterface;
import iset.dsi32.domaine.Action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.jws.WebMethod;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import iset.dsi32.dao.DAO;
import iset.dsi32.domaine.enums.TypeAction;

@WebService
public class ActionMetier  implements ActionInterface {

    @WebMethod
    public List<Action> getALLActions() {

        List<Action> actions = new ArrayList<Action>();
        Connection con = null;
        Statement stmt = null;
        try {
            con = DAO.getConnexion();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM action");
            while (rs.next()) {

                Action a = new Action();

                a.setId( rs.getInt("id") );
                a.setTypeAction( TypeAction.valueOf( rs.getString("type")));
                actions.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    // Le stmt.close ferme automatiquement le resultSet
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return actions;
    }

    @Override
    public Action addAction(Action a) {
        Connection con = null;
        PreparedStatement ps = null;
        Statement stmt =null;
        Action result =null;
        try {
            con = DAO.getConnexion();
            // préparer la requête SQL
            ps = con.prepareStatement(" insert into action (type)  values (?)");
            ps.setString(1, a.getTypeAction().name() );
            ps.executeUpdate();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM action WHERE id =( select max(id) from action)");

            while (rs.next()) {
                result = new Action();
                result.setId( rs.getInt("id") );
                result.setTypeAction( TypeAction.valueOf( rs.getString("type")) );
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public void updateAction(Action a) {
        Connection con = null;
        PreparedStatement ps = null;
        //récupérer une connexion à la BD
        try {
            con = DAO.getConnexion();
            // préparer la requête SQL
            ps = con.prepareStatement(" update action set nom= ? where id=?");
            // passer les paramètres (nom et age) ( la colonne id est auto incrémentable)
            ps.setString(1, a.getTypeAction().name());
            ps.setInt(2, a.getId());
            // executer la requête
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (ps != null) {
                try {
                    // Le ps.close ferme automatiquement le resultSet
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void deleteAction(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" delete from action  where id=? ");
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
