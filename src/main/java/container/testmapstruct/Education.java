package container.testmapstruct;

/**
 * @description:
 * @author: Ding Yawu
 * @create: 2021/12/31 11:02
 */
public class Education {
    private String degreeName;
    private String institute;
    private Integer yearOfPassing;

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public Integer getYearOfPassing() {
        return yearOfPassing;
    }

    public void setYearOfPassing(Integer yearOfPassing) {
        this.yearOfPassing = yearOfPassing;
    }

    @Override
    public String toString() {
        return "Education{" +
                "degreeName='" + degreeName + '\'' +
                ", institute='" + institute + '\'' +
                ", yearOfPassing=" + yearOfPassing +
                '}';
    }
}
