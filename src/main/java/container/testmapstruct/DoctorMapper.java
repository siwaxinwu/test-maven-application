package container.testmapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/31 10:32
 */
@Mapper(uses = {PatientMapper.class})
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    /*@Mappings({
            @Mapping(source = "doctor.specialty", target = "specialization"),
            @Mapping(source = "education.degreeName", target = "degree")
    })*/
    @Mapping(source = "doctor.specialty", target = "specialization")
    @Mapping(source = "education.degreeName", target = "degree")
    @Mapping(source = "doctor.patientList", target = "patientDtoList")
    DoctorDto toDto(Doctor doctor, Education education);

    /**
     * 更新现有实例
     * @param doctorDto
     * @param doctor
     */
    @Mapping(source = "doctorDto.patientDtoList", target = "patientList")
    @Mapping(source = "doctorDto.specialization", target = "specialty")
    void updateModel(DoctorDto doctorDto, @MappingTarget Doctor doctor);



}

