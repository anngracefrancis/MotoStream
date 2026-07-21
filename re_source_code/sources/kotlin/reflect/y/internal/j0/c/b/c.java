package kotlin.reflect.y.internal.j0.c.b;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: LookupTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: LookupTracker.kt */
    public static final class a implements c {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.c.b.c
        public boolean a() {
            return false;
        }

        @Override // kotlin.reflect.y.internal.j0.c.b.c
        public void b(String str, e eVar, String str2, f fVar, String str3) {
            m.f(str, "filePath");
            m.f(eVar, "position");
            m.f(str2, "scopeFqName");
            m.f(fVar, "scopeKind");
            m.f(str3, "name");
        }
    }

    boolean a();

    void b(String str, e eVar, String str2, f fVar, String str3);
}
