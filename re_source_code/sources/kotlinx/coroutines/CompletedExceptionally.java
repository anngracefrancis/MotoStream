package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.b0, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CompletionState.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0010\u0018\u00002\u00020\u000fB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\u00020\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/CompletedExceptionally;", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "handled", "<init>", "(Ljava/lang/Throwable;Z)V", "makeHandled", "()Z", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "Ljava/lang/Throwable;", "getHandled", "kotlinx-coroutines-core", HttpUrl.FRAGMENT_ENCODE_SET}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CompletedExceptionally {
    private static final /* synthetic */ AtomicIntegerFieldUpdater a = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f25646b;

    public CompletedExceptionally(Throwable th, boolean z) {
        this.f25646b = th;
        this._handled = z ? 1 : 0;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    public final boolean a() {
        return this._handled;
    }

    public final boolean b() {
        return a.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return t0.a(this) + '[' + this.f25646b + ']';
    }

    public /* synthetic */ CompletedExceptionally(Throwable th, boolean z, int i2, kotlin.jvm.internal.g gVar) {
        this(th, (i2 & 2) != 0 ? false : z);
    }
}
