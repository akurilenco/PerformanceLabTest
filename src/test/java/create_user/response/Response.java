
package create_user.response;

import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonProperty;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Response {
    private String adres;
    private Birthday birthday;
    @JsonProperty("by_user")
    private String byUser;
    private String cat;
    private String cavy;
    private List<Company> companies;
    private String date;
    @JsonProperty("date_register")
    private DateRegister dateRegister;
    @JsonProperty("date_start")
    private DateStart dateStart;
    @JsonProperty("date_updated")
    private DateUpdated dateUpdated;
    private String dog;
    private String email;
    private String fathername1;
    private String gender;
    private String hamster;
    private String hobby;
    private String name;
    private String name1;
    private String parrot;
    private int phone;
    private List<String> role;
    private String squirrel;
    private String surname1;
    private List<Task> tasks;

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Birthday getBirthday() {
        return birthday;
    }

    public void setBirthday(Birthday birthday) {
        this.birthday = birthday;
    }

    public String getByUser() {
        return byUser;
    }

    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getCavy() {
        return cavy;
    }

    public void setCavy(String cavy) {
        this.cavy = cavy;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DateRegister getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(DateRegister dateRegister) {
        this.dateRegister = dateRegister;
    }

    public DateStart getDateStart() {
        return dateStart;
    }

    public void setDateStart(DateStart dateStart) {
        this.dateStart = dateStart;
    }

    public DateUpdated getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(DateUpdated dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFathername1() {
        return fathername1;
    }

    public void setFathername1(String fathername1) {
        this.fathername1 = fathername1;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHamster() {
        return hamster;
    }

    public void setHamster(String hamster) {
        this.hamster = hamster;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getParrot() {
        return parrot;
    }

    public void setParrot(String parrot) {
        this.parrot = parrot;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getSquirrel() {
        return squirrel;
    }

    public void setSquirrel(String squirrel) {
        this.squirrel = squirrel;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
