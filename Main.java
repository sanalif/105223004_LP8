import java.time.LocalDate;

class HealthRecord {
    private String medicalRecordName;
    private LocalDate creationDate;

    public HealthRecord(String medicalRecordName) {
        this.medicalRecordName = medicalRecordName;
        this.creationDate = LocalDate.now();
    }

    public String getMedicalRecordName() {
        return medicalRecordName;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }
}

class Animal {
    protected String name;
    protected HealthRecord healthRecord;

    public Animal(String name, String medicalRecordName) {
        this.name = name;
        this.healthRecord = new HealthRecord(medicalRecordName);
    }

    // Method default untuk suara (bisa diganti di subclass tanpa override)
    public void makeSound() {
        System.out.println("Suara hewan tidak diketahui.");
    }

    public String getName() {
        return name;
    }

    public HealthRecord getHealthRecord() {
        return healthRecord;
    }
}

class Dog extends Animal {
    public Dog(String name, String medicalRecordName) {
        super(name, medicalRecordName);
    }

    
    public void makeSound() {
        System.out.println("Gok-Gok!");
    }
}

class Cat extends Animal {
    public Cat(String name, String medicalRecordName) {
        super(name, medicalRecordName);
    }

    public void makeSound() {
        System.out.println("Meong-Meong!");
    }
}

class Owner {
    private String name;
    private Animal pet;

    public Owner(String name, Animal pet) {
        this.name = name;
        this.pet = pet;
    }

    public void showInfo() {
        System.out.println("Nama Pemilik     : " + name);
        System.out.println("Nama Hewan       : " + pet.getName());
        System.out.println("Jenis Hewan      : " + pet.getClass().getSimpleName());
        System.out.print("Suara Hewan      : ");
        pet.makeSound();
        System.out.println("Nama Rekam Medis : " + pet.getHealthRecord().getMedicalRecordName());
        System.out.println("Tanggal Dibuat   : " + pet.getHealthRecord().getCreationDate());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Bruno", "RM-Dog001");
        Animal cat = new Cat("Mimi", "RM-Cat001");

        Owner owner1 = new Owner("Andi", dog);
        Owner owner2 = new Owner("Siti", cat);

        owner1.showInfo();
        owner2.showInfo();
    }
}
