package appagenda;


import entidades.Provincia;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Daniel Madrid
 * @version 1.0
 */
public class ConsultaProvincias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String,String> emfProperties = new HashMap<String,String>();
        EntityManagerFactory emf=
        Persistence.createEntityManagerFactory("AppAgendaPU",emfProperties);
        EntityManager em=emf.createEntityManager();
        Query queryProvinciaBarcelona = em.createNamedQuery("Provincia.findByNombre");
        queryProvinciaBarcelona.setParameter("nombre", "Barcelona");
        List<Provincia> listProvinciasBarcelona =queryProvinciaBarcelona.getResultList();
        em.getTransaction().begin();
        for(Provincia provinciaBarcelona : listProvinciasBarcelona){
        provinciaBarcelona.setCodigo("BC");
        em.merge(provinciaBarcelona);
        }
        em.getTransaction().commit();
    }
    
}
