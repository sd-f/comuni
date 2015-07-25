/*
 */
package foundation.softwaredesign.comuni.home.service;

import foundation.softwaredesign.comuni.home.boundary.SystemDto;
import foundation.softwaredesign.comuni.home.entity.SystemEntity;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import org.apache.deltaspike.data.api.mapping.MappingConfig;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
@Repository(forEntity = SystemEntity.class)
@MappingConfig(SystemDtoMapper.class)
public interface SystemRespository extends EntityRepository<SystemDto, String> {

}
