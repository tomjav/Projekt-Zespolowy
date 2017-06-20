package Application.Model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAppointment is a Querydsl query type for Appointment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAppointment extends EntityPathBase<Appointment> {

    private static final long serialVersionUID = 289661660L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAppointment appointment = new QAppointment("appointment");

    public final DateTimePath<java.util.Date> date = createDateTime("date", java.util.Date.class);

    public final QEmployee employee;

    public final NumberPath<Integer> hour = createNumber("hour", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QPatient patient;

    public QAppointment(String variable) {
        this(Appointment.class, forVariable(variable), INITS);
    }

    public QAppointment(Path<? extends Appointment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAppointment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAppointment(PathMetadata metadata, PathInits inits) {
        this(Appointment.class, metadata, inits);
    }

    public QAppointment(Class<? extends Appointment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee"), inits.get("employee")) : null;
        this.patient = inits.isInitialized("patient") ? new QPatient(forProperty("patient"), inits.get("patient")) : null;
    }

}

