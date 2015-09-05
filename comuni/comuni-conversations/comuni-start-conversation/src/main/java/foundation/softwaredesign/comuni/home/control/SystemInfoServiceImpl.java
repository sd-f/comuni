/*
 */
package foundation.softwaredesign.comuni.home.control;

import javax.ejb.Stateless;
import javax.inject.Inject;

import foundation.softwaredesign.comuni.home.boundary.SystemInfoDto;
import foundation.softwaredesign.comuni.home.boundary.SystemInfoService;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Stateless
public class SystemInfoServiceImpl implements SystemInfoService {

  @Inject
  SystemInfoRespository repo;

  @Override
  public SystemInfoDto getSystemInformation() {
    SystemInfoDto a = repo.findAll(0, 1).get(0);
    return a;
  }

}
