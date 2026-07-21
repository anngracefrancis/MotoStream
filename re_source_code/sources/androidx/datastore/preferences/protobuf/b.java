package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.q0;

/* JADX INFO: compiled from: AbstractParser.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b<MessageType extends q0> implements y0<MessageType> {
    private static final p a = p.b();

    private MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).a().i(messagetype);
    }

    private UninitializedMessageException d(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).m() : new UninitializedMessageException(messagetype);
    }

    @Override // androidx.datastore.preferences.protobuf.y0
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessageType a(h hVar, p pVar) throws InvalidProtocolBufferException {
        return (MessageType) c(f(hVar, pVar));
    }

    public MessageType f(h hVar, p pVar) throws InvalidProtocolBufferException {
        try {
            j jVarV = hVar.v();
            MessageType messagetypeB = b(jVarV, pVar);
            try {
                jVarV.a(0);
                return messagetypeB;
            } catch (InvalidProtocolBufferException e2) {
                throw e2.i(messagetypeB);
            }
        } catch (InvalidProtocolBufferException e3) {
            throw e3;
        }
    }
}
