/*
 * The copyright of this file belongs to Koninklijke Philips N.V., 2019.
 */
package com.pankaj.task.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pankaj.task.domain.Alert;

@Transactional
@Repository
public class AlertDAOImpl implements AlertDAO{
  @PersistenceContext
  EntityManager em;

  @Override
  public Alert add(Alert alert) {
    em.persist(alert);
    return alert;
  }

  @Override
  public Alert findById(String alertId) {
    return em.find(Alert.class, alertId);
  }

  @Override
  public List<Alert> findAll() {
    return em.createQuery("select p from Alert p").getResultList();
  }

  @Override
  public void deleteById(String alertId) {
    em.createQuery("delete from Alert p where p.id = :idParam").setParameter("idParam", alertId).executeUpdate();
  }

  @Override
  public int findApplicationId(String alertId) {
    return (int) em.createQuery("select p.bedId from Alert p where p.id = :idParam").setParameter("idParam", alertId).getSingleResult();
  }

  @Override
  public void alarmSwitch(String type, boolean isCritical, String alertId) {
    if(type.equals("high")) {
      em.createQuery("update Alert p set p.highAlert = :isCritical where p.id = :idParam").setParameter("idParam", alertId).setParameter("isCritical", isCritical).executeUpdate();
    } else if(type.equals("medium")) {
      em.createQuery("update Alert p set p.mediumAlert = :isCritical where p.id = :idParam").setParameter("idParam", alertId).setParameter("isCritical", isCritical).executeUpdate();
    } else if(type.equals("low")) {
      em.createQuery("update Alert p set p.lowAlert = :isCritical where p.id = :idParam").setParameter("idParam", alertId).setParameter("isCritical", isCritical).executeUpdate();
    }
  }
}
