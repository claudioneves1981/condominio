package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@SequenceGenerator(name = "seq_contato" , sequenceName = "seq_contato", allocationSize = 1)
public class Contato {


    private Long id;

    private String telefone;

    private String email;

}
