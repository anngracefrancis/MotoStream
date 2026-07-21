package kotlin.reflect.y.internal.j0.e.z;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.v;
import kotlin.reflect.y.internal.j0.e.w;

/* JADX INFO: compiled from: VersionRequirement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f24195b = new h(u.j());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<v> f24196c;

    /* JADX INFO: compiled from: VersionRequirement.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final h a(w wVar) {
            m.f(wVar, "table");
            if (wVar.v() == 0) {
                return b();
            }
            List<v> listW = wVar.w();
            m.e(listW, "table.requirementList");
            return new h(listW, null);
        }

        public final h b() {
            return h.f24195b;
        }
    }

    private h(List<v> list) {
        this.f24196c = list;
    }

    public /* synthetic */ h(List list, g gVar) {
        this(list);
    }
}
