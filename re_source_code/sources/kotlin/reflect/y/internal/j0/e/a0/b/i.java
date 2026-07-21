package kotlin.reflect.y.internal.j0.e.a0.b;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.d;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.u;
import kotlin.reflect.y.internal.j0.e.z.b;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.e.z.e;
import kotlin.reflect.y.internal.j0.e.z.g;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: JvmProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {
    public static final i a = new i();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final f f23899b;

    static {
        f fVarD = f.d();
        a.a(fVarD);
        m.e(fVarD, "newInstance().apply(JvmP…f::registerAllExtensions)");
        f23899b = fVarD;
    }

    private i() {
    }

    public static /* synthetic */ d.a d(i iVar, n nVar, c cVar, g gVar, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        return iVar.c(nVar, cVar, gVar, z);
    }

    public static final boolean f(n nVar) {
        m.f(nVar, "proto");
        b.C0370b c0370bA = c.a.a();
        Object objU = nVar.u(a.f23824e);
        m.e(objU, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean boolD = c0370bA.d(((Number) objU).intValue());
        m.e(boolD, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return boolD.booleanValue();
    }

    private final String g(q qVar, c cVar) {
        if (qVar.m0()) {
            return b.b(cVar.a(qVar.X()));
        }
        return null;
    }

    public static final Pair<f, kotlin.reflect.y.internal.j0.e.c> h(byte[] bArr, String[] strArr) {
        m.f(bArr, "bytes");
        m.f(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(a.k(byteArrayInputStream, strArr), kotlin.reflect.y.internal.j0.e.c.x1(byteArrayInputStream, f23899b));
    }

    public static final Pair<f, kotlin.reflect.y.internal.j0.e.c> i(String[] strArr, String[] strArr2) {
        m.f(strArr, "data");
        m.f(strArr2, "strings");
        byte[] bArrE = a.e(strArr);
        m.e(bArrE, "decodeBytes(data)");
        return h(bArrE, strArr2);
    }

    public static final Pair<f, kotlin.reflect.y.internal.j0.e.i> j(String[] strArr, String[] strArr2) {
        m.f(strArr, "data");
        m.f(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(strArr));
        return new Pair<>(a.k(byteArrayInputStream, strArr2), kotlin.reflect.y.internal.j0.e.i.F0(byteArrayInputStream, f23899b));
    }

    private final f k(InputStream inputStream, String[] strArr) throws IOException {
        a.e eVarD = a.e.D(inputStream, f23899b);
        m.e(eVarD, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new f(eVarD, strArr);
    }

    public static final Pair<f, l> l(byte[] bArr, String[] strArr) {
        m.f(bArr, "bytes");
        m.f(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(a.k(byteArrayInputStream, strArr), l.e0(byteArrayInputStream, f23899b));
    }

    public static final Pair<f, l> m(String[] strArr, String[] strArr2) {
        m.f(strArr, "data");
        m.f(strArr2, "strings");
        byte[] bArrE = a.e(strArr);
        m.e(bArrE, "decodeBytes(data)");
        return l(bArrE, strArr2);
    }

    public final f a() {
        return f23899b;
    }

    public final d.b b(d dVar, c cVar, g gVar) {
        String strE0;
        m.f(dVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        h.f<d, a.c> fVar = a.a;
        m.e(fVar, "constructorSignature");
        a.c cVar2 = (a.c) e.a(dVar, fVar);
        String string = (cVar2 == null || !cVar2.z()) ? "<init>" : cVar.getString(cVar2.x());
        if (cVar2 == null || !cVar2.y()) {
            List<u> listM = dVar.M();
            m.e(listM, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(v.u(listM, 10));
            for (u uVar : listM) {
                i iVar = a;
                m.e(uVar, "it");
                String strG = iVar.g(kotlin.reflect.y.internal.j0.e.z.f.n(uVar, gVar), cVar);
                if (strG == null) {
                    return null;
                }
                arrayList.add(strG);
            }
            strE0 = c0.e0(arrayList, HttpUrl.FRAGMENT_ENCODE_SET, "(", ")V", 0, null, null, 56, null);
        } else {
            strE0 = cVar.getString(cVar2.w());
        }
        return new d.b(string, strE0);
    }

    public final d.a c(n nVar, c cVar, g gVar, boolean z) {
        String strG;
        m.f(nVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        h.f<n, a.d> fVar = a.f23823d;
        m.e(fVar, "propertySignature");
        a.d dVar = (a.d) e.a(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        a.b bVarA = dVar.F() ? dVar.A() : null;
        if (bVarA == null && z) {
            return null;
        }
        int iD0 = (bVarA == null || !bVarA.z()) ? nVar.d0() : bVarA.x();
        if (bVarA == null || !bVarA.y()) {
            strG = g(kotlin.reflect.y.internal.j0.e.z.f.k(nVar, gVar), cVar);
            if (strG == null) {
                return null;
            }
        } else {
            strG = cVar.getString(bVarA.w());
        }
        return new d.a(cVar.getString(iD0), strG);
    }

    public final d.b e(kotlin.reflect.y.internal.j0.e.i iVar, c cVar, g gVar) {
        String string;
        m.f(iVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        h.f<kotlin.reflect.y.internal.j0.e.i, a.c> fVar = a.f23821b;
        m.e(fVar, "methodSignature");
        a.c cVar2 = (a.c) e.a(iVar, fVar);
        int iE0 = (cVar2 == null || !cVar2.z()) ? iVar.e0() : cVar2.x();
        if (cVar2 == null || !cVar2.y()) {
            List listN = kotlin.collections.u.n(kotlin.reflect.y.internal.j0.e.z.f.h(iVar, gVar));
            List<u> listQ0 = iVar.q0();
            m.e(listQ0, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(v.u(listQ0, 10));
            for (u uVar : listQ0) {
                m.e(uVar, "it");
                arrayList.add(kotlin.reflect.y.internal.j0.e.z.f.n(uVar, gVar));
            }
            List listO0 = c0.o0(listN, arrayList);
            ArrayList arrayList2 = new ArrayList(v.u(listO0, 10));
            Iterator it = listO0.iterator();
            while (it.hasNext()) {
                String strG = a.g((q) it.next(), cVar);
                if (strG == null) {
                    return null;
                }
                arrayList2.add(strG);
            }
            String strG2 = g(kotlin.reflect.y.internal.j0.e.z.f.j(iVar, gVar), cVar);
            if (strG2 == null) {
                return null;
            }
            string = c0.e0(arrayList2, HttpUrl.FRAGMENT_ENCODE_SET, "(", ")", 0, null, null, 56, null) + strG2;
        } else {
            string = cVar.getString(cVar2.w());
        }
        return new d.b(cVar.getString(iE0), string);
    }
}
