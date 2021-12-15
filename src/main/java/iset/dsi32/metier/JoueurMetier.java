package iset.dsi32.metier;


import iset.dsi32.Interface.JoueurInterface;
import iset.dsi32.domaine.Joueur;

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
public class JoueurMetier  implements JoueurInterface {

    @WebMethod
    public List<Joueur> getALLJoueurs() {

        List<Joueur> joueurs = new ArrayList<Joueur>();
        Connection con = null;
        Statement stmt = null;
        try {
            con = DAO.getConnexion();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM joueur");
            while (rs.next()) {

                Joueur joueur = new Joueur();
                joueur.setId( rs.getInt("id"));
                joueur.setAge(rs.getInt("age"));
                joueur.setNbreButs( rs.getInt("nbreButs"));
                joueur.setNbreCartonsJaunes( rs.getInt("nbreCartonsJaunes"));
                joueur.setNbreCartonsRouges( rs.getInt("nbreCartonsRouges"));
                joueur.setNom( rs.getString("nom"));
                joueur.setPrenom( rs.getString("prenom"));

                joueurs.add(joueur);
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

        return joueurs;
    }

    @Override
    public Joueur addJoueur(Joueur joueur) {
        Connection con = null;
        PreparedStatement ps = null;
        Statement stmt =null;
        Joueur result =null;
        //récupérer une connexion à la BD
        try {
            con = DAO.getConnexion();
            // préparer la requête SQL
            ps = con.prepareStatement(" insert into joueur (age, nbreButs, nbreCartonsJaunes, nbreCartonsRouges, nom, prenom )  values (?, ?, ?, ?, ?, ? )");
            ps.setInt(1, joueur.getAge());
            ps.setInt(2, joueur.getNbreButs());
            ps.setInt(3, joueur.getNbreCartonsJaunes());
            ps.setInt(4, joueur.getNbreCartonsRouges());
            ps.setString(5, joueur.getNom());
            ps.setString(6, joueur.getPrenom());
            // executer la requête insert
            ps.executeUpdate();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM joueur WHERE id =( select max(id) from joueur)");

            while (rs.next()) {
                result = new Joueur();
                result.setId( rs.getInt("id"));
                result.setAge(rs.getInt("age"));
                result.setNbreButs( rs.getInt("nbreButs"));
                result.setNbreCartonsJaunes( rs.getInt("nbreCartonsJaunes"));
                result.setNbreCartonsRouges( rs.getInt("nbreCartonsRouges"));
                result.setNom( rs.getString("nom"));
                result.setPrenom( rs.getString("prenom"));
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
    public void updateJoueur(Joueur joueur) {
        Connection con = null;
        PreparedStatement ps = null;
        //récupérer une connexion à la BD
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" update joueur set nom = ?, prenom = ?, age = ?, nbreButs = ?, nbreCartonsJaunes = ?, nbreCartonsRouges = ? where id=?");
            ps.setString(1, joueur.getNom());
            ps.setString(2, joueur.getPrenom());
            ps.setInt(3, joueur.getAge());
            ps.setInt(4, joueur.getNbreButs());
            ps.setInt(5, joueur.getNbreCartonsJaunes());
            ps.setInt(6, joueur.getNbreCartonsRouges());
            ps.setInt(7, joueur.getId());
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
    public void deleteJoueur(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" delete from joueur  where id=? ");
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
    public Joueur findJoueurById(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        Joueur joueur = null;
        //récupérer une connexion à la BD
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" select * from joueur where id=?");
            ps.setInt(1, id);
            // executer la requête
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                joueur = new Joueur();
                joueur.setId( rs.getInt("id"));
                joueur.setAge(rs.getInt("age"));
                joueur.setNbreButs( rs.getInt("nbreButs"));
                joueur.setNbreCartonsJaunes( rs.getInt("nbreCartonsJaunes"));
                joueur.setNbreCartonsRouges( rs.getInt("nbreCartonsRouges"));
                joueur.setNom( rs.getString("nom"));
                joueur.setPrenom( rs.getString("prenom"));
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

        return joueur;
    }
}
