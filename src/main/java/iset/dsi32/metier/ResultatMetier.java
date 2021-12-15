package iset.dsi32.metier;


import iset.dsi32.Interface.ResultatInterface;
import iset.dsi32.domaine.Resultat;
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
import iset.dsi32.domaine.enums.StatusResultat;

@WebService
public class ResultatMetier implements ResultatInterface {

    @WebMethod
    public List<Resultat> getALLResultats() {

        List<Resultat> resultats = new ArrayList<Resultat>();
        Connection con = null;
        Statement stmt = null;
        try {
            con = DAO.getConnexion();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM resultat");
            while (rs.next()) {
                Resultat resultat = new Resultat();
                resultat.setId( rs.getInt("id"));
                resultat.setNbreCartonRouges(rs.getInt("nbreCartonsRouges"));
                resultat.setNbreCartonsJaunes(rs.getInt("nbreCartonsJaunes"));
                resultat.setStatus( StatusResultat.valueOf( rs.getString("status")));
                resultats.add(resultat);
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

        return resultats;
    }

    public Resultat addResultat(Resultat resultat) {
        Connection con = null;
        PreparedStatement ps = null;
        Statement stmt =null;
        Resultat res =null;
        try {
            ps = DAO.getConnexion().prepareStatement(" insert into Resultat (nbreCartonsRouges, nbreCartonsJaunes, status, equipeId)  values (?,?,?,?)");
            ps.setInt(1,res.getNbreCartonRouges() );
            ps.setInt(2,res.getNbreCartonsJaunes() );
            ps.setString(3, resultat.getStatus().name());
            ps.setInt( 4, resultat.getEquipe().getId());


            DAO.update(ps);
            String maRequete= "SELECT * FROM Resultat WHERE id =( select max(id) from Resultat)";
            ResultSet rs= DAO.execute(maRequete)  ;
            while (rs.next()) {
                 res = new Resultat();
                res.setId( rs.getInt("id"));
                res.setNbreCartonRouges(rs.getInt("nbreCartonsRouges"));
                res.setNbreCartonsJaunes(rs.getInt("nbreCartonsJaunes"));
                res.setStatus( StatusResultat.valueOf( rs.getString("status")));
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
        return res;
    }

    @Override
    public void updateResultat(Resultat resultat) {
        Connection con = null;
        PreparedStatement ps = null;
        //récupérer une connexion à la BD
        try {
            con = DAO.getConnexion();
            // préparer la requête SQL
            ps = con.prepareStatement(" update resultat set nbreCartonsRouges = ?, nbreCartonsJaunes = ?, status = ?  where id=?");
            ps.setInt(1,resultat.getNbreCartonRouges() );
            ps.setInt(2,resultat.getNbreCartonsJaunes() );
            ps.setString(3, resultat.getStatus().name());
            ps.setInt( 4, resultat.getId());
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
    public void deleteResultat(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" delete from resultat  where id=? ");
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

    @Override
    public List<Resultat> findResultatsById(int id) {
        return null;
    }


}
