package kotlin.reflect.y.internal.j0.h;

import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum e {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f24275f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<e> f24276g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<e> f24277h;
    private final boolean x;

    /* JADX INFO: compiled from: DescriptorRenderer.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        e[] eVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (e eVar : eVarArrValues) {
            if (eVar.x) {
                arrayList.add(eVar);
            }
        }
        f24276g = c0.I0(arrayList);
        f24277h = n.l0(values());
    }

    e(boolean z) {
        this.x = z;
    }
}
