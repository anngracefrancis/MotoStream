package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.p003y.Continuation;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;

/* JADX INFO: compiled from: SimpleActor.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k<T> {
    private final CoroutineScope a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2<T, Continuation<? super u>, Object> f1145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Channel<T> f1146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f1147d;

    /* JADX INFO: compiled from: SimpleActor.kt */
    static final class a extends Lambda implements Function1<Throwable, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<Throwable, u> f1148f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ k<T> f1149g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<T, Throwable, u> f1150h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Throwable, u> function1, k<T> kVar, Function2<? super T, ? super Throwable, u> function2) {
            super(1);
            this.f1148f = function1;
            this.f1149g = kVar;
            this.f1150h = function2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            invoke2(th);
            return u.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            u uVar;
            this.f1148f.invoke(th);
            ((k) this.f1149g).f1146c.c(th);
            do {
                Object objF = ChannelResult.f(((k) this.f1149g).f1146c.a());
                if (objF == null) {
                    uVar = null;
                } else {
                    this.f1150h.invoke((T) objF, th);
                    uVar = u.a;
                }
            } while (uVar != null);
        }
    }

    /* JADX INFO: compiled from: SimpleActor.kt */
    @DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1151f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f1152g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ k<T> f1153h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(k<T> kVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f1153h = kVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new b(this.f1153h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x005a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:19:0x005b  */
        /* JADX WARN: Code duplicated, block: B:22:0x006b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:23:0x006c  */
        /* JADX WARN: Code duplicated, block: B:26:0x007a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006c -> B:24:0x006e). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.p003y.intrinsics.b.c()
                int r1 = r7.f1152g
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                kotlin.o.b(r8)
                r8 = r7
                goto L6e
            L13:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1b:
                java.lang.Object r1 = r7.f1151f
                kotlin.a0.c.p r1 = (kotlin.jvm.functions.Function2) r1
                kotlin.o.b(r8)
                r4 = r1
                r1 = r0
                r0 = r7
                goto L60
            L26:
                kotlin.o.b(r8)
                androidx.datastore.core.k<T> r8 = r7.f1153h
                java.util.concurrent.atomic.AtomicInteger r8 = androidx.datastore.core.k.c(r8)
                int r8 = r8.get()
                if (r8 <= 0) goto L37
                r8 = 1
                goto L38
            L37:
                r8 = 0
            L38:
                if (r8 == 0) goto L7d
                r8 = r7
            L3b:
                androidx.datastore.core.k<T> r1 = r8.f1153h
                kotlinx.coroutines.o0 r1 = androidx.datastore.core.k.d(r1)
                kotlinx.coroutines.p0.b(r1)
                androidx.datastore.core.k<T> r1 = r8.f1153h
                kotlin.a0.c.p r1 = androidx.datastore.core.k.a(r1)
                androidx.datastore.core.k<T> r4 = r8.f1153h
                kotlinx.coroutines.channels.f r4 = androidx.datastore.core.k.b(r4)
                r8.f1151f = r1
                r8.f1152g = r3
                java.lang.Object r4 = r4.b(r8)
                if (r4 != r0) goto L5b
                return r0
            L5b:
                r6 = r0
                r0 = r8
                r8 = r4
                r4 = r1
                r1 = r6
            L60:
                r5 = 0
                r0.f1151f = r5
                r0.f1152g = r2
                java.lang.Object r8 = r4.invoke(r8, r0)
                if (r8 != r1) goto L6c
                return r1
            L6c:
                r8 = r0
                r0 = r1
            L6e:
                androidx.datastore.core.k<T> r1 = r8.f1153h
                java.util.concurrent.atomic.AtomicInteger r1 = androidx.datastore.core.k.c(r1)
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L3b
                kotlin.u r8 = kotlin.u.a
                return r8
            L7d:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                java.lang.String r0 = r0.toString()
                r8.<init>(r0)
                goto L8a
            L89:
                throw r8
            L8a:
                goto L89
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.k.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(CoroutineScope coroutineScope, Function1<? super Throwable, u> function1, Function2<? super T, ? super Throwable, u> function2, Function2<? super T, ? super Continuation<? super u>, ? extends Object> function3) {
        kotlin.jvm.internal.m.f(coroutineScope, "scope");
        kotlin.jvm.internal.m.f(function1, "onComplete");
        kotlin.jvm.internal.m.f(function2, "onUndeliveredElement");
        kotlin.jvm.internal.m.f(function3, "consumeMessage");
        this.a = coroutineScope;
        this.f1145b = function3;
        this.f1146c = kotlinx.coroutines.channels.g.b(Integer.MAX_VALUE, null, null, 6, null);
        this.f1147d = new AtomicInteger(0);
        Job job = (Job) coroutineScope.getF25795f().get(Job.f25890e);
        if (job == null) {
            return;
        }
        job.m(new a(function1, this, function2));
    }

    public final void e(T t) throws Throwable {
        Object objD = this.f1146c.d(t);
        if (objD instanceof ChannelResult.Closed) {
            Throwable thE = ChannelResult.e(objD);
            if (thE != null) {
                throw thE;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (!ChannelResult.h(objD)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (this.f1147d.getAndIncrement() == 0) {
            kotlinx.coroutines.j.b(this.a, null, null, new b(this, null), 3, null);
        }
    }
}
