package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: ScopesHolderForClass.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x0<T extends h> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f25378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1<g, T> f25379d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final g f25380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f25381f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f25377b = {g0.h(new y(g0.b(x0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public static final a a = new a(null);

    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final <T extends h> x0<T> a(e eVar, n nVar, g gVar, Function1<? super g, ? extends T> function1) {
            m.f(eVar, "classDescriptor");
            m.f(nVar, "storageManager");
            m.f(gVar, "kotlinTypeRefinerForOwnerModule");
            m.f(function1, "scopeFactory");
            return new x0<>(eVar, nVar, function1, gVar, null);
        }
    }

    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    static final class b extends Lambda implements Function0<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x0<T> f25382f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ g f25383g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(x0<T> x0Var, g gVar) {
            super(0);
            this.f25382f = x0Var;
            this.f25383g = gVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T invoke() {
            return (T) ((x0) this.f25382f).f25379d.invoke(this.f25383g);
        }
    }

    /* JADX INFO: compiled from: ScopesHolderForClass.kt */
    static final class c extends Lambda implements Function0<T> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ x0<T> f25384f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(x0<T> x0Var) {
            super(0);
            this.f25384f = x0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T invoke() {
            return (T) ((x0) this.f25384f).f25379d.invoke(((x0) this.f25384f).f25380e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private x0(e eVar, n nVar, Function1<? super g, ? extends T> function1, g gVar) {
        this.f25378c = eVar;
        this.f25379d = function1;
        this.f25380e = gVar;
        this.f25381f = nVar.d(new c(this));
    }

    public /* synthetic */ x0(e eVar, n nVar, Function1 function1, g gVar, kotlin.jvm.internal.g gVar2) {
        this(eVar, nVar, function1, gVar);
    }

    private final T d() {
        return (T) kotlin.reflect.y.internal.j0.k.m.a(this.f25381f, this, f25377b[0]);
    }

    public final T c(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        if (!gVar.d(kotlin.reflect.y.internal.j0.i.t.a.l(this.f25378c))) {
            return (T) d();
        }
        e1 e1VarH = this.f25378c.h();
        m.e(e1VarH, "classDescriptor.typeConstructor");
        return !gVar.e(e1VarH) ? (T) d() : (T) gVar.c(this.f25378c, new b(this, gVar));
    }
}
