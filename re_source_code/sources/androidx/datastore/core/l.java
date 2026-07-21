package androidx.datastore.core;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.p005z2.Flow;
import kotlinx.coroutines.p005z2.FlowCollector;
import kotlinx.coroutines.p005z2.MutableStateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.y;

/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
public final class l<T> implements androidx.datastore.core.e<T> {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f1154b = new LinkedHashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f1155c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0<File> f1156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final androidx.datastore.core.j<T> f1157e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final androidx.datastore.core.a<T> f1158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineScope f1159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Flow<T> f1160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f1161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f1162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableStateFlow<androidx.datastore.core.m<T>> f1163k;
    private List<? extends Function2<? super androidx.datastore.core.h<T>, ? super Continuation<? super u>, ? extends Object>> l;
    private final androidx.datastore.core.k<b<T>> m;

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Set<String> a() {
            return l.f1154b;
        }

        public final Object b() {
            return l.f1155c;
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    private static abstract class b<T> {

        /* JADX INFO: compiled from: SingleProcessDataStore.kt */
        public static final class a<T> extends b<T> {
            private final androidx.datastore.core.m<T> a;

            public a(androidx.datastore.core.m<T> mVar) {
                super(null);
                this.a = mVar;
            }

            public androidx.datastore.core.m<T> a() {
                return this.a;
            }
        }

        /* JADX INFO: renamed from: androidx.datastore.core.l$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SingleProcessDataStore.kt */
        public static final class C0029b<T> extends b<T> {
            private final Function2<T, Continuation<? super T>, Object> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final CompletableDeferred<T> f1164b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final androidx.datastore.core.m<T> f1165c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final CoroutineContext f1166d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0029b(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CompletableDeferred<T> completableDeferred, androidx.datastore.core.m<T> mVar, CoroutineContext coroutineContext) {
                super(null);
                kotlin.jvm.internal.m.f(function2, "transform");
                kotlin.jvm.internal.m.f(completableDeferred, "ack");
                kotlin.jvm.internal.m.f(coroutineContext, "callerContext");
                this.a = function2;
                this.f1164b = completableDeferred;
                this.f1165c = mVar;
                this.f1166d = coroutineContext;
            }

            public final CompletableDeferred<T> a() {
                return this.f1164b;
            }

            public final CoroutineContext b() {
                return this.f1166d;
            }

            public androidx.datastore.core.m<T> c() {
                return this.f1165c;
            }

            public final Function2<T, Continuation<? super T>, Object> d() {
                return this.a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    private static final class c extends OutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final FileOutputStream f1167f;

        public c(FileOutputStream fileOutputStream) {
            kotlin.jvm.internal.m.f(fileOutputStream, "fileOutputStream");
            this.f1167f = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f1167f.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            this.f1167f.write(i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            kotlin.jvm.internal.m.f(bArr, "b");
            this.f1167f.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            kotlin.jvm.internal.m.f(bArr, "bytes");
            this.f1167f.write(bArr, i2, i3);
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    static final class d extends Lambda implements Function1<Throwable, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l<T> f1168f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(l<T> lVar) {
            super(1);
            this.f1168f = lVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            invoke2(th);
            return u.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (th != null) {
                ((l) this.f1168f).f1163k.setValue(new androidx.datastore.core.g(th));
            }
            a aVar = l.a;
            Object objB = aVar.b();
            l<T> lVar = this.f1168f;
            synchronized (objB) {
                aVar.a().remove(lVar.r().getAbsolutePath());
                u uVar = u.a;
            }
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    static final class e extends Lambda implements Function2<b<T>, Throwable, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f1169f = new e();

        e() {
            super(2);
        }

        public final void b(b<T> bVar, Throwable th) {
            kotlin.jvm.internal.m.f(bVar, "msg");
            if (bVar instanceof b.C0029b) {
                CompletableDeferred<T> completableDeferredA = ((b.C0029b) bVar).a();
                if (th == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                completableDeferredA.A(th);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ u invoke(Object obj, Throwable th) {
            b((b) obj, th);
            return u.a;
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
    static final class f extends SuspendLambda implements Function2<b<T>, Continuation<? super u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1170f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f1171g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<T> f1172h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(l<T> lVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.f1172h = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(this.f1172h, continuation);
            fVar.f1171g = obj;
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b<T> bVar, Continuation<? super u> continuation) {
            return ((f) create(bVar, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f1170f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                b bVar = (b) this.f1171g;
                if (bVar instanceof b.a) {
                    this.f1170f = 1;
                    if (this.f1172h.s((b.a) bVar, this) == objC) {
                        return objC;
                    }
                } else if (bVar instanceof b.C0029b) {
                    this.f1170f = 2;
                    if (this.f1172h.t((b.C0029b) bVar, this) == objC) {
                        return objC;
                    }
                }
            } else {
                if (i2 != 1 && i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return u.a;
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
    static final class g extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1173f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f1174g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<T> f1175h;

        /* JADX INFO: compiled from: SingleProcessDataStore.kt */
        @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
        static final class a extends SuspendLambda implements Function2<androidx.datastore.core.m<T>, Continuation<? super Boolean>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f1176f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f1177g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ androidx.datastore.core.m<T> f1178h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(androidx.datastore.core.m<T> mVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f1178h = mVar;
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.f1178h, continuation);
                aVar.f1177g = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(androidx.datastore.core.m<T> mVar, Continuation<? super Boolean> continuation) {
                return ((a) create(mVar, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.p003y.intrinsics.d.c();
                if (this.f1176f != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
                androidx.datastore.core.m<T> mVar = (androidx.datastore.core.m) this.f1177g;
                androidx.datastore.core.m<T> mVar2 = this.f1178h;
                boolean z = false;
                if (!(mVar2 instanceof androidx.datastore.core.b) && !(mVar2 instanceof androidx.datastore.core.g) && mVar == mVar2) {
                    z = true;
                }
                return kotlin.p003y.j.p004a.b.a(z);
            }
        }

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        public static final class b implements Flow<T> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Flow f1179f;

            /* JADX INFO: compiled from: Collect.kt */
            public static final class a implements FlowCollector<androidx.datastore.core.m<T>> {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ FlowCollector f1180f;

                /* JADX INFO: renamed from: androidx.datastore.core.l$g$b$a$a, reason: collision with other inner class name */
                @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                public static final class C0030a extends ContinuationImpl {

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    /* synthetic */ Object f1181f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    int f1182g;

                    public C0030a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f1181f = obj;
                        this.f1182g |= Integer.MIN_VALUE;
                        return a.this.c(null, this);
                    }
                }

                public a(FlowCollector flowCollector) {
                    this.f1180f = flowCollector;
                }

                /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlinx.coroutines.p005z2.FlowCollector
                public Object c(Object obj, Continuation continuation) throws Throwable {
                    C0030a c0030a;
                    if (continuation instanceof C0030a) {
                        c0030a = (C0030a) continuation;
                        int i2 = c0030a.f1182g;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            c0030a.f1182g = i2 - Integer.MIN_VALUE;
                        } else {
                            c0030a = new C0030a(continuation);
                        }
                    } else {
                        c0030a = new C0030a(continuation);
                    }
                    Object obj2 = c0030a.f1181f;
                    Object objC = kotlin.p003y.intrinsics.d.c();
                    int i3 = c0030a.f1182g;
                    if (i3 == 0) {
                        kotlin.o.b(obj2);
                        FlowCollector flowCollector = this.f1180f;
                        androidx.datastore.core.m mVar = (androidx.datastore.core.m) obj;
                        if (mVar instanceof androidx.datastore.core.i) {
                            throw ((androidx.datastore.core.i) mVar).a();
                        }
                        if (mVar instanceof androidx.datastore.core.g) {
                            throw ((androidx.datastore.core.g) mVar).a();
                        }
                        if (!(mVar instanceof androidx.datastore.core.b)) {
                            if (mVar instanceof androidx.datastore.core.n) {
                                throw new IllegalStateException("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542".toString());
                            }
                            throw new NoWhenBranchMatchedException();
                        }
                        Object objB = ((androidx.datastore.core.b) mVar).b();
                        c0030a.f1182g = 1;
                        if (flowCollector.c(objB, c0030a) == objC) {
                            return objC;
                        }
                    } else {
                        if (i3 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kotlin.o.b(obj2);
                    }
                    return u.a;
                }
            }

            public b(Flow flow) {
                this.f1179f = flow;
            }

            @Override // kotlinx.coroutines.p005z2.Flow
            public Object a(FlowCollector flowCollector, Continuation continuation) {
                Object objA = this.f1179f.a(new a(flowCollector), continuation);
                return objA == kotlin.p003y.intrinsics.d.c() ? objA : u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(l<T> lVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.f1175h = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            g gVar = new g(this.f1175h, continuation);
            gVar.f1174g = obj;
            return gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation) {
            return ((g) create(flowCollector, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f1173f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.f1174g;
                androidx.datastore.core.m mVar = (androidx.datastore.core.m) ((l) this.f1175h).f1163k.getValue();
                if (!(mVar instanceof androidx.datastore.core.b)) {
                    ((l) this.f1175h).m.e(new b.a(mVar));
                }
                b bVar = new b(kotlinx.coroutines.p005z2.d.c(((l) this.f1175h).f1163k, new a(mVar, null)));
                this.f1173f = 1;
                if (kotlinx.coroutines.p005z2.d.d(flowCollector, bVar, this) == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return u.a;
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    static final class h extends Lambda implements Function0<File> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ l<T> f1184f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(l<T> lVar) {
            super(0);
            this.f1184f = lVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File file = (File) ((l) this.f1184f).f1156d.invoke();
            String absolutePath = file.getAbsolutePath();
            a aVar = l.a;
            synchronized (aVar.b()) {
                if (!(!aVar.a().contains(absolutePath))) {
                    throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                }
                Set<String> setA = aVar.a();
                kotlin.jvm.internal.m.e(absolutePath, "it");
                setA.add(absolutePath);
            }
            return file;
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
    static final class i extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1185f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1186g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f1187h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1188i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ l<T> f1189j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f1190k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(l<T> lVar, Continuation<? super i> continuation) {
            super(continuation);
            this.f1189j = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1188i = obj;
            this.f1190k |= Integer.MIN_VALUE;
            return this.f1189j.t(null, this);
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, 505}, m = "readAndInit")
    static final class j extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1191f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1192g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f1193h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f1194i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f1195j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f1196k;
        /* synthetic */ Object l;
        final /* synthetic */ l<T> m;
        int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(l<T> lVar, Continuation<? super j> continuation) {
            super(continuation);
            this.m = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.l = obj;
            this.n |= Integer.MIN_VALUE;
            return this.m.u(this);
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    public static final class k implements androidx.datastore.core.h<T> {
        final /* synthetic */ Mutex a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c0 f1197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f0<T> f1198c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ l<T> f1199d;

        /* JADX INFO: compiled from: SingleProcessDataStore.kt */
        @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {503, 337, 339}, m = "updateData")
        static final class a extends ContinuationImpl {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            Object f1200f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            Object f1201g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            Object f1202h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            Object f1203i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f1204j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ Object f1205k;
            int m;

            a(Continuation<? super a> continuation) {
                super(continuation);
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f1205k = obj;
                this.m |= Integer.MIN_VALUE;
                return k.this.a(null, this);
            }
        }

        k(Mutex mutex, c0 c0Var, f0<T> f0Var, l<T> lVar) {
            this.a = mutex;
            this.f1197b = c0Var;
            this.f1198c = f0Var;
            this.f1199d = lVar;
        }

        /* JADX WARN: Code duplicated, block: B:38:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:21:0x0052, B:36:0x00b2, B:38:0x00ba), top: B:53:0x0052 }] */
        /* JADX WARN: Code duplicated, block: B:40:0x00c8 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:41:0x00c9  */
        /* JADX WARN: Code duplicated, block: B:43:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        @Override // androidx.datastore.core.h
        public Object a(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
            a aVar;
            Mutex mutex;
            l lVar;
            c0 c0Var;
            f0<T> f0Var;
            Mutex mutex2;
            Mutex mutex3;
            l lVar2;
            T t;
            f0<T> f0Var2;
            if (continuation instanceof a) {
                aVar = (a) continuation;
                int i2 = aVar.m;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    aVar.m = i2 - Integer.MIN_VALUE;
                } else {
                    aVar = new a(continuation);
                }
            } else {
                aVar = new a(continuation);
            }
            Object obj = aVar.f1205k;
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i3 = aVar.m;
            try {
                if (i3 == 0) {
                    kotlin.o.b(obj);
                    mutex = this.a;
                    c0 c0Var2 = this.f1197b;
                    f0<T> f0Var3 = this.f1198c;
                    lVar = this.f1199d;
                    aVar.f1200f = function2;
                    aVar.f1201g = mutex;
                    aVar.f1202h = c0Var2;
                    aVar.f1203i = f0Var3;
                    aVar.f1204j = lVar;
                    aVar.m = 1;
                    if (mutex.b(null, aVar) == objC) {
                        return objC;
                    }
                    c0Var = c0Var2;
                    f0Var = f0Var3;
                } else {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            t = (T) aVar.f1202h;
                            f0Var2 = (f0) aVar.f1201g;
                            mutex2 = (Mutex) aVar.f1200f;
                            try {
                                kotlin.o.b(obj);
                                f0Var2.f22943f = t;
                                f0Var = f0Var2;
                                T t2 = f0Var.f22943f;
                                mutex2.c(null);
                                return t2;
                            } catch (Throwable th) {
                                th = th;
                                mutex2.c(null);
                                throw th;
                            }
                        }
                        l lVar3 = (l) aVar.f1202h;
                        f0Var = (f0) aVar.f1201g;
                        mutex3 = (Mutex) aVar.f1200f;
                        try {
                            kotlin.o.b(obj);
                            lVar2 = lVar3;
                            if (kotlin.jvm.internal.m.a(obj, f0Var.f22943f)) {
                                mutex2 = mutex3;
                            } else {
                                aVar.f1200f = mutex3;
                                aVar.f1201g = f0Var;
                                aVar.f1202h = obj;
                                aVar.m = 3;
                                if (lVar2.A(obj, aVar) == objC) {
                                    return objC;
                                }
                                t = (T) obj;
                                f0Var2 = f0Var;
                                mutex2 = mutex3;
                                f0Var2.f22943f = t;
                                f0Var = f0Var2;
                            }
                            T t3 = f0Var.f22943f;
                            mutex2.c(null);
                            return t3;
                        } catch (Throwable th2) {
                            th = th2;
                            mutex2 = mutex3;
                            mutex2.c(null);
                            throw th;
                        }
                    }
                    l lVar4 = (l) aVar.f1204j;
                    f0Var = (f0) aVar.f1203i;
                    c0Var = (c0) aVar.f1202h;
                    Mutex mutex4 = (Mutex) aVar.f1201g;
                    Function2<? super T, ? super Continuation<? super T>, ? extends Object> function3 = (Function2) aVar.f1200f;
                    kotlin.o.b(obj);
                    mutex = mutex4;
                    lVar = lVar4;
                    function2 = function3;
                }
                if (c0Var.f22934f) {
                    throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
                }
                T t4 = f0Var.f22943f;
                aVar.f1200f = mutex;
                aVar.f1201g = f0Var;
                aVar.f1202h = lVar;
                aVar.f1203i = null;
                aVar.f1204j = null;
                aVar.m = 2;
                Object objInvoke = function2.invoke(t4, aVar);
                if (objInvoke == objC) {
                    return objC;
                }
                mutex3 = mutex;
                obj = objInvoke;
                lVar2 = lVar;
                if (kotlin.jvm.internal.m.a(obj, f0Var.f22943f)) {
                    aVar.f1200f = mutex3;
                    aVar.f1201g = f0Var;
                    aVar.f1202h = obj;
                    aVar.m = 3;
                    if (lVar2.A(obj, aVar) == objC) {
                        return objC;
                    }
                    t = (T) obj;
                    f0Var2 = f0Var;
                    mutex2 = mutex3;
                    f0Var2.f22943f = t;
                    f0Var = f0Var2;
                } else {
                    mutex2 = mutex3;
                }
                T t5 = f0Var.f22943f;
                mutex2.c(null);
                return t5;
            } catch (Throwable th3) {
                th = th3;
                mutex2 = mutex;
                mutex2.c(null);
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: androidx.datastore.core.l$l, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {302}, m = "readAndInitOrPropagateAndThrowFailure")
    static final class C0031l extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1206f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f1207g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<T> f1208h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f1209i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0031l(l<T> lVar, Continuation<? super C0031l> continuation) {
            super(continuation);
            this.f1208h = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1207g = obj;
            this.f1209i |= Integer.MIN_VALUE;
            return this.f1208h.v(this);
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
    static final class m extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1210f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f1211g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<T> f1212h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f1213i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(l<T> lVar, Continuation<? super m> continuation) {
            super(continuation);
            this.f1212h = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1211g = obj;
            this.f1213i |= Integer.MIN_VALUE;
            return this.f1212h.w(this);
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
    static final class n extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1214f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1215g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f1216h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1217i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ l<T> f1218j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f1219k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(l<T> lVar, Continuation<? super n> continuation) {
            super(continuation);
            this.f1218j = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1217i = obj;
            this.f1219k |= Integer.MIN_VALUE;
            return this.f1218j.x(this);
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
    static final class o extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1220f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1221g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f1222h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ l<T> f1223i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f1224j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(l<T> lVar, Continuation<? super o> continuation) {
            super(continuation);
            this.f1223i = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1222h = obj;
            this.f1224j |= Integer.MIN_VALUE;
            return this.f1223i.y(this);
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {402, 410}, m = "transformAndWrite")
    static final class p extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1225f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1226g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f1227h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1228i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ l<T> f1229j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f1230k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(l<T> lVar, Continuation<? super p> continuation) {
            super(continuation);
            this.f1229j = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1228i = obj;
            this.f1230k |= Integer.MIN_VALUE;
            return this.f1229j.z(null, null, this);
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
    static final class q extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f1231f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function2<T, Continuation<? super T>, Object> f1232g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ T f1233h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        q(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, T t, Continuation<? super q> continuation) {
            super(2, continuation);
            this.f1232g = function2;
            this.f1233h = t;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new q(this.f1232g, this.f1233h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((q) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f1231f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                Function2<T, Continuation<? super T>, Object> function2 = this.f1232g;
                T t = this.f1233h;
                this.f1231f = 1;
                obj = function2.invoke(t, this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
    static final class r extends ContinuationImpl {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Object f1234f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f1235g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Object f1236h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        Object f1237i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f1238j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f1239k;
        final /* synthetic */ l<T> l;
        int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(l<T> lVar, Continuation<? super r> continuation) {
            super(continuation);
            this.l = lVar;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1239k = obj;
            this.m |= Integer.MIN_VALUE;
            return this.l.A(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function0<? extends File> function0, androidx.datastore.core.j<T> jVar, List<? extends Function2<? super androidx.datastore.core.h<T>, ? super Continuation<? super u>, ? extends Object>> list, androidx.datastore.core.a<T> aVar, CoroutineScope coroutineScope) {
        kotlin.jvm.internal.m.f(function0, "produceFile");
        kotlin.jvm.internal.m.f(jVar, "serializer");
        kotlin.jvm.internal.m.f(list, "initTasksList");
        kotlin.jvm.internal.m.f(aVar, "corruptionHandler");
        kotlin.jvm.internal.m.f(coroutineScope, "scope");
        this.f1156d = function0;
        this.f1157e = jVar;
        this.f1158f = aVar;
        this.f1159g = coroutineScope;
        this.f1160h = kotlinx.coroutines.p005z2.d.g(new g(this, null));
        this.f1161i = ".tmp";
        this.f1162j = kotlin.i.b(new h(this));
        this.f1163k = kotlinx.coroutines.p005z2.o.a(androidx.datastore.core.n.a);
        this.l = kotlin.collections.c0.E0(list);
        this.m = new androidx.datastore.core.k<>(coroutineScope, new d(this), e.f1169f, new f(this, null));
    }

    private final void q(File file) throws IOException {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(kotlin.jvm.internal.m.n("Unable to create parent directories of ", file));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File r() {
        return (File) this.f1162j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(b.a<T> aVar, Continuation<? super u> continuation) throws Throwable {
        androidx.datastore.core.m<T> value = this.f1163k.getValue();
        if (!(value instanceof androidx.datastore.core.b)) {
            if (value instanceof androidx.datastore.core.i) {
                if (value == aVar.a()) {
                    Object objW = w(continuation);
                    return objW == kotlin.p003y.intrinsics.d.c() ? objW : u.a;
                }
            } else {
                if (kotlin.jvm.internal.m.a(value, androidx.datastore.core.n.a)) {
                    Object objW2 = w(continuation);
                    return objW2 == kotlin.p003y.intrinsics.d.c() ? objW2 : u.a;
                }
                if (value instanceof androidx.datastore.core.g) {
                    throw new IllegalStateException("Can't read in final state.".toString());
                }
            }
        }
        return u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.l, androidx.datastore.core.l<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v0, types: [androidx.datastore.core.l$b$b, androidx.datastore.core.l$b$b<T>, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15, types: [androidx.datastore.core.l$b$b] */
    /* JADX WARN: Type inference failed for: r9v18 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlinx.coroutines.w] */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v35 */
    /* JADX WARN: Type inference failed for: r9v36 */
    /* JADX WARN: Type inference failed for: r9v6 */
    public final Object t(b.C0029b<T> c0029b, Continuation<? super u> continuation) throws Throwable {
        i iVar;
        Object objA;
        ?? r9;
        CompletableDeferred completableDeferredA;
        ?? r2;
        Object objZ;
        ?? r10;
        CompletableDeferred completableDeferred;
        if (continuation instanceof i) {
            iVar = (i) continuation;
            int i2 = iVar.f1190k;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                iVar.f1190k = i2 - Integer.MIN_VALUE;
            } else {
                iVar = new i(this, continuation);
            }
        } else {
            iVar = new i(this, continuation);
        }
        Object obj = iVar.f1188i;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = iVar.f1190k;
        boolean z = true;
        try {
            if (i3 != 0) {
                if (i3 == 1) {
                    completableDeferred = (CompletableDeferred) iVar.f1185f;
                } else if (i3 == 2) {
                    CompletableDeferred completableDeferred2 = (CompletableDeferred) iVar.f1187h;
                    l lVar = (l) iVar.f1186g;
                    b.C0029b c0029b2 = (b.C0029b) iVar.f1185f;
                    kotlin.o.b(obj);
                    completableDeferredA = completableDeferred2;
                    r2 = lVar;
                    r10 = (b.C0029b<T>) c0029b2;
                } else {
                    if (i3 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    completableDeferred = (b.C0029b<T>) ((CompletableDeferred) iVar.f1185f);
                }
                kotlin.o.b(obj);
                c0029b = completableDeferred;
                objA = Result.a(obj);
                r9 = c0029b;
                y.c(r9, objA);
                return u.a;
            }
            kotlin.o.b(obj);
            completableDeferredA = c0029b.a();
            try {
                Result.a aVar = Result.f25108f;
                androidx.datastore.core.m<T> value = this.f1163k.getValue();
                if (value instanceof androidx.datastore.core.b) {
                    Function2 function2D = c0029b.d();
                    CoroutineContext coroutineContextB = c0029b.b();
                    iVar.f1185f = completableDeferredA;
                    iVar.f1190k = 1;
                    objZ = z(function2D, coroutineContextB, iVar);
                    if (objZ == objC) {
                        return objC;
                    }
                } else {
                    if (!(value instanceof androidx.datastore.core.i)) {
                        z = value instanceof androidx.datastore.core.n;
                    }
                    if (!z) {
                        if (value instanceof androidx.datastore.core.g) {
                            throw ((androidx.datastore.core.g) value).a();
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                    if (value != c0029b.c()) {
                        throw ((androidx.datastore.core.i) value).a();
                    }
                    iVar.f1185f = c0029b;
                    iVar.f1186g = this;
                    iVar.f1187h = completableDeferredA;
                    iVar.f1190k = 2;
                    if (v(iVar) == objC) {
                        return objC;
                    }
                    r2 = this;
                    r10 = c0029b;
                }
                CompletableDeferred completableDeferred3 = completableDeferredA;
                obj = objZ;
                c0029b = completableDeferred3;
                objA = Result.a(obj);
                r9 = c0029b;
            } catch (Throwable th) {
                th = th;
                c0029b = completableDeferredA;
                Result.a aVar2 = Result.f25108f;
                objA = Result.a(kotlin.o.a(th));
                r9 = c0029b;
            }
            y.c(r9, objA);
            return u.a;
            Function2 function2D2 = r10.d();
            CoroutineContext coroutineContextB2 = r10.b();
            iVar.f1185f = completableDeferredA;
            iVar.f1186g = null;
            iVar.f1187h = null;
            iVar.f1190k = 3;
            objZ = r2.z(function2D2, coroutineContextB2, iVar);
            if (objZ == objC) {
                return objC;
            }
            CompletableDeferred completableDeferred4 = completableDeferredA;
            obj = objZ;
            c0029b = completableDeferred4;
            objA = Result.a(obj);
            r9 = c0029b;
        } catch (Throwable th2) {
            th = th2;
        }
        y.c(r9, objA);
        return u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x00de  */
    /* JADX WARN: Code duplicated, block: B:42:0x0114 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x0115  */
    /* JADX WARN: Code duplicated, block: B:47:0x0126  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[LOOP:0: B:34:0x00d8->B:61:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.datastore.core.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r13v0, types: [androidx.datastore.core.l, androidx.datastore.core.l<T>, java.lang.Object] */
    public final Object u(Continuation<? super u> continuation) throws Throwable {
        j jVar;
        Mutex mutexB;
        f0 f0Var;
        ?? r10;
        f0 f0Var2;
        ?? r12;
        f0 f0Var3;
        k kVar;
        Iterator<T> it;
        Mutex mutex;
        c0 c0Var;
        Mutex mutex2;
        ?? r0;
        f0 f0Var4;
        c0 c0Var2;
        Function2 function2;
        ?? r1;
        if (continuation instanceof j) {
            jVar = (j) continuation;
            int i2 = jVar.n;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                jVar.n = i2 - Integer.MIN_VALUE;
            } else {
                jVar = new j(this, continuation);
            }
        } else {
            jVar = new j(this, continuation);
        }
        T t = (T) jVar.l;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = jVar.n;
        if (i3 != 0) {
            if (i3 == 1) {
                f0Var = (f0) jVar.f1194i;
                f0Var2 = (f0) jVar.f1193h;
                mutexB = (Mutex) jVar.f1192g;
                l lVar = (l) jVar.f1191f;
                kotlin.o.b(t);
                r10 = lVar;
            } else if (i3 == 2) {
                it = (Iterator) jVar.f1196k;
                kVar = (k) jVar.f1195j;
                c0Var = (c0) jVar.f1194i;
                f0Var3 = (f0) jVar.f1193h;
                mutex = (Mutex) jVar.f1192g;
                l lVar2 = (l) jVar.f1191f;
                kotlin.o.b(t);
                r12 = lVar2;
                while (it.hasNext()) {
                    function2 = (Function2) it.next();
                    jVar.f1191f = r12;
                    jVar.f1192g = mutex;
                    jVar.f1193h = f0Var3;
                    jVar.f1194i = c0Var;
                    jVar.f1195j = kVar;
                    jVar.f1196k = it;
                    jVar.n = 2;
                    if (function2.invoke(kVar, jVar) == objC) {
                        return objC;
                    }
                }
                f0Var2 = f0Var3;
                mutex2 = mutex;
                r0 = r12;
                r0.l = null;
                jVar.f1191f = r0;
                jVar.f1192g = f0Var2;
                jVar.f1193h = c0Var;
                jVar.f1194i = mutex2;
                jVar.f1195j = null;
                jVar.f1196k = null;
                jVar.n = 3;
                if (mutex2.b(null, jVar) == objC) {
                    return objC;
                }
                f0Var4 = f0Var2;
                c0Var2 = c0Var;
                r1 = r0;
            } else {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mutex2 = (Mutex) jVar.f1194i;
                c0Var2 = (c0) jVar.f1193h;
                f0Var4 = (f0) jVar.f1192g;
                l lVar3 = (l) jVar.f1191f;
                kotlin.o.b(t);
                r1 = lVar3;
            }
            try {
                c0Var2.f22934f = true;
                u uVar = u.a;
                mutex2.c(null);
                MutableStateFlow<androidx.datastore.core.m<T>> mutableStateFlow = r1.f1163k;
                T t2 = f0Var4.f22943f;
                mutableStateFlow.setValue(new androidx.datastore.core.b(t2, t2 != null ? t2.hashCode() : 0));
                return uVar;
            } catch (Throwable th) {
                mutex2.c(null);
                throw th;
            }
        }
        kotlin.o.b(t);
        if (!(kotlin.jvm.internal.m.a(this.f1163k.getValue(), androidx.datastore.core.n.a) || (this.f1163k.getValue() instanceof androidx.datastore.core.i))) {
            throw new IllegalStateException("Check failed.".toString());
        }
        mutexB = kotlinx.coroutines.sync.d.b(false, 1, null);
        f0Var = new f0();
        jVar.f1191f = this;
        jVar.f1192g = mutexB;
        jVar.f1193h = f0Var;
        jVar.f1194i = f0Var;
        jVar.n = 1;
        t = (T) y(jVar);
        if (t == objC) {
            return objC;
        }
        r10 = this;
        f0Var2 = f0Var;
        f0Var.f22943f = t;
        c0 c0Var3 = new c0();
        k kVar2 = new k(mutexB, c0Var3, f0Var2, r10);
        List<? extends Function2<? super androidx.datastore.core.h<T>, ? super Continuation<? super u>, ? extends Object>> list = r10.l;
        if (list == null) {
            mutex2 = mutexB;
            c0Var = c0Var3;
            r0 = r10;
        } else {
            r12 = r10;
            f0Var3 = f0Var2;
            kVar = kVar2;
            it = list.iterator();
            mutex = mutexB;
            c0Var = c0Var3;
            while (it.hasNext()) {
                function2 = (Function2) it.next();
                jVar.f1191f = r12;
                jVar.f1192g = mutex;
                jVar.f1193h = f0Var3;
                jVar.f1194i = c0Var;
                jVar.f1195j = kVar;
                jVar.f1196k = it;
                jVar.n = 2;
                if (function2.invoke(kVar, jVar) == objC) {
                    return objC;
                }
            }
            f0Var2 = f0Var3;
            mutex2 = mutex;
            r0 = r12;
        }
        r0.l = null;
        jVar.f1191f = r0;
        jVar.f1192g = f0Var2;
        jVar.f1193h = c0Var;
        jVar.f1194i = mutex2;
        jVar.f1195j = null;
        jVar.f1196k = null;
        jVar.n = 3;
        if (mutex2.b(null, jVar) == objC) {
            return objC;
        }
        f0Var4 = f0Var2;
        c0Var2 = c0Var;
        r1 = r0;
        c0Var2.f22934f = true;
        u uVar2 = u.a;
        mutex2.c(null);
        MutableStateFlow<androidx.datastore.core.m<T>> mutableStateFlow2 = r1.f1163k;
        T t3 = f0Var4.f22943f;
        mutableStateFlow2.setValue(new androidx.datastore.core.b(t3, t3 != null ? t3.hashCode() : 0));
        return uVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object v(Continuation<? super u> continuation) throws Throwable {
        C0031l c0031l;
        l lVar;
        if (continuation instanceof C0031l) {
            c0031l = (C0031l) continuation;
            int i2 = c0031l.f1209i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c0031l.f1209i = i2 - Integer.MIN_VALUE;
            } else {
                c0031l = new C0031l(this, continuation);
            }
        } else {
            c0031l = new C0031l(this, continuation);
        }
        Object obj = c0031l.f1207g;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = c0031l.f1209i;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lVar = (l) c0031l.f1206f;
            try {
                kotlin.o.b(obj);
                return u.a;
            } catch (Throwable th) {
                th = th;
                lVar.f1163k.setValue(new androidx.datastore.core.i(th));
                throw th;
            }
        }
        kotlin.o.b(obj);
        try {
            c0031l.f1206f = this;
            c0031l.f1209i = 1;
            if (u(c0031l) == objC) {
                return objC;
            }
            return u.a;
        } catch (Throwable th2) {
            th = th2;
            lVar = this;
            lVar.f1163k.setValue(new androidx.datastore.core.i(th));
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object w(Continuation<? super u> continuation) throws Throwable {
        m mVar;
        l lVar;
        if (continuation instanceof m) {
            mVar = (m) continuation;
            int i2 = mVar.f1213i;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                mVar.f1213i = i2 - Integer.MIN_VALUE;
            } else {
                mVar = new m(this, continuation);
            }
        } else {
            mVar = new m(this, continuation);
        }
        Object obj = mVar.f1211g;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = mVar.f1213i;
        if (i3 == 0) {
            kotlin.o.b(obj);
            try {
                mVar.f1210f = this;
                mVar.f1213i = 1;
                if (u(mVar) == objC) {
                    return objC;
                }
            } catch (Throwable th) {
                th = th;
                lVar = this;
                lVar.f1163k.setValue(new androidx.datastore.core.i(th));
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lVar = (l) mVar.f1210f;
            try {
                kotlin.o.b(obj);
            } catch (Throwable th2) {
                th = th2;
                lVar.f1163k.setValue(new androidx.datastore.core.i(th));
            }
        }
        return u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.core.l$n, kotlin.y.d] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream, java.io.InputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.datastore.core.j, androidx.datastore.core.j<T>] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object x(Continuation<? super T> continuation) throws Throwable {
        ?? nVar;
        ?? fileInputStream;
        Throwable th;
        ?? r2;
        if (continuation instanceof n) {
            n nVar2 = (n) continuation;
            int i2 = nVar2.f1219k;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                nVar2.f1219k = i2 - Integer.MIN_VALUE;
                nVar = nVar2;
            } else {
                nVar = new n(this, continuation);
            }
        } else {
            nVar = new n(this, continuation);
        }
        Object obj = nVar.f1217i;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = nVar.f1219k;
        try {
            if (i3 != 0) {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) nVar.f1216h;
                fileInputStream = (Closeable) nVar.f1215g;
                nVar = (l) nVar.f1214f;
                try {
                    kotlin.o.b(obj);
                    r2 = fileInputStream;
                    kotlin.io.a.a(r2, th);
                    return obj;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        kotlin.io.a.a(fileInputStream, th);
                        throw th3;
                    }
                }
            }
            kotlin.o.b(obj);
            try {
                fileInputStream = new FileInputStream(r());
                try {
                    androidx.datastore.core.j<T> jVar = this.f1157e;
                    nVar.f1214f = this;
                    nVar.f1215g = fileInputStream;
                    nVar.f1216h = null;
                    nVar.f1219k = 1;
                    Object objC2 = jVar.c(fileInputStream, nVar);
                    if (objC2 == objC) {
                        return objC;
                    }
                    th = null;
                    obj = objC2;
                    r2 = fileInputStream;
                    kotlin.io.a.a(r2, th);
                    return obj;
                } catch (Throwable th4) {
                    th = th4;
                    nVar = this;
                    throw th;
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                nVar = this;
                if (nVar.r().exists()) {
                    throw e;
                }
                return nVar.f1157e.a();
            }
        } catch (FileNotFoundException e3) {
            e = e3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:35:0x0074 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x0085 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x0086  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [androidx.datastore.core.l, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r7v0, types: [androidx.datastore.core.l, androidx.datastore.core.l<T>, java.lang.Object] */
    public final Object y(Continuation<? super T> continuation) throws Throwable {
        o oVar;
        ?? r2;
        Object objA;
        CorruptionException corruptionException;
        ?? r4;
        CorruptionException corruptionException2;
        if (continuation instanceof o) {
            oVar = (o) continuation;
            int i2 = oVar.f1224j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                oVar.f1224j = i2 - Integer.MIN_VALUE;
            } else {
                oVar = new o(this, continuation);
            }
        } else {
            oVar = new o(this, continuation);
        }
        Object objX = oVar.f1222h;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = oVar.f1224j;
        if (i3 == 0) {
            kotlin.o.b(objX);
            try {
                oVar.f1220f = this;
                oVar.f1224j = 1;
                objX = x(oVar);
                return objX == objC ? objC : objX;
            } catch (CorruptionException e2) {
                e = e2;
                r2 = this;
                androidx.datastore.core.a<T> aVar = r2.f1158f;
                oVar.f1220f = r2;
                oVar.f1221g = e;
                oVar.f1224j = 2;
                objA = aVar.a(e, oVar);
                if (objA == objC) {
                    return objC;
                }
                ?? r6 = r2;
                corruptionException = e;
                objX = objA;
                r4 = r6;
                oVar.f1220f = corruptionException;
                oVar.f1221g = objX;
                oVar.f1224j = 3;
                if (r4.A(objX, oVar) == objC) {
                    return objC;
                }
                return objX;
            }
        }
        if (i3 != 1) {
            if (i3 == 2) {
                corruptionException = (CorruptionException) oVar.f1221g;
                l lVar = (l) oVar.f1220f;
                kotlin.o.b(objX);
                r4 = lVar;
            } else {
                if (i3 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj = oVar.f1221g;
                corruptionException2 = (CorruptionException) oVar.f1220f;
                try {
                    kotlin.o.b(objX);
                    return obj;
                } catch (IOException e3) {
                    e = e3;
                }
            }
            kotlin.b.a(corruptionException2, e);
            throw corruptionException2;
        }
        r2 = (l) oVar.f1220f;
        try {
            kotlin.o.b(objX);
        } catch (CorruptionException e4) {
            e = e4;
            androidx.datastore.core.a<T> aVar2 = r2.f1158f;
            oVar.f1220f = r2;
            oVar.f1221g = e;
            oVar.f1224j = 2;
            objA = aVar2.a(e, oVar);
            if (objA == objC) {
                return objC;
            }
            ?? r7 = r2;
            corruptionException = e;
            objX = objA;
            r4 = r7;
            oVar.f1220f = corruptionException;
            oVar.f1221g = objX;
            oVar.f1224j = 3;
            if (r4.A(objX, oVar) == objC) {
                return objC;
            }
            return objX;
        }
        try {
            oVar.f1220f = corruptionException;
            oVar.f1221g = objX;
            oVar.f1224j = 3;
            if (r4.A(objX, oVar) == objC) {
                return objC;
            }
            return objX;
        } catch (IOException e5) {
            e = e5;
            corruptionException2 = corruptionException;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:29:0x0094  */
    /* JADX WARN: Code duplicated, block: B:30:0x0099  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object z(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) throws Throwable {
        p pVar;
        androidx.datastore.core.b bVar;
        Object obj;
        l lVar;
        l lVar2;
        int iHashCode;
        if (continuation instanceof p) {
            pVar = (p) continuation;
            int i2 = pVar.f1230k;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pVar.f1230k = i2 - Integer.MIN_VALUE;
            } else {
                pVar = new p(this, continuation);
            }
        } else {
            pVar = new p(this, continuation);
        }
        Object obj2 = pVar.f1228i;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = pVar.f1230k;
        if (i3 != 0) {
            if (i3 == 1) {
                obj = pVar.f1227h;
                bVar = (androidx.datastore.core.b) pVar.f1226g;
                l lVar3 = (l) pVar.f1225f;
                kotlin.o.b(obj2);
                lVar = lVar3;
            } else {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                obj = pVar.f1226g;
                l lVar4 = (l) pVar.f1225f;
                kotlin.o.b(obj2);
                lVar2 = lVar4;
            }
            MutableStateFlow<androidx.datastore.core.m<T>> mutableStateFlow = lVar2.f1163k;
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            mutableStateFlow.setValue(new androidx.datastore.core.b(obj, iHashCode));
            return obj;
        }
        kotlin.o.b(obj2);
        androidx.datastore.core.b bVar2 = (androidx.datastore.core.b) this.f1163k.getValue();
        bVar2.a();
        Object objB = bVar2.b();
        q qVar = new q(function2, objB, null);
        pVar.f1225f = this;
        pVar.f1226g = bVar2;
        pVar.f1227h = objB;
        pVar.f1230k = 1;
        Object objE = kotlinx.coroutines.h.e(coroutineContext, qVar, pVar);
        if (objE == objC) {
            return objC;
        }
        bVar = bVar2;
        obj2 = objE;
        obj = objB;
        lVar = this;
        bVar.a();
        if (!kotlin.jvm.internal.m.a(obj, obj2)) {
            pVar.f1225f = lVar;
            pVar.f1226g = obj2;
            pVar.f1227h = null;
            pVar.f1230k = 2;
            if (lVar.A(obj2, pVar) == objC) {
                return objC;
            }
            obj = obj2;
            lVar2 = lVar;
            MutableStateFlow<androidx.datastore.core.m<T>> mutableStateFlow2 = lVar2.f1163k;
            if (obj != null) {
                iHashCode = obj.hashCode();
            } else {
                iHashCode = 0;
            }
            mutableStateFlow2.setValue(new androidx.datastore.core.b(obj, iHashCode));
        }
        return obj;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v9, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.io.File, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.StringBuilder] */
    public final Object A(T t, Continuation<? super u> continuation) throws Throwable {
        r rVar;
        ?? file;
        ?? fileOutputStream;
        l<T> lVar;
        ?? r8;
        Throwable th;
        if (continuation instanceof r) {
            rVar = (r) continuation;
            int i2 = rVar.m;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                rVar.m = i2 - Integer.MIN_VALUE;
            } else {
                rVar = new r(this, continuation);
            }
        } else {
            rVar = new r(this, continuation);
        }
        Object obj = rVar.f1239k;
        Object objC = kotlin.p003y.intrinsics.d.c();
        int i3 = rVar.m;
        ?? r3 = 1;
        try {
            if (i3 == 0) {
                kotlin.o.b(obj);
                q(r());
                file = new File(kotlin.jvm.internal.m.n(r().getAbsolutePath(), this.f1161i));
                try {
                    fileOutputStream = new FileOutputStream((File) file);
                    try {
                        androidx.datastore.core.j<T> jVar = this.f1157e;
                        c cVar = new c(fileOutputStream);
                        rVar.f1234f = this;
                        rVar.f1235g = file;
                        rVar.f1236h = fileOutputStream;
                        rVar.f1237i = null;
                        rVar.f1238j = fileOutputStream;
                        rVar.m = 1;
                        if (jVar.b(t, cVar, rVar) == objC) {
                            return objC;
                        }
                        lVar = this;
                        r3 = file;
                        r8 = fileOutputStream;
                        th = null;
                        fileOutputStream = fileOutputStream;
                    } catch (Throwable th2) {
                        th = th2;
                        r3 = file;
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                    if (file.exists()) {
                        file.delete();
                    }
                    throw e;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                FileOutputStream fileOutputStream2 = (FileOutputStream) rVar.f1238j;
                th = (Throwable) rVar.f1237i;
                fileOutputStream = (Closeable) rVar.f1236h;
                r3 = (File) rVar.f1235g;
                lVar = (l) rVar.f1234f;
                try {
                    kotlin.o.b(obj);
                    fileOutputStream = fileOutputStream;
                    r3 = r3;
                    r8 = fileOutputStream2;
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        throw th;
                    } catch (Throwable th4) {
                        kotlin.io.a.a(fileOutputStream, th);
                        throw th4;
                    }
                }
            }
            r8.getFD().sync();
            u uVar = u.a;
            kotlin.io.a.a(fileOutputStream, th);
            if (r3.renameTo(lVar.r())) {
                return uVar;
            }
            throw new IOException("Unable to rename " + r3 + ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
        } catch (IOException e3) {
            e = e3;
            file = r3;
        }
    }

    @Override // androidx.datastore.core.e
    public Object a(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) throws Throwable {
        CompletableDeferred completableDeferredB = y.b(null, 1, null);
        this.m.e(new b.C0029b(function2, completableDeferredB, this.f1163k.getValue(), continuation.getL()));
        return completableDeferredB.k(continuation);
    }

    @Override // androidx.datastore.core.e
    public Flow<T> b() {
        return this.f1160h;
    }
}
