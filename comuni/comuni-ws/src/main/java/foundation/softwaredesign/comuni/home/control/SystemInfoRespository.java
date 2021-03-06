/*
 */
package foundation.softwaredesign.comuni.home.control;

import foundation.softwaredesign.comuni.home.boundary.SystemInfoDto;
import foundation.softwaredesign.comuni.home.entity.SystemInfo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Repository(forEntity = SystemInfo.class)
@MappingConfig(SystemInfoMapper.class)
public interface SystemInfoRespository extends EntityRepository<SystemInfoDto, String> {

}
