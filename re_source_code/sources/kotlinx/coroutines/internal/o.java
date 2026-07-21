package kotlinx.coroutines.internal;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: LimitedDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\b\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"checkParallelism", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class o {
    public static final void a(int i2) {
        if (i2 >= 1) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i2).toString());
    }
}
