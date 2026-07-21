package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.y;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t implements f {
    private final String a;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f24937b;

        public a(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append("must have at least ");
            sb.append(i2);
            sb.append(" value parameter");
            sb.append(i2 > 1 ? "s" : HttpUrl.FRAGMENT_ENCODE_SET);
            super(sb.toString(), null);
            this.f24937b = i2;
        }

        @Override // kotlin.reflect.y.internal.j0.m.f
        public boolean b(y yVar) {
            m.f(yVar, "functionDescriptor");
            return yVar.f().size() >= this.f24937b;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f24938b;

        public b(int i2) {
            super("must have exactly " + i2 + " value parameters", null);
            this.f24938b = i2;
        }

        @Override // kotlin.reflect.y.internal.j0.m.f
        public boolean b(y yVar) {
            m.f(yVar, "functionDescriptor");
            return yVar.f().size() == this.f24938b;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f24939b = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.y.internal.j0.m.f
        public boolean b(y yVar) {
            m.f(yVar, "functionDescriptor");
            return yVar.f().isEmpty();
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class d extends t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f24940b = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.y.internal.j0.m.f
        public boolean b(y yVar) {
            m.f(yVar, "functionDescriptor");
            return yVar.f().size() == 1;
        }
    }

    private t(String str) {
        this.a = str;
    }

    public /* synthetic */ t(String str, g gVar) {
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
