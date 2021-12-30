package vo;



public class Student {
    public enum SEX { MALE,FEMAIL }
    public enum CITY { SEOUL, BUSAN }

    private String name;

    private int score;

    private SEX sex;

    private String city;

    public SEX getSex() {
        return sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Student(String name, int score, SEX sex) {
        this.name = name;
        this.score = score;
        this.sex = sex;
    }
}
