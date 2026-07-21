package kotlin.reflect.y.internal.j0.i.w;

/* JADX INFO: compiled from: MemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class a extends c {
        public static final a a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f24400b;

        static {
            d.a aVar = d.a;
            f24400b = ((aVar.i() | aVar.d()) ^ (-1)) & aVar.b();
        }

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.c
        public int a() {
            return f24400b;
        }
    }

    /* JADX INFO: compiled from: MemberScope.kt */
    public static final class b extends c {
        public static final b a = new b();

        private b() {
        }

        @Override // kotlin.reflect.y.internal.j0.i.w.c
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
