package ecole.gestion.modele;

import ecole.metier.Cours;
import ecole.metier.Enseignant;
import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModeleEnseignantDB implements DAOEnseignant{

    private Connection dbConnect;

    public ModeleEnseignantDB(){
        dbConnect = DBConnection.getConnection();
    }

    @Override
    public Enseignant create(Enseignant ens) {
        String req1="insert into enseignant (matricule,nom,prenom,tel,chargeSem,salaireMensu,dateEngag) values(?,?,?,?,?,?,?)";
        String req2="select idEnseignant from enseignant where matricule = ? and nom = ? and prenom = ? and tel = ?";

        try(PreparedStatement query1= dbConnect.prepareStatement(req1);
            PreparedStatement query2 = dbConnect.prepareStatement(req2);)
        {
            query1.setString(1,ens.getMatricule());
            query1.setString(2,ens.getNom());
            query1.setString(3,ens.getPrenom());
            query1.setString(4,ens.getTel());
            query1.setInt(5,ens.getChargeSem());
            query1.setDouble(6,ens.getSalaireMensu());
            query1.setDate(7, Date.valueOf(ens.getDateEngag()));
            int n = query1.executeUpdate();
            if (n==0){
                return null;
            }
            query2.setString(1,ens.getMatricule());
            query2.setString(2,ens.getNom());
            query2.setString(3,ens.getPrenom());
            query2.setString(4,ens.getTel());
            ResultSet rset = query2.executeQuery();

            if (rset.next()){
                int idEns = rset.getInt(1);
                ens.setIdEnseignant(idEns);
                return ens;
            }
            else {
                throw new Exception("Aucun enseignant trouvé");
            }

        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Enseignant read(Enseignant ens) {
        String req="select * from enseignant where idEnseignant = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req);)
        {
            pstm.setInt(1,ens.getIdEnseignant());
            ResultSet rset = pstm.executeQuery();
            if (rset.next()){
                int idEns = rset.getInt(1);
                String matricule = rset.getString(2);
                String nom = rset.getString(3);
                String prenom = rset.getString(4);
                String tel = rset.getString(5);
                int chargeSem = rset.getInt(6);
                Double salaire = rset.getDouble(7);
                LocalDate dateEngag = rset.getDate(8).toLocalDate();
                Enseignant enseignant = new Enseignant(idEns,matricule,nom,prenom,tel,chargeSem,salaire,dateEngag);
                return enseignant;
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
    public Enseignant update(Enseignant ens) {
        String req = "update enseignant set chargeSem = ?, salaireMensu = ?, dateEngag = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req);)
        {
            pstm.setInt(1,ens.getChargeSem());
            pstm.setDouble(2,ens.getSalaireMensu());
            pstm.setDate(3,Date.valueOf(ens.getDateEngag()));
            int n = pstm.executeUpdate();
            if (n==0){
                return null;
            }
            else {
                return read(ens);
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean delete(Enseignant ens) {
        String req = "delete from enseignant where idEnseignant = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            pstm.setInt(1,ens.getIdEnseignant());
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
    public List<Enseignant> readAll() {

        String req = "select * from enseignant";
        List<Enseignant> listEnseignant = new ArrayList<>();
        try(PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            ResultSet rset = pstm.executeQuery();
            while (rset.next()){
                int idEns = rset.getInt(1);
                String matricule = rset.getString(2);
                String nom = rset.getString(3);
                String prenom = rset.getString(4);
                String tel = rset.getString(5);
                int chargeSem = rset.getInt(6);
                Double salaire = rset.getDouble(7);
                LocalDate dateEngag = rset.getDate(8).toLocalDate();
                Enseignant enseignant = new Enseignant(idEns,matricule,nom,prenom,tel,chargeSem,salaire,dateEngag);
                listEnseignant.add(enseignant);
            }

            if (listEnseignant.isEmpty()){
                return null;
            }
            else return listEnseignant;
        }
        catch (Exception e)
        {
            return null;
        }
    }

}
