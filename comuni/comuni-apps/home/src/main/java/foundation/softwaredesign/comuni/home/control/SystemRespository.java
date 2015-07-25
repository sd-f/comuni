/*
 */
package foundation.softwaredesign.comuni.home.control;

import foundation.softwaredesign.comuni.home.boundary.SystemDto;
import foundation.softwaredesign.comuni.home.entity.SystemInfo;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Repository(forEntity = SystemInfo.class)
@MappingConfig(SystemDtoMapper.class)
public interface SystemRespository extends EntityRepository<SystemDto, String> {

}
