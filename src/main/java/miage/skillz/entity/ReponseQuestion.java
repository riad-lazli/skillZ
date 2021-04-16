package miage.skillz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="reponseQuestion")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ReponseQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idReponse;
    private String libelle;
    private Boolean isCorrect;  // true si c'est une bonne reponse
    private Boolean isSelected; // true si le user a sélectionné cette réponse

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idQuestion")
    private Question question;


}