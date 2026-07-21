package kotlin.reflect.y.internal.j0.d.b;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: PackagePartProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface w {

    /* JADX INFO: compiled from: PackagePartProvider.kt */
    public static final class a implements w {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.d.b.w
        public List<String> a(String str) {
            m.f(str, "packageFqName");
            return u.j();
        }
    }

    List<String> a(String str);
}
