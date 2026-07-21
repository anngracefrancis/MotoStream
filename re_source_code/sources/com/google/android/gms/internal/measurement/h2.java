package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h2<T extends zzey<T>> {
    private static final h2 a = new h2(true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final u3<T, Object> f17168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f17169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f17170d;

    private h2() {
        this.f17168b = u3.b(16);
    }

    public static int a(zzey<?> zzeyVar, Object obj) {
        zzim zzimVarB = zzeyVar.b();
        int iA = zzeyVar.a();
        if (!zzeyVar.d()) {
            return b(zzimVarB, iA, obj);
        }
        int iB = 0;
        if (zzeyVar.e()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iB += i(zzimVarB, it.next());
            }
            return zzen.g0(iA) + iB + zzen.D0(iB);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iB += b(zzimVarB, iA, it2.next());
        }
        return iB;
    }

    static int b(zzim zzimVar, int i2, Object obj) {
        int iG0 = zzen.g0(i2);
        if (zzimVar == zzim.o) {
            zzff.g((zzgo) obj);
            iG0 <<= 1;
        }
        return iG0 + i(zzimVar, obj);
    }

    public static <T extends zzey<T>> h2<T> c() {
        return a;
    }

    private final Object d(T t) {
        Object obj = this.f17168b.get(t);
        if (!(obj instanceof zzfp)) {
            return obj;
        }
        return zzfp.e();
    }

    private static Object e(Object obj) {
        if (obj instanceof zzgt) {
            return ((zzgt) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:4:0x0014  */
    private static void g(zzim zzimVar, Object obj) {
        zzff.d(obj);
        boolean z = true;
        switch (g2.a[zzimVar.g().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzdu) && !(obj instanceof byte[])) {
                    z = false;
                }
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzfi)) {
                    z = false;
                }
                break;
            case 9:
                if (!(obj instanceof zzgo) && !(obj instanceof zzfp)) {
                    z = false;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static <T extends zzey<T>> boolean h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.c() == zzip.MESSAGE) {
            if (key.d()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgo) it.next()).b()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzgo)) {
                    if (value instanceof zzfp) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzgo) value).b()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int i(zzim zzimVar, Object obj) {
        switch (g2.f17155b[zzimVar.ordinal()]) {
            case 1:
                return zzen.z(((Double) obj).doubleValue());
            case 2:
                return zzen.A(((Float) obj).floatValue());
            case 3:
                return zzen.d0(((Long) obj).longValue());
            case 4:
                return zzen.i0(((Long) obj).longValue());
            case 5:
                return zzen.k0(((Integer) obj).intValue());
            case 6:
                return zzen.r0(((Long) obj).longValue());
            case 7:
                return zzen.w0(((Integer) obj).intValue());
            case 8:
                return zzen.L(((Boolean) obj).booleanValue());
            case 9:
                return zzen.V((zzgo) obj);
            case 10:
                return obj instanceof zzfp ? zzen.d((zzfp) obj) : zzen.J((zzgo) obj);
            case 11:
                return obj instanceof zzdu ? zzen.I((zzdu) obj) : zzen.K((String) obj);
            case 12:
                return obj instanceof zzdu ? zzen.I((zzdu) obj) : zzen.M((byte[]) obj);
            case 13:
                return zzen.o0(((Integer) obj).intValue());
            case 14:
                return zzen.z0(((Integer) obj).intValue());
            case 15:
                return zzen.v0(((Long) obj).longValue());
            case 16:
                return zzen.s0(((Integer) obj).intValue());
            case 17:
                return zzen.n0(((Long) obj).longValue());
            case 18:
                return obj instanceof zzfi ? zzen.B0(((zzfi) obj).a()) : zzen.B0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void k(T t, Object obj) {
        if (!t.d()) {
            g(t.b(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj2 = arrayList.get(i2);
                i2++;
                g(t.b(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzfp) {
            this.f17170d = true;
        }
        this.f17168b.put(t, obj);
    }

    private final void l(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            value = zzfp.e();
        }
        if (key.d()) {
            Object objD = d(key);
            if (objD == null) {
                objD = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objD).add(e(it.next()));
            }
            this.f17168b.put(key, objD);
            return;
        }
        if (key.c() != zzip.MESSAGE) {
            this.f17168b.put(key, e(value));
            return;
        }
        Object objD2 = d(key);
        if (objD2 == null) {
            this.f17168b.put(key, e(value));
        } else {
            this.f17168b.put(key, objD2 instanceof zzgt ? key.z((zzgt) objD2, (zzgt) value) : key.o(((zzgo) objD2).e(), (zzgo) value).y());
        }
    }

    private static int m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.c() != zzip.MESSAGE || key.d() || key.e()) {
            return a(key, value);
        }
        return value instanceof zzfp ? zzen.D(entry.getKey().a(), (zzfp) value) : zzen.E(entry.getKey().a(), (zzgo) value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        h2 h2Var = new h2();
        for (int i2 = 0; i2 < this.f17168b.k(); i2++) {
            Map.Entry<K, Object> entryI = this.f17168b.i(i2);
            h2Var.k((zzey) entryI.getKey(), entryI.getValue());
        }
        Iterator it = this.f17168b.n().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            h2Var.k((zzey) entry.getKey(), entry.getValue());
        }
        h2Var.f17170d = this.f17170d;
        return h2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h2) {
            return this.f17168b.equals(((h2) obj).f17168b);
        }
        return false;
    }

    public final void f(h2<T> h2Var) {
        for (int i2 = 0; i2 < h2Var.f17168b.k(); i2++) {
            l(h2Var.f17168b.i(i2));
        }
        Iterator it = h2Var.f17168b.n().iterator();
        while (it.hasNext()) {
            l((Map.Entry) it.next());
        }
    }

    public final int hashCode() {
        return this.f17168b.hashCode();
    }

    public final void j() {
        if (this.f17169c) {
            return;
        }
        this.f17168b.e();
        this.f17169c = true;
    }

    public final boolean n() {
        return this.f17169c;
    }

    public final Iterator<Map.Entry<T, Object>> o() {
        return this.f17170d ? new q2(this.f17168b.entrySet().iterator()) : this.f17168b.entrySet().iterator();
    }

    final Iterator<Map.Entry<T, Object>> p() {
        return this.f17170d ? new q2(this.f17168b.p().iterator()) : this.f17168b.p().iterator();
    }

    public final boolean q() {
        for (int i2 = 0; i2 < this.f17168b.k(); i2++) {
            if (!h(this.f17168b.i(i2))) {
                return false;
            }
        }
        Iterator it = this.f17168b.n().iterator();
        while (it.hasNext()) {
            if (!h((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int r() {
        int iM = 0;
        for (int i2 = 0; i2 < this.f17168b.k(); i2++) {
            iM += m(this.f17168b.i(i2));
        }
        Iterator it = this.f17168b.n().iterator();
        while (it.hasNext()) {
            iM += m((Map.Entry) it.next());
        }
        return iM;
    }

    private h2(boolean z) {
        this(u3.b(0));
        j();
    }

    private h2(u3<T, Object> u3Var) {
        this.f17168b = u3Var;
        j();
    }
}
