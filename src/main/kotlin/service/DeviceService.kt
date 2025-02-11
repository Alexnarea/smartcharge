package service

import Dto.DeviceDto
import Mapper.DeviceMapper
import entity.Device
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import repository.DeviceRepository

@Service
class DeviceService {

    @Autowired
    lateinit var deviceRepository: DeviceRepository

    @Autowired
    lateinit var deviceMapper: DeviceMapper

    fun findAll(): List<DeviceDto>{
        val device = deviceRepository.findAll()
        return device.map { deviceMapper.toDeviceDto(it) }
    }


    fun findById(id: Long): DeviceDto{
        val device = deviceRepository.findById(id)
            .orElseThrow{EntityNotFoundException("Device with id $id not found")}
        return deviceMapper.toDeviceDto(device)
    }


    fun save(deviceDto: DeviceDto): DeviceDto{
        val device = deviceMapper.toEntity(deviceDto)
        val saveDevice = deviceRepository.save(device)
        return deviceMapper.toDeviceDto(saveDevice)
    }


    fun update(id: Long, deviceDto: DeviceDto): DeviceDto{
        val device = deviceRepository.findById(id)
        .orElseThrow{EntityNotFoundException("Device with id $id not found")}
        device.apply {
            description = deviceDto.description
        }
        val updateDevice = deviceRepository.save(device)
        return deviceMapper.toDeviceDto(updateDevice)
    }


    fun delete(id: Long){
        val device = deviceRepository.findById(id)
        .orElseThrow{EntityNotFoundException("Device with id $id not found")}
        deviceRepository.delete(device)
    }
}