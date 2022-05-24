package ecole.gestion.modele;

import ecole.metier.Enseignant;
import ecole.metier.Salle;
import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ModeleSalleDB implements DAOSalle{

    private Connection dbConnect;

    public ModeleSalleDB(){
        dbConnect = DBConnection.getConnection();
    }

    @Override
    public Salle create(Salle sal) {
        String req1="insert into salle (sigle,capacite) values(?,?)";
        String req2="select idSalle from salle where sigle = ?";

        try(PreparedStatement query1= dbConnect.prepareStatement(req1);
            PreparedStatement query2 = dbConnect.prepareStatement(req2);)
        {
            query1.setString(1,sal.getSigle());
            query1.setInt(2,sal.getCapacite());
            int n = query1.executeUpdate();
            if (n==0){
                return null;
            }
            query2.setString(1,sal.getSigle());
            ResultSet rset = query2.executeQuery();
            if (rset.next()){
                int idSalle = rset.getInt(1);
                sal.setIdSalle(idSalle);
                return sal;
            }
            else {
                throw new Exception("Aucune salle trouvé");
            }

        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Salle read(Salle sal) {
        String req="select * from salle where idSalle = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req);)
        {
            pstm.setInt(1,sal.getIdSalle());
            ResultSet rset = pstm.executeQuery();
            if (rset.next()){
                int idSalle = rset.getInt(1);
                String sigle = rset.getString(2);
                int capacite = rset.getInt(3);
                Salle salle = new Salle(idSalle,sigle,capacite);
                return salle;
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
    public Salle update(Salle sal) {
        String req = "update salle set capacite = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req);)
        {
            pstm.setInt(1,sal.getCapacite());
            int n = pstm.executeUpdate();
            if (n==0){
                return null;
            }
            else {
                return read(sal);
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean delete(Salle sal) {
        String req = "delete from salle where idSalle = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            pstm.setInt(1,sal.getIdSalle());
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
    public List<Salle> readAll() {

        String req = "select * from salle";
        List<Salle> listSalle = new ArrayList<>();
        try(PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            ResultSet rset = pstm.executeQuery();
            while (rset.next()){
                int idSalle = rset.getInt(1);
                String sigle = rset.getString(2);
                int capacite = rset.getInt(3);
                Salle salle = new Salle(idSalle,sigle,capacite);
                listSalle.add(salle);
            }

            if (listSalle.isEmpty()){
                return null;
            }
            else return listSalle;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean addEnseignant(Salle sal, Enseignant ens) {
        String req1 = "insert into enseignant (matricule,nom,prenom,tel,chargeSem,salaireMensu,dateEngag,idSalle) values (?,?,?,?,?,?,?)";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(req1);)
        {
            String matricule = ens.getMatricule();
            String nom = ens.getNom();
            String prenom = ens.getPrenom();
            String tel = ens.getTel();
            int chargeSem = ens.getChargeSem();
            double salaire = ens.getSalaireMensu();
            LocalDate dateEngag = ens.getDateEngag();
            int idSalle = ens.getSalle().getIdSalle();
            pstm1.setString(1,matricule);
            pstm1.setString(2,nom);
            pstm1.setString(3,prenom);
            pstm1.setString(4,tel);
            pstm1.setInt(5,chargeSem);
            pstm1.setDouble(6,salaire);
            pstm1.setDate(7,Date.valueOf(dateEngag));
            pstm1.setInt(8,idSalle);
            int n = pstm1.executeUpdate(req1);
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
    public boolean suppEnseignant(Salle sal, Enseignant ens) {
        String req1 = "delete from enseignant where matricule = ? and nom = ? and prenom = ? and tel = ? and idSalle = ?";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(req1);)
        {
            String matricule = ens.getMatricule();
            String nom = ens.getNom();
            String prenom = ens.getPrenom();
            String tel = ens.getTel();
            int idSalle = ens.getSalle().getIdSalle();
            pstm1.setString(1,matricule);
            pstm1.setString(2,nom);
            pstm1.setString(3,prenom);
            pstm1.setString(4,tel);
            pstm1.setInt(5,idSalle);
            int n = pstm1.executeUpdate();
            if (n==0){
                return false;
            }
            else {
                return true;
            }

        }
        catch (Exception e){
            return false;
        }
    }
}
