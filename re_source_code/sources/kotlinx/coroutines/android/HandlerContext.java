package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p003y.CoroutineContext;
import kotlin.ranges.l;
import kotlin.u;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Delay;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.b2;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.android.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: HandlerDispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002J\u001c\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0017\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010!\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", HttpUrl.FRAGMENT_ENCODE_SET, "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", HttpUrl.FRAGMENT_ENCODE_SET, "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "cancelOnRejection", HttpUrl.FRAGMENT_ENCODE_SET, "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dispatch", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", HttpUrl.FRAGMENT_ENCODE_SET, "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HandlerContext extends HandlerDispatcher implements Delay {
    private volatile HandlerContext _immediate;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Handler f25638g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f25639h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f25640i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final HandlerContext f25641j;

    /* JADX INFO: renamed from: kotlinx.coroutines.android.a$a */
    /* JADX INFO: compiled from: Runnable.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation f25642f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ HandlerContext f25643g;

        public a(CancellableContinuation cancellableContinuation, HandlerContext handlerContext) {
            this.f25642f = cancellableContinuation;
            this.f25643g = handlerContext;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f25642f.h(this.f25643g, u.a);
        }
    }

    /* JADX INFO: renamed from: kotlinx.coroutines.android.a$b */
    /* JADX INFO: compiled from: HandlerDispatcher.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends Lambda implements Function1<Throwable, u> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Runnable f25645g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Runnable runnable) {
            super(1);
            this.f25645g = runnable;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            invoke2(th);
            return u.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            HandlerContext.this.f25638g.removeCallbacks(this.f25645g);
        }
    }

    private HandlerContext(Handler handler, String str, boolean z) {
        super(null);
        this.f25638g = handler;
        this.f25639h = str;
        this.f25640i = z;
        this._immediate = z ? this : null;
        HandlerContext handlerContext = this._immediate;
        if (handlerContext == null) {
            handlerContext = new HandlerContext(handler, str, true);
            this._immediate = handlerContext;
        }
        this.f25641j = handlerContext;
    }

    private final void Z(CoroutineContext coroutineContext, Runnable runnable) {
        b2.c(coroutineContext, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        Dispatchers.b().K(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void K(CoroutineContext coroutineContext, Runnable runnable) {
        if (this.f25638g.post(runnable)) {
            return;
        }
        Z(coroutineContext, runnable);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean N(CoroutineContext coroutineContext) {
        return (this.f25640i && m.a(Looper.myLooper(), this.f25638g.getLooper())) ? false : true;
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher
    /* JADX INFO: renamed from: a0, reason: from getter and merged with bridge method [inline-methods] */
    public HandlerContext T() {
        return this.f25641j;
    }

    @Override // kotlinx.coroutines.Delay
    public void e(long j2, CancellableContinuation<? super u> cancellableContinuation) {
        a aVar = new a(cancellableContinuation, this);
        if (this.f25638g.postDelayed(aVar, l.e(j2, 4611686018427387903L))) {
            cancellableContinuation.e(new b(aVar));
        } else {
            Z(cancellableContinuation.getContext(), aVar);
        }
    }

    public boolean equals(Object other) {
        return (other instanceof HandlerContext) && ((HandlerContext) other).f25638g == this.f25638g;
    }

    public int hashCode() {
        return System.identityHashCode(this.f25638g);
    }

    @Override // kotlinx.coroutines.MainCoroutineDispatcher, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strW = W();
        if (strW != null) {
            return strW;
        }
        String string = this.f25639h;
        if (string == null) {
            string = this.f25638g.toString();
        }
        if (!this.f25640i) {
            return string;
        }
        return string + ".immediate";
    }

    public /* synthetic */ HandlerContext(Handler handler, String str, int i2, g gVar) {
        this(handler, (i2 & 2) != 0 ? null : str);
    }

    public HandlerContext(Handler handler, String str) {
        this(handler, str, false);
    }
}
