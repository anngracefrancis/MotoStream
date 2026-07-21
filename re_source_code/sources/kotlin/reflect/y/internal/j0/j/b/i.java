package kotlin.reflect.y.internal.j0.j.b;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.e;
import kotlin.p002reflect.jvm.internal.impl.descriptors.k0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n0;
import kotlin.p002reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.e.t;
import kotlin.reflect.y.internal.j0.e.w;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.j.b.g0.d;

/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<kotlin.reflect.y.internal.j0.f.b> f24576b = v0.c(kotlin.reflect.y.internal.j0.f.b.m(k.a.f23203d.l()));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f24577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function1<a, e> f24578d;

    /* JADX INFO: compiled from: ClassDeserializer.kt */
    private static final class a {
        private final kotlin.reflect.y.internal.j0.f.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final g f24579b;

        public a(kotlin.reflect.y.internal.j0.f.b bVar, g gVar) {
            m.f(bVar, "classId");
            this.a = bVar;
            this.f24579b = gVar;
        }

        public final g a() {
            return this.f24579b;
        }

        public final kotlin.reflect.y.internal.j0.f.b b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && m.a(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: compiled from: ClassDeserializer.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final Set<kotlin.reflect.y.internal.j0.f.b> a() {
            return i.f24576b;
        }
    }

    /* JADX INFO: compiled from: ClassDeserializer.kt */
    static final class c extends Lambda implements Function1<a, e> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e invoke(a aVar) {
            m.f(aVar, RoomNotification.KEY);
            return i.this.c(aVar);
        }
    }

    public i(k kVar) {
        m.f(kVar, "components");
        this.f24577c = kVar;
        this.f24578d = kVar.u().i(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    public final e c(a aVar) {
        Object next;
        m mVarA;
        boolean z;
        kotlin.reflect.y.internal.j0.f.b bVarB = aVar.b();
        Iterator<kotlin.p002reflect.jvm.internal.impl.descriptors.o1.b> it = this.f24577c.k().iterator();
        while (it.hasNext()) {
            e eVarC = it.next().c(bVarB);
            if (eVarC != null) {
                return eVarC;
            }
        }
        if (f24576b.contains(bVarB)) {
            return null;
        }
        g gVarA = aVar.a();
        if (gVarA == null && (gVarA = this.f24577c.e().a(bVarB)) == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.e.z.c cVarA = gVarA.a();
        kotlin.reflect.y.internal.j0.e.c cVarB = gVarA.b();
        kotlin.reflect.y.internal.j0.e.z.a aVarC = gVarA.c();
        z0 z0VarD = gVarA.d();
        kotlin.reflect.y.internal.j0.f.b bVarG = bVarB.g();
        if (bVarG != null) {
            e eVarE = e(this, bVarG, null, 2, null);
            d dVar = eVarE instanceof d ? (d) eVarE : null;
            if (dVar == null) {
                return null;
            }
            f fVarJ = bVarB.j();
            m.e(fVarJ, "classId.shortClassName");
            if (!dVar.h1(fVarJ)) {
                return null;
            }
            mVarA = dVar.b1();
        } else {
            l0 l0VarR = this.f24577c.r();
            kotlin.reflect.y.internal.j0.f.c cVarH = bVarB.h();
            m.e(cVarH, "classId.packageFqName");
            Iterator<T> it2 = n0.c(l0VarR, cVarH).iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                k0 k0Var = (k0) next;
                if (k0Var instanceof p) {
                    f fVarJ2 = bVarB.j();
                    m.e(fVarJ2, "classId.shortClassName");
                    if (((p) k0Var).L0(fVarJ2)) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else {
                    z = true;
                }
            } while (!z);
            k0 k0Var2 = (k0) next;
            if (k0Var2 == null) {
                return null;
            }
            k kVar = this.f24577c;
            t tVarI1 = cVarB.i1();
            m.e(tVarI1, "classProto.typeTable");
            kotlin.reflect.y.internal.j0.e.z.g gVar = new kotlin.reflect.y.internal.j0.e.z.g(tVarI1);
            h.a aVar2 = h.a;
            w wVarK1 = cVarB.k1();
            m.e(wVarK1, "classProto.versionRequirementTable");
            mVarA = kVar.a(k0Var2, cVarA, gVar, aVar2.a(wVarK1), aVarC, null);
        }
        return new d(mVarA, cVarB, cVarA, aVarC, z0VarD);
    }

    public static /* synthetic */ e e(i iVar, kotlin.reflect.y.internal.j0.f.b bVar, g gVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            gVar = null;
        }
        return iVar.d(bVar, gVar);
    }

    public final e d(kotlin.reflect.y.internal.j0.f.b bVar, g gVar) {
        m.f(bVar, "classId");
        return this.f24578d.invoke(new a(bVar, gVar));
    }
}
