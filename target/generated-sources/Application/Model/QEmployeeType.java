package Application.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEmployeeType is a Querydsl query type for EmployeeType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEmployeeType extends EntityPathBase<EmployeeType> {

    private static final long serialVersionUID = 1436435307L;

    public static final QEmployeeType employeeType = new QEmployeeType("employeeType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public QEmployeeType(String variable) {
        super(EmployeeType.class, forVariable(variable));
    }

    public QEmployeeType(Path<? extends EmployeeType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEmployeeType(PathMetadata metadata) {
        super(EmployeeType.class, metadata);
    }

}

