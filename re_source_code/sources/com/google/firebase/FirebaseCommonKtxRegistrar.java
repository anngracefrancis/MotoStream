package com.google.firebase;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.b0;
import com.google.firebase.components.p;
import com.google.firebase.components.r;
import com.google.firebase.components.v;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.collections.u;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.q1;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Firebase.kt */
/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/google/firebase/components/Component;", "com.google.firebase-firebase-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    /* JADX INFO: compiled from: Firebase.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "c", "Lcom/google/firebase/components/ComponentContainer;", "create", "com/google/firebase/FirebaseKt$coroutineDispatcher$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a<T> implements r {
        public static final a<T> a = new a<>();

        @Override // com.google.firebase.components.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher a(p pVar) {
            Object objF = pVar.f(b0.a(com.google.firebase.o.a.a.class, Executor.class));
            kotlin.jvm.internal.m.e(objF, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return q1.a((Executor) objF);
        }
    }

    /* JADX INFO: compiled from: Firebase.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "c", "Lcom/google/firebase/components/ComponentContainer;", "create", "com/google/firebase/FirebaseKt$coroutineDispatcher$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class b<T> implements r {
        public static final b<T> a = new b<>();

        @Override // com.google.firebase.components.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher a(p pVar) {
            Object objF = pVar.f(b0.a(com.google.firebase.o.a.c.class, Executor.class));
            kotlin.jvm.internal.m.e(objF, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return q1.a((Executor) objF);
        }
    }

    /* JADX INFO: compiled from: Firebase.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "c", "Lcom/google/firebase/components/ComponentContainer;", "create", "com/google/firebase/FirebaseKt$coroutineDispatcher$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class c<T> implements r {
        public static final c<T> a = new c<>();

        @Override // com.google.firebase.components.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher a(p pVar) {
            Object objF = pVar.f(b0.a(com.google.firebase.o.a.b.class, Executor.class));
            kotlin.jvm.internal.m.e(objF, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return q1.a((Executor) objF);
        }
    }

    /* JADX INFO: compiled from: Firebase.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\n\b\u0000\u0010\u0003\u0018\u0001*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"<anonymous>", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlin.jvm.PlatformType", "T", HttpUrl.FRAGMENT_ENCODE_SET, "c", "Lcom/google/firebase/components/ComponentContainer;", "create", "com/google/firebase/FirebaseKt$coroutineDispatcher$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class d<T> implements r {
        public static final d<T> a = new d<>();

        @Override // com.google.firebase.components.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CoroutineDispatcher a(p pVar) {
            Object objF = pVar.f(b0.a(com.google.firebase.o.a.d.class, Executor.class));
            kotlin.jvm.internal.m.e(objF, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return q1.a((Executor) objF);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<com.google.firebase.components.n<?>> getComponents() {
        com.google.firebase.components.n nVarD = com.google.firebase.components.n.a(b0.a(com.google.firebase.o.a.a.class, CoroutineDispatcher.class)).b(v.j(b0.a(com.google.firebase.o.a.a.class, Executor.class))).f(a.a).d();
        kotlin.jvm.internal.m.e(nVarD, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        com.google.firebase.components.n nVarD2 = com.google.firebase.components.n.a(b0.a(com.google.firebase.o.a.c.class, CoroutineDispatcher.class)).b(v.j(b0.a(com.google.firebase.o.a.c.class, Executor.class))).f(b.a).d();
        kotlin.jvm.internal.m.e(nVarD2, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        com.google.firebase.components.n nVarD3 = com.google.firebase.components.n.a(b0.a(com.google.firebase.o.a.b.class, CoroutineDispatcher.class)).b(v.j(b0.a(com.google.firebase.o.a.b.class, Executor.class))).f(c.a).d();
        kotlin.jvm.internal.m.e(nVarD3, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        com.google.firebase.components.n nVarD4 = com.google.firebase.components.n.a(b0.a(com.google.firebase.o.a.d.class, CoroutineDispatcher.class)).b(v.j(b0.a(com.google.firebase.o.a.d.class, Executor.class))).f(d.a).d();
        kotlin.jvm.internal.m.e(nVarD4, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        return u.m(nVarD, nVarD2, nVarD3, nVarD4);
    }
}
