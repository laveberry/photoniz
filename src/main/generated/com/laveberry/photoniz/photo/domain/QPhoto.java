package com.laveberry.photoniz.photo.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPhoto is a Querydsl query type for Photo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPhoto extends EntityPathBase<Photo> {

    private static final long serialVersionUID = -1206930532L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPhoto photo = new QPhoto("photo");

    public final com.laveberry.photoniz.common.QBaseTimeEntity _super = new com.laveberry.photoniz.common.QBaseTimeEntity(this);

    public final com.laveberry.photoniz.board.domain.QBoard board;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createDate = _super.createDate;

    public final StringPath ext = createString("ext");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedDate = _super.modifiedDate;

    public final StringPath photoName = createString("photoName");

    public final StringPath photoOriginName = createString("photoOriginName");

    public final NumberPath<Long> photoSize = createNumber("photoSize", Long.class);

    public final EnumPath<com.laveberry.photoniz.photo.enums.PhotoType> photoType = createEnum("photoType", com.laveberry.photoniz.photo.enums.PhotoType.class);

    public final StringPath photoUrl = createString("photoUrl");

    public final com.laveberry.photoniz.user.domain.QUser user;

    public final com.laveberry.photoniz.work.domain.QWork work;

    public QPhoto(String variable) {
        this(Photo.class, forVariable(variable), INITS);
    }

    public QPhoto(Path<? extends Photo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPhoto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPhoto(PathMetadata metadata, PathInits inits) {
        this(Photo.class, metadata, inits);
    }

    public QPhoto(Class<? extends Photo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.board = inits.isInitialized("board") ? new com.laveberry.photoniz.board.domain.QBoard(forProperty("board"), inits.get("board")) : null;
        this.user = inits.isInitialized("user") ? new com.laveberry.photoniz.user.domain.QUser(forProperty("user"), inits.get("user")) : null;
        this.work = inits.isInitialized("work") ? new com.laveberry.photoniz.work.domain.QWork(forProperty("work")) : null;
    }

}

