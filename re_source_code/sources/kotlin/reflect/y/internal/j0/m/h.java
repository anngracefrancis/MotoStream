package kotlin.reflect.y.internal.j0.m;

import java.util.Arrays;
import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.text.Regex;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private final f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Regex f24897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<f> f24898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1<y, String> f24899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f[] f24900e;

    /* JADX INFO: compiled from: modifierChecks.kt */
    static final class a extends Lambda implements Function1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f24901f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    static final class b extends Lambda implements Function1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f24902f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    static final class c extends Lambda implements Function1 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f24903f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Void invoke(y yVar) {
            m.f(yVar, "$this$null");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(f fVar, Regex regex, Collection<f> collection, Function1<? super y, String> function1, f... fVarArr) {
        this.a = fVar;
        this.f24897b = regex;
        this.f24898c = collection;
        this.f24899d = function1;
        this.f24900e = fVarArr;
    }

    public final g a(y yVar) {
        m.f(yVar, "functionDescriptor");
        for (f fVar : this.f24900e) {
            String strA = fVar.a(yVar);
            if (strA != null) {
                return new g.b(strA);
            }
        }
        String strInvoke = this.f24899d.invoke(yVar);
        return strInvoke != null ? new g.b(strInvoke) : g.c.f24896b;
    }

    public final boolean b(y yVar) {
        m.f(yVar, "functionDescriptor");
        if (this.a != null && !m.a(yVar.getName(), this.a)) {
            return false;
        }
        if (this.f24897b != null) {
            String strK = yVar.getName().k();
            m.e(strK, "functionDescriptor.name.asString()");
            if (!this.f24897b.b(strK)) {
                return false;
            }
        }
        Collection<f> collection = this.f24898c;
        return collection == null || collection.contains(yVar.getName());
    }

    public /* synthetic */ h(f fVar, f[] fVarArr, Function1 function1, int i2, g gVar) {
        this(fVar, fVarArr, (Function1<? super y, String>) ((i2 & 4) != 0 ? a.f24901f : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(f fVar, f[] fVarArr, Function1<? super y, String> function1) {
        this(fVar, (Regex) null, (Collection<f>) null, function1, (f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        m.f(fVar, "name");
        m.f(fVarArr, "checks");
        m.f(function1, "additionalChecks");
    }

    public /* synthetic */ h(Regex regex, f[] fVarArr, Function1 function1, int i2, g gVar) {
        this(regex, fVarArr, (Function1<? super y, String>) ((i2 & 4) != 0 ? b.f24902f : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Regex regex, f[] fVarArr, Function1<? super y, String> function1) {
        this((f) null, regex, (Collection<f>) null, function1, (f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        m.f(regex, "regex");
        m.f(fVarArr, "checks");
        m.f(function1, "additionalChecks");
    }

    public /* synthetic */ h(Collection collection, f[] fVarArr, Function1 function1, int i2, g gVar) {
        this((Collection<f>) collection, fVarArr, (Function1<? super y, String>) ((i2 & 4) != 0 ? c.f24903f : function1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Collection<f> collection, f[] fVarArr, Function1<? super y, String> function1) {
        this((f) null, (Regex) null, collection, function1, (f[]) Arrays.copyOf(fVarArr, fVarArr.length));
        m.f(collection, "nameList");
        m.f(fVarArr, "checks");
        m.f(function1, "additionalChecks");
    }
}
