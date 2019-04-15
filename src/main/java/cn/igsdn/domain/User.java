package cn.igsdn.domain;

public class User {
    private Integer id;

    private String password;

    private Short genUserLevel;

    private Short adminUserLevel;

    private String tel;

    private String email;

    private String name;

    private String age;

    private Boolean gender;

    private String uname;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Short getGenUserLevel() {
        return genUserLevel;
    }

    public void setGenUserLevel(Short genUserLevel) {
        this.genUserLevel = genUserLevel;
    }

    public Short getAdminUserLevel() {
        return adminUserLevel;
    }

    public void setAdminUserLevel(Short adminUserLevel) {
        this.adminUserLevel = adminUserLevel;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }
}