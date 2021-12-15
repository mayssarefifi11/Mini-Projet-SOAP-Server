package iset.dsi32.metier;

import iset.dsi32.Interface.TournoiInterface;
import iset.dsi32.dao.DAO;
import iset.dsi32.domaine.Tournoi;

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

@WebService
public class TournoiMetier  implements TournoiInterface {

    @WebMethod
    public List<Tournoi> getALLTournois() {

        List<Tournoi> tournois = new ArrayList<Tournoi>();
        Connection con = null;
        Statement stmt = null;
        try {
            con = DAO.getConnexion();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tournoi");
            while (rs.next()) {
                Tournoi tournoi = new Tournoi();
                tournoi.setId( rs.getInt("id"));
                tournoi.setTitre( rs.getString("titre"));
                tournoi.setDateDebut( rs.getDate("dateDebut"));
                tournoi.setDateFin( rs.getDate("dateFin"));
                tournois.add( tournoi );
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

        return tournois;
    }

    public Tournoi addTournoi(Tournoi tournoi) {
        Connection con = null;
        PreparedStatement ps = null;
        Statement stmt =null;
        Tournoi result =null;
        try {
            ps = DAO.getConnexion().prepareStatement(" insert into tournoi (titre, dateDebut, dateFin)  values (?,?,?)");
            ps.setString(1, tournoi.getTitre());
            ps.setDate( 2, new Date( tournoi.getDateDebut().getTime() ));
            ps.setDate( 3, new Date( tournoi.getDateFin().getTime() ));
            DAO.update(ps);
            String maRequete= "SELECT * FROM `tournoi` WHERE id =( select max(id) from tournoi)";
            ResultSet rs= DAO.execute(maRequete)  ;
            while (rs.next()) {
                result = new Tournoi();
                result.setId( rs.getInt("id"));
                result.setTitre( rs.getString("titre"));
                result.setDateDebut( rs.getDate("dateDebut"));
                result.setDateFin( rs.getDate("dateFin"));
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
    public void updateTournoi(Tournoi tournoi) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" update tournoi set titre = ?, dateDebut = ?, dateFin = ?  where id=?");
            ps.setString(1, tournoi.getTitre());
            ps.setDate(2, new Date( tournoi.getDateDebut().getTime() ) );
            ps.setDate(3, new Date( tournoi.getDateFin().getTime() ) );
            ps.setInt( 4, tournoi.getId());
            // executer la requête
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
    public void deleteTournoi(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" delete from tournoi  where id=? ");
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
    public List<Tournoi> findTournoisById(String id) {
        return null;
    }
}



