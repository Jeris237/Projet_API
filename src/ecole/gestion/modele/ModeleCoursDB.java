package ecole.gestion.modele;

import ecole.metier.Classe;
import ecole.metier.Cours;
import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ModeleCoursDB implements DAOCours{

    private Connection dbConnect;

    public ModeleCoursDB(){
        dbConnect = DBConnection.getConnection();
    }

    @Override
    public Cours create(Cours cours) {
        String req1="insert into cours(code,intitule) values(?,?)";
        String req2="select idCours from cours where code = ?";

        try(PreparedStatement query1= dbConnect.prepareStatement(req1);
            PreparedStatement query2 = dbConnect.prepareStatement(req2);)
        {
            query1.setString(1,cours.getCode());
            query1.setString(2,cours.getIntitule());
            int n = query1.executeUpdate();
            if (n==0){
                return null;
            }
            query2.setString(1,cours.getCode());
            ResultSet rset = query2.executeQuery();

            if (rset.next()){
                int idCours = rset.getInt(1);
                cours.setIdCours(idCours);
                return cours;
            }
            else {
                throw new Exception("Aucun cours trouvé");
            }

        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Cours read(Cours cours) {
        String req="select * from cours where idCours = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req);)
        {
            pstm.setInt(1,cours.getIdCours());
            ResultSet rset = pstm.executeQuery();
            if (rset.next()){
                int idCours = rset.getInt(1);
                String code = rset.getString(2);
                String intitule = rset.getString(3);
                Cours crs = new Cours(idCours,code,intitule);
                return crs;
            }
            else {
                return null;
            }
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public Cours update(Cours cours) {
        String req = "update cours set intitulé = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req);)
        {
            pstm.setString(1,cours.getIntitule());
            int n = pstm.executeUpdate();
            if (n==0){
                return null;
            }
            else {
                return read(cours);
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean delete(Cours cours) {
        String req = "delete from cours where idCours = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            pstm.setInt(1,cours.getIdCours());
            int n = pstm.executeUpdate();
            if (n==0){
                return false;
            }
            else {
                return true;
            }
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public List<Cours> readAll() {
        String req = "select * from cours";
        List<Cours> listCours = new ArrayList<>();
        try(PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            ResultSet rset = pstm.executeQuery();
            while (rset.next()){
                int idCours = rset.getInt(1);
                String code = rset.getString(2);
                String intitule = rset.getString(3);
                Cours cours = new Cours(idCours,code,intitule);
                listCours.add(cours);
            }

            if (listCours.isEmpty()){
                return null;
            }
            else return listCours;
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
