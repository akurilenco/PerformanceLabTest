package create_user;

import java.util.List;

public class InfoBuilder {
    private String adres;
    private String birthday;
    private String cat;
    private String cavy;
    private List<Long> companies;
    private String dateStart;
    private String dog;
    private String email;
    private String fathername1;
    private String gender;
    private String hamster;
    private String hobby;
    private String inn;
    private String name;
    private String name1;
    private String parrot;
    private String phone;
    private String squirrel;
    private String surname1;
    private List<Long> tasks;

    public InfoBuilder withAdres(String adres) {
        this.adres = adres;
        return this;
    }

    public InfoBuilder withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public InfoBuilder withCat(String cat) {
        this.cat = cat;
        return this;
    }

    public InfoBuilder withCavy(String cavy) {
        this.cavy = cavy;
        return this;
    }

    public InfoBuilder withCompanies(List<Long> companies) {
        this.companies = companies;
        return this;
    }

    public InfoBuilder withDateStart(String dateStart) {
        this.dateStart = dateStart;
        return this;
    }

    public InfoBuilder withDog(String dog) {
        this.dog = dog;
        return this;
    }

    public InfoBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public InfoBuilder withFathername1(String fathername1) {
        this.fathername1 = fathername1;
        return this;
    }

    public InfoBuilder withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public InfoBuilder withHamster(String hamster) {
        this.hamster = hamster;
        return this;
    }

    public InfoBuilder withHobby(String hobby) {
        this.hobby = hobby;
        return this;
    }

    public InfoBuilder withInn(String inn) {
        this.inn = inn;
        return this;
    }

    public InfoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public InfoBuilder withName1(String name1) {
        this.name1 = name1;
        return this;
    }

    public InfoBuilder withParrot(String parrot) {
        this.parrot = parrot;
        return this;
    }

    public InfoBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public InfoBuilder withSquirrel(String squirrel) {
        this.squirrel = squirrel;
        return this;
    }

    public InfoBuilder withSurname1(String surname1) {
        this.surname1 = surname1;
        return this;
    }

    public InfoBuilder withTasks(List<Long> tasks) {
        this.tasks = tasks;
        return this;
    }

    public Info build() {
        Info info = new Info();
        info.
                setAdres(adres).
                setBirthday(birthday).
                setCat(cat).
                setCavy(cavy).
                setCompanies(companies).
                setDateStart(dateStart).
                setDog(dog).
                setEmail(email).
                setFathername1(fathername1).
                setGender(gender).
                setHamster(hamster).
                setHobby(hobby).
                setInn(inn).
                setName(name).
                setName1(name1).
                setParrot(parrot).
                setPhone(phone).
                setSquirrel(squirrel).
                setSurname1(surname1).
                setTasks(tasks);
        return info;
    }
}
