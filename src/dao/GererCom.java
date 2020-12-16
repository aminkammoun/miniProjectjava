package dao;

import presentation.Compte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GererCom {


    public List<Compte> getAllCompte() {
        Connection cx = SingletonConnection.getConnection();
        List<Compte> liste = new ArrayList<>();
        try {
            Statement myStmt = cx.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from compte");
            while (myRs.next()) {
                Compte c = new Compte();
                c.setCode(myRs.getInt(1));
                c.setSolde(myRs.getDouble(2));
                liste.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return liste;
    }
    public Compte getCompteparCode(int code){
        Connection cx = SingletonConnection.getConnection();
        Compte c= null;
        try {
            PreparedStatement ps = cx.prepareStatement("select * from compte where code= ?");
            ps.setInt(1,code);
            ResultSet rs= ps.executeQuery();

            if (rs.next()) {
                c = new Compte();
                c.setCode(rs.getInt(1));
                c.setSolde(rs.getDouble(2));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public void debiterCompte(int code,double montant){
        Connection cx = SingletonConnection.getConnection();
        Compte c=getCompteparCode(code);
        try {
            PreparedStatement pr = cx.prepareStatement("update compte set solde=? where code=?");
            pr.setDouble(1,c.getSolde()+montant);
            pr.setInt(2,code);
            pr.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
    }    }
    public void criditerCompte(int code,double montant){
        Connection cx = SingletonConnection.getConnection();
        Compte c= getCompteparCode(code);

        try {
            PreparedStatement pr = cx.prepareStatement("update compte set solde=? where code=?");
            pr.setDouble(1,c.getSolde()-montant);
            pr.setInt(2,code);
            pr.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void virerCompte(int code1,int code2, double montant){
        criditerCompte(code1,montant);
        debiterCompte(code2,montant);
    }



}
