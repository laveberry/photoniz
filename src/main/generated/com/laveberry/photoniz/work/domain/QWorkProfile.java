package com.laveberry.photoniz.work.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QWorkProfile is a Querydsl query type for WorkProfile
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWorkProfile extends EntityPathBase<WorkProfile> {

    private static final long serialVersionUID = -397939949L;

    public static final QWorkProfile workProfile = new QWorkProfile("workProfile");

    public final NumberPath<Integer> author_id = createNumber("author_id", Integer.class);

    public final NumberPath<Integer> discount = createNumber("discount", Integer.class);

    public final StringPath location = createString("location");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final StringPath use_yn = createString("use_yn");

    public final NumberPath<Integer> work_profile_id = createNumber("work_profile_id", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> work_time = createDateTime("work_time", java.time.LocalDateTime.class);

    public final NumberPath<Integer> work_type = createNumber("work_type", Integer.class);

    public QWorkProfile(String variable) {
        super(WorkProfile.class, forVariable(variable));
    }

    public QWorkProfile(Path<? extends WorkProfile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWorkProfile(PathMetadata metadata) {
        super(WorkProfile.class, metadata);
    }

}

