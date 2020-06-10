package org.project.domain.dto.user;

import org.springframework.stereotype.Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



@Repository

public class UserBase {
    private ArrayList<AccountData> platformBase = new ArrayList<>();

    public UserBase() {
        downloadBase();
    }

    public ArrayList<AccountData> getPlatformBase() {
        return platformBase;
    }

    public void setPlatformBase(ArrayList<AccountData> platformBase) {
        this.platformBase = platformBase;
    }

    public void add(AccountData aD){
        System.out.println("dodawanie: "+ aD.getNick());

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://rogue.db.elephantsql.com:5432/ezstzdga",
                            "ezstzdga", "o6zkA0o8vitrVts8Z37XcUEY1v9Z61rw");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            stmt = c.createStatement();

            String sql =
                    "INSERT INTO public.users(nick ,password ,question ,answer ) " +
                            "values ('"+ aD.getNick() + "','" + aD.getPassword() + "','" + aD.getQuestion() + "','" + aD.getAnswer() + "')";
            stmt.executeUpdate(sql);

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Utworzono");
        downloadBase();
    }

    public AccountData findUser(String nick){
        for(AccountData thisOne :platformBase) {
            if(nick.equals(thisOne.getNick())){
                return thisOne;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        String temp="" ;
        for(AccountData thisOne:platformBase){
            temp+=thisOne.getQuestion() +" ";
        }
        return temp;
    }

    public void downloadBase(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://rogue.db.elephantsql.com:5432/ezstzdga",
                            "ezstzdga", "o6zkA0o8vitrVts8Z37XcUEY1v9Z61rw");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM public.users");
            while ( rs.next() ) {
                String sqlNick = rs.getString("nick");
                String sqlPassword = rs.getString("password");
                String sqlQuestion  = rs.getString("question");
                String sqlAnswer = rs.getString("answer");
                Integer sqlTTTW = rs.getInt("tttgamewon");
                Integer sqlTTTL = rs.getInt("tttgamelost");
                Integer sqlBSW = rs.getInt("bsgamewon");
                Integer sqlBSL = rs.getInt("bsgamelost");
                System.out.println( "ID = " + sqlNick );
                System.out.println( "NAME = " + sqlPassword );
                System.out.println( "AGE = " + sqlQuestion );
                System.out.println( "ADDRESS = " + sqlAnswer );
                System.out.println();
                platformBase.add(new AccountData(sqlNick,sqlPassword,sqlQuestion,sqlAnswer,sqlTTTW,sqlTTTL,sqlBSW,sqlBSL));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }

    public void updateData(AccountData newAD,String what) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://rogue.db.elephantsql.com:5432/ezstzdga",
                            "ezstzdga", "o6zkA0o8vitrVts8Z37XcUEY1v9Z61rw");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            String sql;

            switch (what){
                case "password":
                    sql = "UPDATE public.users set password = '"+ newAD.getPassword()+"' where nick LIKE '"+ newAD.getNick()+"'";
                    stmt.executeUpdate(sql);
                    c.commit();
                    break;
                case "restart":
                    sql = "UPDATE public.users set tttgamewon = 0 where nick LIKE '"+ newAD.getNick()+"'";
                    stmt.executeUpdate(sql);
                    c.commit();
                     sql = "UPDATE public.users set tttgamelost = 0 where nick LIKE '"+ newAD.getNick()+"'";
                    stmt.executeUpdate(sql);
                    c.commit();
                     sql = "UPDATE public.users set bsgamewon = 0 where nick LIKE '"+ newAD.getNick()+"'";
                    stmt.executeUpdate(sql);
                    c.commit();
                    sql = "UPDATE public.users set bsgamelost = 0 where nick LIKE '"+ newAD.getNick()+"'";
                    stmt.executeUpdate(sql);
                    c.commit();

                    break;
                case "stats":
                    sql = "UPDATE public.users set tttgamewon = "+ newAD.tttGamesWon+" where nick LIKE "+ newAD.getNick();
                    stmt.executeUpdate(sql);
                    c.commit();
                    sql = "UPDATE public.users set tttgamelost = "+ newAD.tttGamesLost+" where nick LIKE "+ newAD.getNick();
                    stmt.executeUpdate(sql);
                    c.commit();
                    sql = "UPDATE public.users set bsgamewon = "+ newAD.shipsGamesWon+" where nick LIKE "+ newAD.getNick();
                    stmt.executeUpdate(sql);
                    c.commit();
                    sql = "UPDATE public.users set bsgamelost = "+ newAD.shipsGamesLost+" where nick LIKE "+ newAD.getNick();
                    stmt.executeUpdate(sql);
                    c.commit();
                    break;
            }
            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        downloadBase();
    }

}
