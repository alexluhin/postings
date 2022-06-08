package ru.test.postings.postdata;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PostRecord {

    @Id
    @SequenceGenerator(name = "posting_sequence", sequenceName = "posting_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "posting_sequence")
    private Long id;
    private String matdoc;
    private int item;
    private LocalDate docdate;
    private LocalDate pstngdate;
    private String matdesc;
    private int quantity;
    private String bun;
    private double amount;
    private String crcy;
    private String username;
    private boolean autorpstn;

    public PostRecord() {
    }

    public PostRecord(String matdoc, int item, LocalDate docdate, LocalDate pstngdate, String matdesc, int quantity, String bun, double amount, String crcy, String username, boolean autorpstn) {
        this.matdoc = matdoc;
        this.item = item;
        this.docdate = docdate;
        this.pstngdate = pstngdate;
        this.matdesc = matdesc;
        this.quantity = quantity;
        this.bun = bun;
        this.amount = amount;
        this.crcy = crcy;
        this.username = username;
        this.autorpstn = autorpstn;
    }

    public String getMatdoc() {
        return matdoc;
    }

    public int getItem() {
        return item;
    }

    public LocalDate getDocdate() {
        return docdate;
    }

    public LocalDate getPstngdate() {
        return pstngdate;
    }

    public String getMatdesc() {
        return matdesc;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getBun() {
        return bun;
    }

    public double getAmount() {
        return amount;
    }

    public String getCrcy() {
        return crcy;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAutorpstn() {
        return autorpstn;
    }

    public void setMatdoc(String matdoc) {
        this.matdoc = matdoc;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setDocdate(LocalDate docdate) {
        this.docdate = docdate;
    }

    public void setPstngdate(LocalDate pstngdate) {
        this.pstngdate = pstngdate;
    }

    public void setMatdesc(String matdesc) {
        this.matdesc = matdesc;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setBun(String bun) {
        this.bun = bun;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCrcy(String crcy) {
        this.crcy = crcy;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAutorpstn(boolean autorpstn) {
        this.autorpstn = autorpstn;
    }

    @Override
    public String toString() {
        return "PostRecord{" +
                "id=" + id +
                ", matdoc=" + matdoc +
                ", item=" + item +
                ", docdate=" + docdate +
                ", pstngdate=" + pstngdate +
                ", matdesc='" + matdesc + '\'' +
                ", quantity=" + quantity +
                ", bun='" + bun + '\'' +
                ", amount=" + amount +
                ", crcy='" + crcy + '\'' +
                ", username='" + username + '\'' +
                ", autorpstn=" + autorpstn +
                '}';
    }
}
