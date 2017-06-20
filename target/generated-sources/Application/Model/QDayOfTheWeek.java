package Application.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDayOfTheWeek is a Querydsl query type for DayOfTheWeek
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDayOfTheWeek extends EntityPathBase<DayOfTheWeek> {

    private static final long serialVersionUID = -688448939L;

    public static final QDayOfTheWeek dayOfTheWeek = new QDayOfTheWeek("dayOfTheWeek");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QDayOfTheWeek(String variable) {
        super(DayOfTheWeek.class, forVariable(variable));
    }

    public QDayOfTheWeek(Path<? extends DayOfTheWeek> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDayOfTheWeek(PathMetadata metadata) {
        super(DayOfTheWeek.class, metadata);
    }

}

