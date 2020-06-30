import java.util.Objects;

/**
 * @author ming
 * @version 1.0
 * @date 2020/3/6 10:04 上午
 * @description
 */
public class HashEq {
    private int age;
    private int sex;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        HashEq hashEq = (HashEq) o;
        return age == hashEq.age &&
                sex == hashEq.sex &&
                name.equals(hashEq.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, sex, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
