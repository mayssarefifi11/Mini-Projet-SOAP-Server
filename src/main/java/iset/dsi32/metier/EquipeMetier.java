package iset.dsi32.metier;
import iset.dsi32.Interface.EquipeInterface;
import iset.dsi32.domaine.Equipe;
import javax.jws.WebMethod;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import java.sql.*;
import iset.dsi32.dao.DAO;

@WebService
public class EquipeMetier implements EquipeInterface {

    @WebMethod
    public List<Equipe> getALLEquipes() {

        List<Equipe> equipes = new ArrayList<Equipe>();
        Connection con = null;
        Statement stmt = null;
        try {
            con = DAO.getConnexion();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM equipe");
            while (rs.next()) {
                int id = rs.getInt("id");
                int classement = rs.getInt("classement");

                Equipe equipe = new Equipe();
                equipe.setId( rs.getInt("id"));
                equipe.setNom( rs.getString("nom"));
                equipe.setClassement( rs.getInt("classement"));
                equipes.add(equipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
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

        return equipes;
    }
    public Equipe addEquipe(Equipe equipe) {
        Connection con = null;
        PreparedStatement ps = null;
        Statement stmt =null;
        Equipe result =null;
        try {
            ps = DAO.getConnexion().prepareStatement(" insert into equipe (nom, classement)  values (?,?)");
            ps.setString(1, equipe.getNom());
            ps.setInt( 2, equipe.getClassement());
            DAO.update(ps);
            String maRequete= "SELECT * FROM equipe WHERE id =( select max(id) from equipe)";
            ResultSet rs= DAO.execute(maRequete)  ;
             while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                int age = rs.getInt("age");
                 result = new Equipe();

                 result.setId( rs.getInt("id"));
                 result.setNom( rs.getString("nom"));
                 result.setClassement( rs.getInt("classement"));
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


    public void updateEquipe(Equipe equipe) {
        Connection con = null;
        PreparedStatement ps = null;
        //récupérer une connexion à la BD
        try {
            con = DAO.getConnexion();

            ps = con.prepareStatement(" update equipe set nom= ?, classement=?  where id=?");

            ps.setString(1, equipe.getNom());
            ps.setInt( 2, equipe.getClassement());
            ps.setInt(3, equipe.getId());

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

    public void deleteEquipe(int id) {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" delete from equipe  where id=? ");
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
    public Equipe findEquipeById(int id) {

        Connection con = null;
        PreparedStatement ps = null;
        Statement stmt =null;
        Equipe result =null;
        try {
            con = DAO.getConnexion();
            ps = con.prepareStatement(" select * from equipe  where id=? ");
            ps.setInt(1, id);
            ResultSet rs= ps.executeQuery();

            while (rs.next()) {
                result = new Equipe();

                result.setId( rs.getInt("id"));
                result.setNom( rs.getString("nom"));
                result.setClassement( rs.getInt("classement"));
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


}
