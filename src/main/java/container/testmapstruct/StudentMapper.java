package container.testmapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/31 09:24
 */
@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mappings({
            @Mapping(source = "name", target = "studentName"),
            @Mapping(source = "age", target = "studentAge")
    })
    StudentVO po2Vo(StudentPO studentPO);


    List<StudentVO> poList2VoList(List<StudentPO> studentPO);








}
