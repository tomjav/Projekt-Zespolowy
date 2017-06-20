package Application.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWorkingHours is a Querydsl query type for WorkingHours
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWorkingHours extends EntityPathBase<WorkingHours> {

    private static final long serialVersionUID = -1427807551L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWorkingHours workingHours = new QWorkingHours("workingHours");

    public final QDayOfTheWeek dayOfTheWeek;

    public final QEmployee employee;

    public final StringPath fromTime = createString("fromTime");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath toTime = createString("toTime");

    public QWorkingHours(String variable) {
        this(WorkingHours.class, forVariable(variable), INITS);
    }

    public QWorkingHours(Path<? extends WorkingHours> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWorkingHours(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWorkingHours(PathMetadata metadata, PathInits inits) {
        this(WorkingHours.class, metadata, inits);
    }

    public QWorkingHours(Class<? extends WorkingHours> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dayOfTheWeek = inits.isInitialized("dayOfTheWeek") ? new QDayOfTheWeek(forProperty("dayOfTheWeek")) : null;
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee"), inits.get("employee")) : null;
    }

}

