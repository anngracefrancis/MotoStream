package cm.aptoide.aptoideviews.common;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Debouncer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bJ\u0006\u0010\f\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcm/aptoide/aptoideviews/common/Debouncer;", HttpUrl.FRAGMENT_ENCODE_SET, "delayMs", HttpUrl.FRAGMENT_ENCODE_SET, "(J)V", "getDelayMs", "()J", "lastClickTime", "execute", HttpUrl.FRAGMENT_ENCODE_SET, "function", "Lkotlin/Function0;", "reset", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Debouncer {
    private final long delayMs;
    private long lastClickTime;

    public Debouncer(long j2) {
        this.delayMs = j2;
    }

    public final void execute(Function0<u> function0) {
        m.f(function0, "function");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.lastClickTime > this.delayMs) {
            this.lastClickTime = jCurrentTimeMillis;
            function0.invoke();
        }
    }

    public final long getDelayMs() {
        return this.delayMs;
    }

    public final void reset() {
        this.lastClickTime = System.currentTimeMillis();
    }
}
