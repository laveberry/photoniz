package com.laveberry.photoniz.photoBoard.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPhotoBoard is a Querydsl query type for PhotoBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPhotoBoard extends EntityPathBase<PhotoBoard> {

    private static final long serialVersionUID = 1045240508L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhotoBoard photoBoard = new QPhotoBoard("photoBoard");

    public final com.laveberry.photoniz.common.QBaseTimeEntity _super = new com.laveberry.photoniz.common.QBaseTimeEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final BooleanPath deleteYn = createBoolean("deleteYn");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final NumberPath<Integer> mainPhotoId = createNumber("mainPhotoId", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final NumberPath<Integer> readCount = createNumber("readCount", Integer.class);

    public final StringPath title = createString("title");

    public final EnumPath<com.laveberry.photoniz.photoBoard.enums.MainType> type = createEnum("type", com.laveberry.photoniz.photoBoard.enums.MainType.class);

    public final com.laveberry.photoniz.user.domain.QUser user;

    public final EnumPath<com.laveberry.photoniz.work.enums.WorkType> workType = createEnum("workType", com.laveberry.photoniz.work.enums.WorkType.class);

    public QPhotoBoard(String variable) {
        this(PhotoBoard.class, forVariable(variable), INITS);
    }

    public QPhotoBoard(Path<? extends PhotoBoard> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPhotoBoard(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPhotoBoard(PathMetadata metadata, PathInits inits) {
        this(PhotoBoard.class, metadata, inits);
    }

    public QPhotoBoard(Class<? extends PhotoBoard> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.laveberry.photoniz.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

