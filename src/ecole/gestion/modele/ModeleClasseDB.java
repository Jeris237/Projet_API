package ecole.gestion.modele;

import ecole.gestion.presenter.PresenterCours;
import ecole.metier.Classe;
import ecole.metier.Cours;
import ecole.metier.Infos;
import myconnections.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModeleClasseDB implements DAOClasse{

    private Connection dbConnect;

    public ModeleClasseDB(){
        dbConnect= DBConnection.getConnection();
    }

    @Override
    public Classe create(Classe cl) {

        String req1="insert into classe(sigle,annee,specialite,nbreEleves) values(?,?,?,?)";
        String req2="select idClasse from classe where sigle = ?";

        try(PreparedStatement query1= dbConnect.prepareStatement(req1);
            PreparedStatement query2 = dbConnect.prepareStatement(req2);)
        {
            query1.setString(1,cl.getSigle());
            query1.setInt(2,cl.getAnnee());
            query1.setString(3,cl.getSpecialite());
            query1.setInt(4,cl.getNbreEleves());
            int n = query1.executeUpdate();
            if (n==0){
                return null;
            }
            query2.setString(1,cl.getSigle());
            ResultSet rset = query2.executeQuery();

            if (rset.next()){
                int idCl = rset.getInt(1);
                cl.setIdClasse(idCl);
                return cl;
            }
            else {
                throw new Exception("Aucune classe trouvée");
            }

        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Classe read(Classe cl) {
        String req="select * from classe where idClasse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req);)
        {
            pstm.setInt(1,cl.getIdClasse());
            ResultSet rset = pstm.executeQuery();
            if (rset.next()){
                int idcl = rset.getInt(1);
                String sigle = rset.getString(2);
                int annee = rset.getInt(3);
                String specialite = rset.getString(4);
                int nbrElv = rset.getInt(5);
                Classe clas = new Classe(idcl,sigle,annee,specialite,nbrElv);
                return clas;
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
    public Classe update(Classe cl) {
        String req = "update classe set annee = ? , specialite = ? , nbreEleves = ? where idClasse = ?";
        try(PreparedStatement pstm = dbConnect.prepareStatement(req);)
        {
            pstm.setInt(1,cl.getAnnee());
            pstm.setString(2,cl.getSpecialite());
            pstm.setInt(3,cl.getNbreEleves());
            pstm.setInt(4,cl.getIdClasse());
            int n = pstm.executeUpdate();
            if (n==0){
                return null;
            }
            else {
                return read(cl);
            }
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean delete(Classe cl) {
        String req = "delete from classe where idClasse = ?";
        try (PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            pstm.setInt(1,cl.getIdClasse());
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
    public List<Classe> readAll() {
        String req = "select * from classe";
        List<Classe> listClasse = new ArrayList<>();
        try(PreparedStatement pstm = dbConnect.prepareStatement(req))
        {
            ResultSet rset = pstm.executeQuery();
            while (rset.next()){
                int idCl = rset.getInt(1);
                String sigle = rset.getString(2);
                int annee = rset.getInt(3);
                String spec = rset.getString(4);
                int nbrElev = rset.getInt(5);
                Classe cl = new Classe(idCl,sigle,annee,spec,nbrElev);
                listClasse.add(cl);
            }

            if (listClasse.isEmpty()){
                return null;
            }
            else return listClasse;
        }
        catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public boolean addInfos(Classe cl, Infos inf) {
        String req1 = "insert into infos (idCours,idClasse,nbreHeures,idSalle,idEnseignant) values(?,?,?,?,?)";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(req1);)
        {
            int nbrHeure = inf.getNbreHeures();
            int idcours = inf.getCours().getIdCours();
            int idSalle = inf.getSalle().getIdSalle();
            int idEns = inf.getEnseignant().getIdEnseignant();
            int idClass = cl.getIdClasse();
            pstm1.setInt(1,idcours);
            pstm1.setInt(2,idClass);
            pstm1.setInt(3,nbrHeure);
            pstm1.setInt(4,idSalle);
            pstm1.setInt(5,idEns);
            int n = pstm1.executeUpdate(req1);
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

    @Override
    public boolean suppInfos(Classe cl, Infos inf) {
        String req1 = "delete from infos where idCours = ? and idClasse = ? and nbreHeures = ? and idSalle = ? and idEnseignant = ?";
        try(PreparedStatement pstm1 = dbConnect.prepareStatement(req1);)
        {
            int nbrHeure = inf.getNbreHeures();
            int idcours = inf.getCours().getIdCours();
            int idSalle = inf.getSalle().getIdSalle();
            int idEns = inf.getEnseignant().getIdEnseignant();
            int idClass = cl.getIdClasse();
            pstm1.setInt(1,idcours);
            pstm1.setInt(2,idClass);
            pstm1.setInt(3,nbrHeure);
            pstm1.setInt(4,idSalle);
            pstm1.setInt(5,idEns);
            int n = pstm1.executeUpdate(req1);
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

