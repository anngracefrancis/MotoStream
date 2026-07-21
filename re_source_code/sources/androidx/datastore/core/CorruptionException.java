package androidx.datastore.core;

import java.io.IOException;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Serializer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/datastore/core/CorruptionException;", "Ljava/io/IOException;", HttpUrl.FRAGMENT_ENCODE_SET, "message", HttpUrl.FRAGMENT_ENCODE_SET, "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "datastore-core"}, k = 1, mv = {1, 5, 1})
public final class CorruptionException extends IOException {
    public /* synthetic */ CorruptionException(String str, Throwable th, int i2, kotlin.jvm.internal.g gVar) {
        this(str, (i2 & 2) != 0 ? null : th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CorruptionException(String str, Throwable th) {
        super(str, th);
        kotlin.jvm.internal.m.f(str, "message");
    }
}
