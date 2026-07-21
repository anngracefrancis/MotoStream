package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UninitializedMessageException extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f25391f;

    public UninitializedMessageException(o oVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f25391f = null;
    }

    public InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
