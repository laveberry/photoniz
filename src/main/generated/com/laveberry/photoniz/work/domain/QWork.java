package com.laveberry.photoniz.work.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QWork is a Querydsl query type for Work
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QWork extends EntityPathBase<Work> {

    private static final long serialVersionUID = 599686582L;

    public static final QWork work = new QWork("work");

    public final com.laveberry.photoniz.common.QBaseTimeEntity _super = new com.laveberry.photoniz.common.QBaseTimeEntity(this);

    public final NumberPath<Integer> authorId = createNumber("authorId", Integer.class);

    public final ListPath<com.laveberry.photoniz.contract.model.Contract, com.laveberry.photoniz.contract.model.QContract> contracts = this.<com.laveberry.photoniz.contract.model.Contract, com.laveberry.photoniz.contract.model.QContract>createList("contracts", com.laveberry.photoniz.contract.model.Contract.class, com.laveberry.photoniz.contract.model.QContract.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath location = createString("location");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final StringPath workType = createString("workType");

    public QWork(String variable) {
        super(Work.class, forVariable(variable));
    }

    public QWork(Path<? extends Work> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWork(PathMetadata metadata) {
        super(Work.class, metadata);
    }

}

