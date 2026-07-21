package c.l.b.i;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.j;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.p003y.Continuation;
import kotlin.u;

/* JADX INFO: compiled from: PreferencesSerializer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class h implements j<d> {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3336b = "preferences_pb";

    /* JADX INFO: compiled from: PreferencesSerializer.kt */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.l.b.h.b.values().length];
            iArr[c.l.b.h.b.BOOLEAN.ordinal()] = 1;
            iArr[c.l.b.h.b.FLOAT.ordinal()] = 2;
            iArr[c.l.b.h.b.DOUBLE.ordinal()] = 3;
            iArr[c.l.b.h.b.INTEGER.ordinal()] = 4;
            iArr[c.l.b.h.b.LONG.ordinal()] = 5;
            iArr[c.l.b.h.b.STRING.ordinal()] = 6;
            iArr[c.l.b.h.b.STRING_SET.ordinal()] = 7;
            iArr[c.l.b.h.b.VALUE_NOT_SET.ordinal()] = 8;
            a = iArr;
        }
    }

    private h() {
    }

    private final void d(String str, c.l.b.h hVar, c.l.b.i.a aVar) throws CorruptionException {
        c.l.b.h.b bVarZ = hVar.Z();
        switch (bVarZ == null ? -1 : a.a[bVarZ.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                aVar.i(f.a(str), Boolean.valueOf(hVar.R()));
                return;
            case 2:
                aVar.i(f.c(str), Float.valueOf(hVar.U()));
                return;
            case 3:
                aVar.i(f.b(str), Double.valueOf(hVar.T()));
                return;
            case 4:
                aVar.i(f.d(str), Integer.valueOf(hVar.V()));
                return;
            case 5:
                aVar.i(f.e(str), Long.valueOf(hVar.W()));
                return;
            case 6:
                d.a<String> aVarF = f.f(str);
                String strX = hVar.X();
                m.e(strX, "value.string");
                aVar.i(aVarF, strX);
                return;
            case 7:
                d.a<Set<String>> aVarG = f.g(str);
                List<String> listO = hVar.Y().O();
                m.e(listO, "value.stringSet.stringsList");
                aVar.i(aVarG, c0.I0(listO));
                return;
            case 8:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    private final c.l.b.h g(Object obj) {
        if (obj instanceof Boolean) {
            c.l.b.h hVarC = c.l.b.h.a0().w(((Boolean) obj).booleanValue()).c();
            m.e(hVarC, "newBuilder().setBoolean(value).build()");
            return hVarC;
        }
        if (obj instanceof Float) {
            c.l.b.h hVarC2 = c.l.b.h.a0().B(((Number) obj).floatValue()).c();
            m.e(hVarC2, "newBuilder().setFloat(value).build()");
            return hVarC2;
        }
        if (obj instanceof Double) {
            c.l.b.h hVarC3 = c.l.b.h.a0().A(((Number) obj).doubleValue()).c();
            m.e(hVarC3, "newBuilder().setDouble(value).build()");
            return hVarC3;
        }
        if (obj instanceof Integer) {
            c.l.b.h hVarC4 = c.l.b.h.a0().C(((Number) obj).intValue()).c();
            m.e(hVarC4, "newBuilder().setInteger(value).build()");
            return hVarC4;
        }
        if (obj instanceof Long) {
            c.l.b.h hVarC5 = c.l.b.h.a0().D(((Number) obj).longValue()).c();
            m.e(hVarC5, "newBuilder().setLong(value).build()");
            return hVarC5;
        }
        if (obj instanceof String) {
            c.l.b.h hVarC6 = c.l.b.h.a0().E((String) obj).c();
            m.e(hVarC6, "newBuilder().setString(value).build()");
            return hVarC6;
        }
        if (!(obj instanceof Set)) {
            throw new IllegalStateException(m.n("PreferencesSerializer does not support type: ", obj.getClass().getName()));
        }
        c.l.b.h hVarC7 = c.l.b.h.a0().F(c.l.b.g.P().w((Set) obj)).c();
        m.e(hVarC7, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
        return hVarC7;
    }

    @Override // androidx.datastore.core.j
    public Object c(InputStream inputStream, Continuation<? super d> continuation) throws IOException {
        c.l.b.f fVarA = c.l.b.d.a.a(inputStream);
        c.l.b.i.a aVarB = e.b(new d.b[0]);
        Map<String, c.l.b.h> mapM = fVarA.M();
        m.e(mapM, "preferencesProto.preferencesMap");
        for (Map.Entry<String, c.l.b.h> entry : mapM.entrySet()) {
            String key = entry.getKey();
            c.l.b.h value = entry.getValue();
            h hVar = a;
            m.e(key, "name");
            m.e(value, "value");
            hVar.d(key, value, aVarB);
        }
        return aVarB.d();
    }

    @Override // androidx.datastore.core.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d a() {
        return e.a();
    }

    public final String f() {
        return f3336b;
    }

    @Override // androidx.datastore.core.j
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Object b(d dVar, OutputStream outputStream, Continuation<? super u> continuation) throws IOException {
        Map<d.a<?>, Object> mapA = dVar.a();
        c.l.b.f.a aVarP = c.l.b.f.P();
        for (Map.Entry<d.a<?>, Object> entry : mapA.entrySet()) {
            aVarP.w(entry.getKey().a(), g(entry.getValue()));
        }
        aVarP.c().o(outputStream);
        return u.a;
    }
}
