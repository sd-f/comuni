/*
 */
package foundation.softwaredesign.comuni.home.control;

import foundation.softwaredesign.comuni.home.boundary.SystemInformationService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import foundation.softwaredesign.comuni.home.boundary.SystemInformation;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Stateless
public class SystemInformatinServiceImpl implements SystemInformationService {

  @PersistenceContext(unitName = "comuni_home")
  private EntityManager entityManager;

  @Inject
  SystemInfoRespository repo;

  @Override
  public SystemInformation getSystemInformation() {
    SystemInformation a = repo.findAll(0, 1).get(0);
    return a;
  }

}
