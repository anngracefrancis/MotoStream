package kotlin.p003y;

import cm.aptoide.pt.database.room.RoomNotification;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.y.c, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", HttpUrl.FRAGMENT_ENCODE_SET, "containsAll", "context", "equals", "other", HttpUrl.FRAGMENT_ENCODE_SET, "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", RoomNotification.KEY, "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "minusKey", "size", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CombinedContext implements CoroutineContext, Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CoroutineContext f25599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CoroutineContext.b f25600g;

    /* JADX INFO: renamed from: kotlin.y.c$a */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \f2\u00060\u0001j\u0002`\u0002:\u0001\fB\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u0019\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "elements", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/coroutines/CoroutineContext;", "([Lkotlin/coroutines/CoroutineContext;)V", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "[Lkotlin/coroutines/CoroutineContext;", "readResolve", HttpUrl.FRAGMENT_ENCODE_SET, "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a implements Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0419a f25601f = new C0419a(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final CoroutineContext[] f25602g;

        /* JADX INFO: renamed from: kotlin.y.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: CoroutineContextImpl.kt */
        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "serialVersionUID", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class C0419a {
            private C0419a() {
            }

            public /* synthetic */ C0419a(g gVar) {
                this();
            }
        }

        public a(CoroutineContext[] coroutineContextArr) {
            m.f(coroutineContextArr, "elements");
            this.f25602g = coroutineContextArr;
        }

        private final Object readResolve() {
            CoroutineContext[] coroutineContextArr = this.f25602g;
            CoroutineContext coroutineContextPlus = EmptyCoroutineContext.f25609f;
            for (CoroutineContext coroutineContext : coroutineContextArr) {
                coroutineContextPlus = coroutineContextPlus.plus(coroutineContext);
            }
            return coroutineContextPlus;
        }
    }

    /* JADX INFO: renamed from: kotlin.y.c$b */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class b extends Lambda implements Function2<String, CoroutineContext.b, String> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f25603f = new b();

        b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, CoroutineContext.b bVar) {
            m.f(str, "acc");
            m.f(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    /* JADX INFO: renamed from: kotlin.y.c$c */
    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "<anonymous parameter 0>", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class c extends Lambda implements Function2<u, CoroutineContext.b, u> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CoroutineContext[] f25604f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d0 f25605g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CoroutineContext[] coroutineContextArr, d0 d0Var) {
            super(2);
            this.f25604f = coroutineContextArr;
            this.f25605g = d0Var;
        }

        public final void b(u uVar, CoroutineContext.b bVar) {
            m.f(uVar, "<anonymous parameter 0>");
            m.f(bVar, "element");
            CoroutineContext[] coroutineContextArr = this.f25604f;
            d0 d0Var = this.f25605g;
            int i2 = d0Var.f22935f;
            d0Var.f22935f = i2 + 1;
            coroutineContextArr[i2] = bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ u invoke(u uVar, CoroutineContext.b bVar) {
            b(uVar, bVar);
            return u.a;
        }
    }

    public CombinedContext(CoroutineContext coroutineContext, CoroutineContext.b bVar) {
        m.f(coroutineContext, "left");
        m.f(bVar, "element");
        this.f25599f = coroutineContext;
        this.f25600g = bVar;
    }

    private final boolean e(CoroutineContext.b bVar) {
        return m.a(get(bVar.getKey()), bVar);
    }

    private final boolean g(CombinedContext combinedContext) {
        while (e(combinedContext.f25600g)) {
            CoroutineContext coroutineContext = combinedContext.f25599f;
            if (!(coroutineContext instanceof CombinedContext)) {
                m.d(coroutineContext, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return e((CoroutineContext.b) coroutineContext);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
        return false;
    }

    private final int h() {
        int i2 = 2;
        CombinedContext combinedContext = this;
        while (true) {
            CoroutineContext coroutineContext = combinedContext.f25599f;
            combinedContext = coroutineContext instanceof CombinedContext ? (CombinedContext) coroutineContext : null;
            if (combinedContext == null) {
                return i2;
            }
            i2++;
        }
    }

    private final Object writeReplace() {
        int iH = h();
        CoroutineContext[] coroutineContextArr = new CoroutineContext[iH];
        d0 d0Var = new d0();
        fold(u.a, new c(coroutineContextArr, d0Var));
        if (d0Var.f22935f == iH) {
            return new a(coroutineContextArr);
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public boolean equals(Object other) {
        if (this != other) {
            if (other instanceof CombinedContext) {
                CombinedContext combinedContext = (CombinedContext) other;
                if (combinedContext.h() != h() || !combinedContext.g(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // kotlin.p003y.CoroutineContext
    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.b, ? extends R> function2) {
        m.f(function2, "operation");
        return function2.invoke((Object) this.f25599f.fold(r, function2), this.f25600g);
    }

    @Override // kotlin.p003y.CoroutineContext
    public <E extends CoroutineContext.b> E get(CoroutineContext.c<E> cVar) {
        m.f(cVar, RoomNotification.KEY);
        CombinedContext combinedContext = this;
        while (true) {
            E e2 = (E) combinedContext.f25600g.get(cVar);
            if (e2 != null) {
                return e2;
            }
            CoroutineContext coroutineContext = combinedContext.f25599f;
            if (!(coroutineContext instanceof CombinedContext)) {
                return (E) coroutineContext.get(cVar);
            }
            combinedContext = (CombinedContext) coroutineContext;
        }
    }

    public int hashCode() {
        return this.f25599f.hashCode() + this.f25600g.hashCode();
    }

    @Override // kotlin.p003y.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.c<?> cVar) {
        m.f(cVar, RoomNotification.KEY);
        if (this.f25600g.get(cVar) != null) {
            return this.f25599f;
        }
        CoroutineContext coroutineContextMinusKey = this.f25599f.minusKey(cVar);
        if (coroutineContextMinusKey == this.f25599f) {
            return this;
        }
        return coroutineContextMinusKey == EmptyCoroutineContext.f25609f ? this.f25600g : new CombinedContext(coroutineContextMinusKey, this.f25600g);
    }

    @Override // kotlin.p003y.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.a.a(this, coroutineContext);
    }

    public String toString() {
        return '[' + ((String) fold(HttpUrl.FRAGMENT_ENCODE_SET, b.f25603f)) + ']';
    }
}
