package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements f {
    private final String a;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f24906b = new a();

        private a() {
            super("must be a member function", null);
        }

        @Override // kotlin.reflect.y.internal.j0.m.f
        public boolean b(y yVar) {
            m.f(yVar, "functionDescriptor");
            return yVar.f0() != null;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f24907b = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.reflect.y.internal.j0.m.f
        public boolean b(y yVar) {
            m.f(yVar, "functionDescriptor");
            return (yVar.f0() == null && yVar.m0() == null) ? false : true;
        }
    }

    private k(String str) {
        this.a = str;
    }

    public /* synthetic */ k(String str, g gVar) {
        this(str);
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String getDescription() {
        return this.a;
    }
}
