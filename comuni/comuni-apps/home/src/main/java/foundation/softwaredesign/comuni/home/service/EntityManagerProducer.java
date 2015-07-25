/*
 */
package foundation.softwaredesign.comuni.home.service;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@ApplicationScoped
public class EntityManagerProducer {

  @PersistenceContext(unitName = "comuni_home")
  private EntityManager entityManager;

  @Produces
  @RequestScoped
  public EntityManager create() {
    return entityManager;
  }

}
