package Application.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDocumentationFile is a Querydsl query type for DocumentationFile
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDocumentationFile extends EntityPathBase<DocumentationFile> {

    private static final long serialVersionUID = -1778072365L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDocumentationFile documentationFile1 = new QDocumentationFile("documentationFile1");

    public final QDocumentation documentation;

    public final SimplePath<java.sql.Blob> documentationFile = createSimple("documentationFile", java.sql.Blob.class);

    public final StringPath fileName = createString("fileName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QDocumentationFile(String variable) {
        this(DocumentationFile.class, forVariable(variable), INITS);
    }

    public QDocumentationFile(Path<? extends DocumentationFile> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDocumentationFile(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDocumentationFile(PathMetadata metadata, PathInits inits) {
        this(DocumentationFile.class, metadata, inits);
    }

    public QDocumentationFile(Class<? extends DocumentationFile> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.documentation = inits.isInitialized("documentation") ? new QDocumentation(forProperty("documentation"), inits.get("documentation")) : null;
    }

}

