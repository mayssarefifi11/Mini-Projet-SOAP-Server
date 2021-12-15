package iset.dsi32.metier;


import iset.dsi32.Interface.JourneeInterface;
import iset.dsi32.domaine.Journee;

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

@WebService
public class JourneeMetier  implements JourneeInterface {

    @WebMethod
    public List<Journee> getALLJournees() {

        List<Journee> journees = new ArrayList<Journee>();
        Connection con = null;
        Statement stmt = null;
        try {
            con = DAO.getConnexion();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM journee");
            while (rs.next()) {

                Journee journee = new Journee();
                journee.setId( rs.getInt("id"));
                journee.setDate( rs.getDate("date"));
                journees.add(journee);
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

        return journees;
    }

    @Override
    public Journee addJournee(Journee journee) {
        Connection con = null;
        PreparedStatement ps = null;
        Statement stmt =null;
        Journee result =null;
        //récupérer une connexion à la BD
        try {


            con = DAO.getConnexion();
            // préparer la requête SQL
            ps = con.prepareStatement(" insert into journee (date)  values (?)");
            ps.setDate(1, new Date( journee.getDate().getTime()) );
            // executer la requête insert
            ps.executeUpdate();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM journee WHERE id =( select max(id) from journee)");

            while (rs.next()) {
                result = new Journee();
                result.setId( rs.getInt("id"));
                result.setDate( rs.getDate("date"));
            }

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
        return result;
    }

    @Override
    public void updateJournee(Journee journee) {
        Connection con = null;
        PreparedStatement ps = null;
        //récupérer une connexion à la BD
        try {
            con = DAO.getConnexion();
            // préparer la requête SQL
            ps = con.prepareStatement(" update journee set date= ? where id=?");
            ps.setDate(1, new Date( journee.getDate().getTime() ));
            ps.setInt(2, journee.getId());
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
    public void deleteJournee(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" delete from journee  where id=? ");
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
