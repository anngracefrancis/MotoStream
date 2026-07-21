package com.google.firebase.sessions;

import android.content.Context;
import android.util.Log;
import androidx.datastore.core.CorruptionException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.p003y.Continuation;
import kotlin.p003y.CoroutineContext;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.p005z2.Flow;
import kotlinx.coroutines.p005z2.FlowCollector;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.x, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionDatastore.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastoreImpl;", "Lcom/google/firebase/sessions/SessionDatastore;", "context", "Landroid/content/Context;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;)V", "currentSessionFromDatastore", "Ljava/util/concurrent/atomic/AtomicReference;", "Lcom/google/firebase/sessions/FirebaseSessionsData;", "firebaseSessionDataFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentSessionId", HttpUrl.FRAGMENT_ENCODE_SET, "mapSessionsData", "preferences", "Landroidx/datastore/preferences/core/Preferences;", "updateSessionId", HttpUrl.FRAGMENT_ENCODE_SET, "sessionId", "Companion", "FirebaseSessionDataKeys", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SessionDatastoreImpl implements SessionDatastore {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final c f20095b = new c(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Deprecated
    private static final ReadOnlyProperty<Context, androidx.datastore.core.e<c.l.b.i.d>> f20096c = c.l.b.a.b(SessionDataStoreConfigs.a.a(), new androidx.datastore.core.o.b(b.f20104f), null, null, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f20097d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CoroutineContext f20098e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicReference<FirebaseSessionsData> f20099f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Flow<FirebaseSessionsData> f20100g;

    /* JADX INFO: renamed from: com.google.firebase.sessions.x$a */
    /* JADX INFO: compiled from: SessionDatastore.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$1", f = "SessionDatastore.kt", l = {81}, m = "invokeSuspend")
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f20101f;

        /* JADX INFO: renamed from: com.google.firebase.sessions.x$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SessionDatastore.kt */
        @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", "Lcom/google/firebase/sessions/FirebaseSessionsData;", "emit", "(Lcom/google/firebase/sessions/FirebaseSessionsData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        static final class C0236a<T> implements FlowCollector {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ SessionDatastoreImpl f20103f;

            C0236a(SessionDatastoreImpl sessionDatastoreImpl) {
                this.f20103f = sessionDatastoreImpl;
            }

            @Override // kotlinx.coroutines.p005z2.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object c(FirebaseSessionsData firebaseSessionsData, Continuation<? super kotlin.u> continuation) {
                this.f20103f.f20099f.set(firebaseSessionsData);
                return kotlin.u.a;
            }
        }

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return SessionDatastoreImpl.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f20101f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                Flow flow = SessionDatastoreImpl.this.f20100g;
                C0236a c0236a = new C0236a(SessionDatastoreImpl.this);
                this.f20101f = 1;
                if (flow.a(c0236a, this) == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.x$b */
    /* JADX INFO: compiled from: SessionDatastore.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroidx/datastore/preferences/core/Preferences;", "ex", "Landroidx/datastore/core/CorruptionException;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends Lambda implements Function1<CorruptionException, c.l.b.i.d> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f20104f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c.l.b.i.d invoke(CorruptionException corruptionException) {
            kotlin.jvm.internal.m.f(corruptionException, "ex");
            Log.w("FirebaseSessionsRepo", "CorruptionException in sessions DataStore in " + ProcessDetailsProvider.a.e() + '.', corruptionException);
            return c.l.b.i.e.a();
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.x$c */
    /* JADX INFO: compiled from: SessionDatastore.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R%\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastoreImpl$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "TAG", HttpUrl.FRAGMENT_ENCODE_SET, "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "Landroid/content/Context;", "getDataStore", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class c {
        static final /* synthetic */ KProperty<Object>[] a = {kotlin.jvm.internal.g0.i(new kotlin.jvm.internal.a0(c.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final androidx.datastore.core.e<c.l.b.i.d> b(Context context) {
            return (androidx.datastore.core.e) SessionDatastoreImpl.f20096c.a(context, a[0]);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.x$d */
    /* JADX INFO: compiled from: SessionDatastore.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/google/firebase/sessions/SessionDatastoreImpl$FirebaseSessionDataKeys;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "SESSION_ID", "Landroidx/datastore/preferences/core/Preferences$Key;", HttpUrl.FRAGMENT_ENCODE_SET, "getSESSION_ID", "()Landroidx/datastore/preferences/core/Preferences$Key;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class d {
        public static final d a = new d();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final c.l.b.i.d.a<String> f20105b = c.l.b.i.f.f("session_id");

        private d() {
        }

        public final c.l.b.i.d.a<String> a() {
            return f20105b;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.x$e */
    /* JADX INFO: compiled from: SessionDatastore.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/flow/FlowCollector;", "Landroidx/datastore/preferences/core/Preferences;", "exception", HttpUrl.FRAGMENT_ENCODE_SET}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$firebaseSessionDataFlow$1", f = "SessionDatastore.kt", l = {75}, m = "invokeSuspend")
    static final class e extends SuspendLambda implements Function3<FlowCollector<? super c.l.b.i.d>, Throwable, Continuation<? super kotlin.u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f20106f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f20107g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f20108h;

        e(Continuation<? super e> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object d(FlowCollector<? super c.l.b.i.d> flowCollector, Throwable th, Continuation<? super kotlin.u> continuation) {
            e eVar = new e(continuation);
            eVar.f20107g = flowCollector;
            eVar.f20108h = th;
            return eVar.invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f20106f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.f20107g;
                Log.e("FirebaseSessionsRepo", "Error reading stored session data.", (Throwable) this.f20108h);
                c.l.b.i.d dVarA = c.l.b.i.e.a();
                this.f20107g = null;
                this.f20106f = 1;
                if (flowCollector.c(dVarA, this) == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return kotlin.u.a;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.x$f */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", HttpUrl.FRAGMENT_ENCODE_SET, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f implements Flow<FirebaseSessionsData> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Flow f20109f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ SessionDatastoreImpl f20110g;

        /* JADX INFO: renamed from: com.google.firebase.sessions.x$f$a */
        /* JADX INFO: compiled from: Emitters.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ FlowCollector f20111f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ SessionDatastoreImpl f20112g;

            /* JADX INFO: renamed from: com.google.firebase.sessions.x$f$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Emitters.kt */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$special$$inlined$map$1$2", f = "SessionDatastore.kt", l = {224}, m = "emit")
            public static final class C0237a extends ContinuationImpl {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                /* synthetic */ Object f20113f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                int f20114g;

                public C0237a(Continuation continuation) {
                    super(continuation);
                }

                @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f20113f = obj;
                    this.f20114g |= Integer.MIN_VALUE;
                    return a.this.c(null, this);
                }
            }

            public a(FlowCollector flowCollector, SessionDatastoreImpl sessionDatastoreImpl) {
                this.f20111f = flowCollector;
                this.f20112g = sessionDatastoreImpl;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.p005z2.FlowCollector
            public final Object c(Object obj, Continuation continuation) throws Throwable {
                C0237a c0237a;
                if (continuation instanceof C0237a) {
                    c0237a = (C0237a) continuation;
                    int i2 = c0237a.f20114g;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        c0237a.f20114g = i2 - Integer.MIN_VALUE;
                    } else {
                        c0237a = new C0237a(continuation);
                    }
                } else {
                    c0237a = new C0237a(continuation);
                }
                Object obj2 = c0237a.f20113f;
                Object objC = kotlin.p003y.intrinsics.d.c();
                int i3 = c0237a.f20114g;
                if (i3 == 0) {
                    kotlin.o.b(obj2);
                    FlowCollector flowCollector = this.f20111f;
                    FirebaseSessionsData firebaseSessionsDataI = this.f20112g.i((c.l.b.i.d) obj);
                    c0237a.f20114g = 1;
                    if (flowCollector.c(firebaseSessionsDataI, c0237a) == objC) {
                        return objC;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.o.b(obj2);
                }
                return kotlin.u.a;
            }
        }

        public f(Flow flow, SessionDatastoreImpl sessionDatastoreImpl) {
            this.f20109f = flow;
            this.f20110g = sessionDatastoreImpl;
        }

        @Override // kotlinx.coroutines.p005z2.Flow
        public Object a(FlowCollector<? super FirebaseSessionsData> flowCollector, Continuation continuation) {
            Object objA = this.f20109f.a(new a(flowCollector, this.f20110g), continuation);
            return objA == kotlin.p003y.intrinsics.d.c() ? objA : kotlin.u.a;
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.x$g */
    /* JADX INFO: compiled from: SessionDatastore.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1", f = "SessionDatastore.kt", l = {87}, m = "invokeSuspend")
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f20116f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f20118h;

        /* JADX INFO: renamed from: com.google.firebase.sessions.x$g$a */
        /* JADX INFO: compiled from: SessionDatastore.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "preferences", "Landroidx/datastore/preferences/core/MutablePreferences;"}, k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "com.google.firebase.sessions.SessionDatastoreImpl$updateSessionId$1$1", f = "SessionDatastore.kt", l = {}, m = "invokeSuspend")
        static final class a extends SuspendLambda implements Function2<c.l.b.i.a, Continuation<? super kotlin.u>, Object> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            int f20119f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f20120g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f20121h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f20121h = str;
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.f20121h, continuation);
                aVar.f20120g = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(c.l.b.i.a aVar, Continuation<? super kotlin.u> continuation) {
                return ((a) create(aVar, continuation)).invokeSuspend(kotlin.u.a);
            }

            @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.p003y.intrinsics.d.c();
                if (this.f20119f != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
                ((c.l.b.i.a) this.f20120g).i(d.a.a(), this.f20121h);
                return kotlin.u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(String str, Continuation<? super g> continuation) {
            super(2, continuation);
            this.f20118h = str;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return SessionDatastoreImpl.this.new g(this.f20118h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.f20116f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                androidx.datastore.core.e eVarB = SessionDatastoreImpl.f20095b.b(SessionDatastoreImpl.this.f20097d);
                a aVar = new a(this.f20118h, null);
                this.f20116f = 1;
                if (c.l.b.i.g.a(eVarB, aVar, this) == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return kotlin.u.a;
        }
    }

    public SessionDatastoreImpl(Context context, CoroutineContext coroutineContext) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(coroutineContext, "backgroundDispatcher");
        this.f20097d = context;
        this.f20098e = coroutineContext;
        this.f20099f = new AtomicReference<>();
        this.f20100g = new f(kotlinx.coroutines.p005z2.d.a(f20095b.b(context).b(), new e(null)), this);
        kotlinx.coroutines.j.b(p0.a(coroutineContext), null, null, new a(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FirebaseSessionsData i(c.l.b.i.d dVar) {
        return new FirebaseSessionsData((String) dVar.b(d.a.a()));
    }

    @Override // com.google.firebase.sessions.SessionDatastore
    public String a() {
        FirebaseSessionsData firebaseSessionsData = this.f20099f.get();
        if (firebaseSessionsData != null) {
            return firebaseSessionsData.getSessionId();
        }
        return null;
    }

    @Override // com.google.firebase.sessions.SessionDatastore
    public void b(String str) {
        kotlin.jvm.internal.m.f(str, "sessionId");
        kotlinx.coroutines.j.b(p0.a(this.f20098e), null, null, new g(str, null), 3, null);
    }
}
