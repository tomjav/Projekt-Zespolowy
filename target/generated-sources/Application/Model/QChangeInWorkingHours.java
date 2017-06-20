package Application.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChangeInWorkingHours is a Querydsl query type for ChangeInWorkingHours
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChangeInWorkingHours extends EntityPathBase<ChangeInWorkingHours> {

    private static final long serialVersionUID = 1369820502L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChangeInWorkingHours changeInWorkingHours = new QChangeInWorkingHours("changeInWorkingHours");

    public final StringPath action = createString("action");

    public final DateTimePath<java.util.Date> dateFrom = createDateTime("dateFrom", java.util.Date.class);

    public final QDayOfTheWeek dayOfTheWeek;

    public final QEmployee employee;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath timeFrom = createString("timeFrom");

    public final StringPath timeTo = createString("timeTo");

    public QChangeInWorkingHours(String variable) {
        this(ChangeInWorkingHours.class, forVariable(variable), INITS);
    }

    public QChangeInWorkingHours(Path<? extends ChangeInWorkingHours> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChangeInWorkingHours(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChangeInWorkingHours(PathMetadata metadata, PathInits inits) {
        this(ChangeInWorkingHours.class, metadata, inits);
    }

    public QChangeInWorkingHours(Class<? extends ChangeInWorkingHours> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dayOfTheWeek = inits.isInitialized("dayOfTheWeek") ? new QDayOfTheWeek(forProperty("dayOfTheWeek")) : null;
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee"), inits.get("employee")) : null;
    }

}

