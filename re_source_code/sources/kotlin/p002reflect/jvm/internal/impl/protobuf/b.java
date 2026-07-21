package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.InputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.o;

/* JADX INFO: compiled from: AbstractParser.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b<MessageType extends o> implements q<MessageType> {
    private static final f a = f.c();

    private MessageType e(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw f(messagetype).a().i(messagetype);
    }

    private UninitializedMessageException f(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).a() : new UninitializedMessageException(messagetype);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public MessageType c(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return (MessageType) e(j(inputStream, fVar));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public MessageType a(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        return (MessageType) e(k(inputStream, fVar));
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public MessageType d(d dVar, f fVar) throws InvalidProtocolBufferException {
        return (MessageType) e(l(dVar, fVar));
    }

    public MessageType j(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        try {
            int i2 = inputStream.read();
            if (i2 == -1) {
                return null;
            }
            return (MessageType) k(new a.AbstractC0413a.C0414a(inputStream, e.B(i2, inputStream)), fVar);
        } catch (IOException e2) {
            throw new InvalidProtocolBufferException(e2.getMessage());
        }
    }

    public MessageType k(InputStream inputStream, f fVar) throws InvalidProtocolBufferException {
        e eVarG = e.g(inputStream);
        MessageType messagetypeB = b(eVarG, fVar);
        try {
            eVarG.a(0);
            return messagetypeB;
        } catch (InvalidProtocolBufferException e2) {
            throw e2.i(messagetypeB);
        }
    }

    public MessageType l(d dVar, f fVar) throws InvalidProtocolBufferException {
        try {
            e eVarV = dVar.v();
            MessageType messagetypeB = b(eVarV, fVar);
            try {
                eVarV.a(0);
                return messagetypeB;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.i(messagetypeB);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }
}
