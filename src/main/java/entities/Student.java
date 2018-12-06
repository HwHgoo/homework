package entities;

import java.util.HashMap;

public class Student {
    private int id;
    private HashMap<String,Object> attributes = new HashMap<>();
    {
//        attributes.put("gender",null);
//        attributes.put("politics",null);
//        attributes.put("chinese",null);
//        attributes.put("math",null);
//        attributes.put("foreign",null);
//        attributes.put("physics",null);
//        attributes.put("chemistry",null);
//        attributes.put("geography",null);
//        attributes.put("history",null);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public HashMap<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(HashMap<String, Object> attributes) {
        this.attributes = attributes;
    }

    public Student(int id, HashMap<String, Object> attributes) {
        this.id = id;
        this.attributes = attributes;
    }

    public Student() {
    }
}
