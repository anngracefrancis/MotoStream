package kotlin;

import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.l, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Standard.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lkotlin/NotImplementedError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NotImplementedError extends Error {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String str) {
        super(str);
        kotlin.jvm.internal.m.f(str, "message");
    }
}
