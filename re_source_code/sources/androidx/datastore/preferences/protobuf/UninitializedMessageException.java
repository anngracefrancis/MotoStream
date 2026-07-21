package androidx.datastore.preferences.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class UninitializedMessageException extends RuntimeException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f1253f;

    public UninitializedMessageException(q0 q0Var) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.f1253f = null;
    }

    public InvalidProtocolBufferException a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
