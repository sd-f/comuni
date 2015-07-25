/*
 */
package foundation.softwaredesign.comuni.home.control;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import foundation.softwaredesign.comuni.home.boundary.SystemDto;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Stateless
public class SystemService {

  @PersistenceContext(unitName = "comuni_home")
  private EntityManager entityManager;

  @Inject
  SystemRespository repo;

  public SystemDto getSystemInfo() {
    SystemDto a = repo.findAll(0, 1).get(0);
    return a;
  }

}
