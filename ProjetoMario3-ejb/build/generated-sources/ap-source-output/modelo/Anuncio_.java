package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-26T08:29:01")
@StaticMetamodel(Anuncio.class)
public class Anuncio_ { 

    public static volatile SingularAttribute<Anuncio, Integer> idanuncio;
    public static volatile SingularAttribute<Anuncio, String> titulo;
    public static volatile SingularAttribute<Anuncio, Usuario> usuario;
    public static volatile SingularAttribute<Anuncio, String> descricao;

}