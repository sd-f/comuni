/*
 */
package foundation.softwaredesign.comuni.home.control;

import foundation.softwaredesign.comuni.home.boundary.SystemInformation;
import foundation.softwaredesign.comuni.home.entity.SystemInfo;
import org.apache.deltaspike.data.api.mapping.SimpleQueryInOutMapperBase;

/**
 *
 * @author Lucas Reeh <lreeh@tugraz.at>
 */
public class SystemInformationMapper extends SimpleQueryInOutMapperBase<SystemInfo, SystemInformation> {

  @Override
  protected Object getPrimaryKey(SystemInformation dto) {
    return dto.getName();
  }

  @Override
  protected SystemInformation toDto(SystemInfo entity) {
    SystemInformation dto = new SystemInformation();
    dto.setName(entity.getName());
    dto.setWelcomeMessage(entity.getWelcomeMessage());
    return dto;
  }

  @Override
  protected SystemInfo toEntity(SystemInfo entity, SystemInformation dto) {
    entity.setName(dto.getName());
    entity.setWelcomeMessage(dto.getWelcomeMessage());
    return entity;
  }

}
