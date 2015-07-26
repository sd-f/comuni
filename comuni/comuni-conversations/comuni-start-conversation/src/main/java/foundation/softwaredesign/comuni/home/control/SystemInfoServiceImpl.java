/*
 */
package foundation.softwaredesign.comuni.home.control;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import foundation.softwaredesign.comuni.home.boundary.SystemInfoDto;
import foundation.softwaredesign.comuni.home.boundary.SystemInfoService;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Stateless
public class SystemInfoServiceImpl implements SystemInfoService {

  @PersistenceContext(unitName = "comuni_home")
  private EntityManager entityManager;

  @Inject
  SystemInfoRespository repo;

  @Override
  public SystemInfoDto getSystemInformation() {
    SystemInfoDto a = repo.findAll(0, 1).get(0);
    return a;
  }

}
