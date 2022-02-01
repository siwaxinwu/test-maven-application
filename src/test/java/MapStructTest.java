import com.github.kevinsawicki.http.HttpRequest;
import container.testmapstruct.*;
import org.junit.Test;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/31 09:25
 */
public class MapStructTest {
    /*@Test
    public void studentPo2Vo() {
        StudentPO studentPO = StudentPO.builder().id(10).name("test")
                .age(24).className("教室名").build();
        StudentVO studentVO = StudentMapper.INSTANCE.po2Vo(studentPO);
        System.out.println(studentVO);
    }*/


    /*@Test
    public void poList2VoList() {
        List<StudentPO> studentPOList = new ArrayList<>();
        for (int i = 1; i <= 2; i++) {
            StudentPO studentPO = StudentPO.builder().id(i).name(String.valueOf(i)).age(i).build();
            studentPOList.add(studentPO);
        }
        List<StudentVO> studentVOList = StudentMapper.INSTANCE.poList2VoList(studentPOList);
        System.out.println(studentVOList);
    }*/

    /*@Test
    public void test_1() {

        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("patient1");
        patient.setDateOfBirth("23/11/2020");
        Patient patient1 = new Patient();
        patient1.setId(2);
        patient1.setName("patient2");
        List<Patient> patientsList = new ArrayList<>();
        patientsList.add(patient);
        patientsList.add(patient1);

        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("roy");
        doctor.setSpecialty("test11");
        Education education = new Education();
        education.setDegreeName("高中");
        education.setInstitute("123");
        education.setYearOfPassing(23);
        doctor.setPatientList(patientsList);
        System.out.println(doctor);
        DoctorDto dto = DoctorMapper.INSTANCE.toDto(doctor, education);
        System.out.println(dto);
    }*/

    /*@Test
    public void test_2() {
        Doctor doctor = new Doctor();
        doctor.setSpecialty("target");
        DoctorDto dto = new DoctorDto();
        dto.setSpecialization("roy");
        DoctorMapper.INSTANCE.updateModel(dto, doctor);
        System.out.println(doctor);
    }*/


}
