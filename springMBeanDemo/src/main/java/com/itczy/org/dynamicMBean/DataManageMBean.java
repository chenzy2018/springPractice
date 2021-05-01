package com.itczy.org.dynamicMBean;

/**
 * 实现类的类名和接口名可以毫无关联，只需要实现接口接口
 */
public class DataManageMBean implements Data {

    private Long id;

    private String name;

    private int age;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                "age='" + age + '\'' +
                '}';
    }
}
