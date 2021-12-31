package container.testmapstruct;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/31 10:31
 */

public class DoctorDto {
    private int id;
    private String name;
    private String specialization;
    private List<PatientDto> patientDtoList;
    private String degree;

    public List<PatientDto> getPatientDtoList() {
        return patientDtoList;
    }

    public void setPatientDtoList(List<PatientDto> patientDtoList) {
        this.patientDtoList = patientDtoList;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "DoctorDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialization='" + specialization + '\'' +
                ", patientDtoList=" + patientDtoList +
                ", degree='" + degree + '\'' +
                '}';
    }
}