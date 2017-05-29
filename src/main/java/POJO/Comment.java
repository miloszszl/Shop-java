package POJO;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Miłosz on 18.03.2017.
 */
@Entity
@Table(name = "Komentarze")
@AssociationOverrides({
        @AssociationOverride(name = "idComment.product",
                joinColumns = @JoinColumn(name = "idProduktu")),
        @AssociationOverride(name = "idComment.user",
                joinColumns = @JoinColumn(name = "idUzytkownika")) })
public class Comment {

    @EmbeddedId
    private CommentId idComment;

    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Timestamp datetime;

    @Column(name="opis")
    @Type(type="text")
    private String description;

    @PrePersist
    protected void onCreate() {
        datetime = new Timestamp(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        datetime = new Timestamp(System.currentTimeMillis());
    }


    public Comment(){}

    public Comment(CommentId idComment, Timestamp datetime, String description) {
        this.idComment = idComment;
        this.datetime = datetime;
        this.description = description;
    }

    public CommentId getIdComment() {
        return idComment;
    }

    public void setIdComment(CommentId idComment) {
        this.idComment = idComment;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
