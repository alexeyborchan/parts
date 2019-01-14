package ru.javarush.parts.model;


import javax.persistence.*;

@Entity
@Table(name = "part")
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id")
    private Integer partId;
    @Column(name = "part_name")
    private String partName;
    @Column(name = "is_necessary")
    private boolean isNecessary;
    @Column(name = "amount")
    private int amount;

    public Part() {
    }

    public Part(String partName, int amount, boolean isNecessary) {
        this.partName = partName;
        this.amount = amount;
        this.isNecessary = isNecessary;
    }




    public Integer getPartId() {
        return partId;
    }

    public void setPartId(Integer partId) {
        this.partId = partId;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isNecessary() {
        return isNecessary;
    }

    public void setNecessary(boolean necessary) {
        isNecessary = necessary;
    }

    @Override
    public String toString() {
        return "Part{" +
                "partId=" + partId +
                ", partName='" + partName + '\'' +
                ", isNecessary=" + isNecessary +
                ", amount=" + amount +
                '}';
    }
}
