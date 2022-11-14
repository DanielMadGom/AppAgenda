/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package appagenda;

import entidades.Provincia;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Madrid
 * @version 1.0
 */
public class AppAgenda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Map<String,String> emfProperties = new HashMap<String,String>();
        EntityManagerFactory emf=
            Persistence.createEntityManagerFactory("AppAgendaPU",emfProperties);
        EntityManager em=emf.createEntityManager();
        
        /*
        Provincia provinciaSevilla=new Provincia();
        provinciaSevilla.setNombre("Sevilla");
        */
        
        //Iniciar una transaccion
        em.getTransaction().begin();
        
        /*
        em.persist(provinciaSevilla);
        */
        
        //Confirmar cambios realizados
        em.getTransaction().commit();

        em.close();
        emf.close();
        try{
            DriverManager.getConnection("jdbc:derby:BDAgenda;shutdown=true");
        } catch (SQLException ex){
        }    
    }
    
}
