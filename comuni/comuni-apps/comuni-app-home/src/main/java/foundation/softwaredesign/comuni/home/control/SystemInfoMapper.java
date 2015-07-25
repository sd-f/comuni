/*
 */
package foundation.softwaredesign.comuni.home.control;

import foundation.softwaredesign.comuni.home.boundary.SystemInfoDto;
import foundation.softwaredesign.comuni.home.entity.SystemInfo;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
public class SystemInfoMapper extends SimpleQueryInOutMapperBase<SystemInfo, SystemInfoDto> {

  @Override
  protected Object getPrimaryKey(SystemInfoDto dto) {
    return dto.getName();
  }

  @Override
  protected SystemInfoDto toDto(SystemInfo entity) {
    SystemInfoDto dto = new SystemInfoDto();
    dto.setName(entity.getName());
    dto.setWelcomeMessage(entity.getWelcomeMessage());
    return dto;
  }

  @Override
  protected SystemInfo toEntity(SystemInfo entity, SystemInfoDto dto) {
    entity.setName(dto.getName());
    entity.setWelcomeMessage(dto.getWelcomeMessage());
    return entity;
  }

}
