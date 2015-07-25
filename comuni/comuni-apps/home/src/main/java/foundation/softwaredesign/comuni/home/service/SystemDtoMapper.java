/*
 */
package foundation.softwaredesign.comuni.home.service;

import foundation.softwaredesign.comuni.home.boundary.SystemDto;
import foundation.softwaredesign.comuni.home.entity.SystemEntity;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
public class SystemDtoMapper extends SimpleQueryInOutMapperBase<SystemEntity, SystemDto> {

  @Override
  protected Object getPrimaryKey(SystemDto dto) {
    return dto.getName();
  }

  @Override
  protected SystemDto toDto(SystemEntity entity) {
    SystemDto dto = new SystemDto();
    dto.setName(entity.getName());
    dto.setWelcomeMessage(entity.getWelcomeMessage());
    return dto;
  }

  @Override
  protected SystemEntity toEntity(SystemEntity entity, SystemDto dto) {
    entity.setName(dto.getName());
    entity.setWelcomeMessage(dto.getWelcomeMessage());
    return entity;
  }

}
