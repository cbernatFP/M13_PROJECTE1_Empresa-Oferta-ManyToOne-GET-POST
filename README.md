# Exemples JPA 1:N

## Exemples de relacions 1:N

- El carro de la compra i els ítems comprats
- El tutorial i els seus comentaris.
- Una empres i les seves ofertes de feina.

Conceptualment a nivell de disseny de base de dades relacional, l’esquema és el mateix. Una relació 1:N. En el fill ens guardarem la clau forana del pare.

Però quan treballem amb objectes hem de pensar què és el més eficient.

Diferents casuístiques: 

### El carro de la compra i els ítems comprats
Té sentit tenir els ítems com una llista dins el carro. En principi mai consultarem un ítem fora del seu carro. Consultarem els items d’un carro.

### El tutorial i els seus comentaris.
Podríem tenir els comentaris coma una llista dins el tutorial, però si un tutorial té 10.000 comentaris se’ns complica la cosa. Tot i que en principi no consultarem comentaris fora del tutorial corresponent. Consultarem els comentaris d’un tutorial.

### Una empres i les seves ofertes de feina.
Aquí sí que ens pot interessar consultar les ofertes d’una empresa, però també consultar ofertes en general per altres criteris…



## @ManyToOne. A la classe fill ens guardem qui és el pare
https://www.bezkoder.com/jpa-one-to-many/

A la classe pare no guardem res.
@Entity
@Table(name = "tutorials")
public class Tutorial {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutorial_generator")
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "published")
  private boolean published;


A la classe fill ens guardem qui és el pare

@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_generator")
  private Long id;

  @Lob
  private String content;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "tutorial_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JsonIgnore
  private Tutorial tutorial;

  // getters and setters
}

