package Mapper

import Dto.DeviceDto
import entity.Device
import org.springframework.stereotype.Component

@Component
object DeviceMapper {
    fun toEntity(deviceDto: DeviceDto): Device{
        val device = Device()
        device.id = deviceDto.id
        device.description = deviceDto.description
        return device
    }

    fun toDeviceDto(device: Device): DeviceDto{
        val deviceDto = DeviceDto()
        deviceDto.id = device.id
        deviceDto.description = device.description
        return deviceDto
    }
}