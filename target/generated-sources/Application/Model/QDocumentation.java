package Application.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDocumentation is a Querydsl query type for Documentation
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDocumentation extends EntityPathBase<Documentation> {

    private static final long serialVersionUID = 910659255L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDocumentation documentation = new QDocumentation("documentation");

    public final QEmployee employee;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPatient patient;

    public final StringPath text = createString("text");

    public final DateTimePath<java.util.Date> timeOfInscription = createDateTime("timeOfInscription", java.util.Date.class);

    public final StringPath title = createString("title");

    public QDocumentation(String variable) {
        this(Documentation.class, forVariable(variable), INITS);
    }

    public QDocumentation(Path<? extends Documentation> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDocumentation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDocumentation(PathMetadata metadata, PathInits inits) {
        this(Documentation.class, metadata, inits);
    }

    public QDocumentation(Class<? extends Documentation> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee"), inits.get("employee")) : null;
        this.patient = inits.isInitialized("patient") ? new QPatient(forProperty("patient"), inits.get("patient")) : null;
    }

}

