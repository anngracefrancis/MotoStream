package kotlin.reflect.y.internal.j0.e.a0.b;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: JvmMemberSignature.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {

    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class a extends d {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f23886b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2) {
            super(null);
            m.f(str, "name");
            m.f(str2, "desc");
            this.a = str;
            this.f23886b = str2;
        }

        @Override // kotlin.reflect.y.internal.j0.e.a0.b.d
        public String a() {
            return c() + ':' + b();
        }

        @Override // kotlin.reflect.y.internal.j0.e.a0.b.d
        public String b() {
            return this.f23886b;
        }

        @Override // kotlin.reflect.y.internal.j0.e.a0.b.d
        public String c() {
            return this.a;
        }

        public final String d() {
            return c();
        }

        public final String e() {
            return b();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(c(), aVar.c()) && m.a(b(), aVar.b());
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    /* JADX INFO: compiled from: JvmMemberSignature.kt */
    public static final class b extends d {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f23887b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, String str2) {
            super(null);
            m.f(str, "name");
            m.f(str2, "desc");
            this.a = str;
            this.f23887b = str2;
        }

        @Override // kotlin.reflect.y.internal.j0.e.a0.b.d
        public String a() {
            return c() + b();
        }

        @Override // kotlin.reflect.y.internal.j0.e.a0.b.d
        public String b() {
            return this.f23887b;
        }

        @Override // kotlin.reflect.y.internal.j0.e.a0.b.d
        public String c() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return m.a(c(), bVar.c()) && m.a(b(), bVar.b());
        }

        public int hashCode() {
            return (c().hashCode() * 31) + b().hashCode();
        }
    }

    private d() {
    }

    public /* synthetic */ d(g gVar) {
        this();
    }

    public abstract String a();

    public abstract String b();

    public abstract String c();

    public final String toString() {
        return a();
    }
}
