package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class yu<FieldDescriptorType extends zzdnu<FieldDescriptorType>> {
    private static final yu a = new yu(true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13657d = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ow<FieldDescriptorType, Object> f13655b = ow.p(16);

    private yu() {
    }

    static int f(zzdri zzdriVar, int i2, Object obj) {
        int iH0 = zzdni.h0(i2);
        if (zzdriVar == zzdri.o) {
            zzdod.j((zzdpk) obj);
            iH0 <<= 1;
        }
        return iH0 + q(zzdriVar, obj);
    }

    private final Object g(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f13655b.get(fielddescriptortype);
        return obj instanceof zzdon ? zzdon.e() : obj;
    }

    private final void i(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.t()) {
            j(fielddescriptortype.p(), obj);
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
                j(fielddescriptortype.p(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof zzdon) {
            this.f13657d = true;
        }
        this.f13655b.put(fielddescriptortype, obj);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    private static void j(zzdri zzdriVar, Object obj) {
        zzdod.a(obj);
        boolean z = true;
        boolean z2 = false;
        switch (zu.a[zzdriVar.g().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                z2 = z;
                break;
            case 2:
                z = obj instanceof Long;
                z2 = z;
                break;
            case 3:
                z = obj instanceof Float;
                z2 = z;
                break;
            case 4:
                z = obj instanceof Double;
                z2 = z;
                break;
            case 5:
                z = obj instanceof Boolean;
                z2 = z;
                break;
            case 6:
                z = obj instanceof String;
                z2 = z;
                break;
            case 7:
                if (!(obj instanceof zzdmr) && !(obj instanceof byte[])) {
                    z = false;
                }
                z2 = z;
                break;
            case 8:
                if (!(obj instanceof Integer) && !(obj instanceof zzdoe)) {
                    z = false;
                }
                z2 = z;
                break;
            case 9:
                if (!(obj instanceof zzdpk) && !(obj instanceof zzdon)) {
                    z = false;
                }
                z2 = z;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static Object k(Object obj) {
        if (obj instanceof zzdpr) {
            return ((zzdpr) obj).e0();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static <T extends zzdnu<T>> yu<T> m() {
        return a;
    }

    private static int p(zzdnu<?> zzdnuVar, Object obj) {
        zzdri zzdriVarP = zzdnuVar.p();
        int i2 = zzdnuVar.i();
        if (!zzdnuVar.t()) {
            return f(zzdriVarP, i2, obj);
        }
        int iF = 0;
        if (zzdnuVar.w()) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                iF += q(zzdriVarP, it.next());
            }
            return zzdni.h0(i2) + iF + zzdni.p0(iF);
        }
        Iterator it2 = ((List) obj).iterator();
        while (it2.hasNext()) {
            iF += f(zzdriVarP, i2, it2.next());
        }
        return iF;
    }

    private static int q(zzdri zzdriVar, Object obj) {
        switch (zu.f13722b[zzdriVar.ordinal()]) {
            case 1:
                return zzdni.H(((Double) obj).doubleValue());
            case 2:
                return zzdni.s0(((Float) obj).floatValue());
            case 3:
                return zzdni.V(((Long) obj).longValue());
            case 4:
                return zzdni.W(((Long) obj).longValue());
            case 5:
                return zzdni.i0(((Integer) obj).intValue());
            case 6:
                return zzdni.Y(((Long) obj).longValue());
            case 7:
                return zzdni.l0(((Integer) obj).intValue());
            case 8:
                return zzdni.G(((Boolean) obj).booleanValue());
            case 9:
                return zzdni.C0((zzdpk) obj);
            case 10:
                return obj instanceof zzdon ? zzdni.e((zzdon) obj) : zzdni.A0((zzdpk) obj);
            case 11:
                return obj instanceof zzdmr ? zzdni.Q((zzdmr) obj) : zzdni.r0((String) obj);
            case 12:
                return obj instanceof zzdmr ? zzdni.Q((zzdmr) obj) : zzdni.p((byte[]) obj);
            case 13:
                return zzdni.j0(((Integer) obj).intValue());
            case 14:
                return zzdni.m0(((Integer) obj).intValue());
            case 15:
                return zzdni.Z(((Long) obj).longValue());
            case 16:
                return zzdni.k0(((Integer) obj).intValue());
            case 17:
                return zzdni.X(((Long) obj).longValue());
            case 18:
                return obj instanceof zzdoe ? zzdni.n0(((zzdoe) obj).i()) : zzdni.n0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean r(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.s() == zzdrn.MESSAGE) {
            if (key.t()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzdpk) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzdpk)) {
                    if (value instanceof zzdon) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzdpk) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void s(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdon) {
            value = zzdon.e();
        }
        if (key.t()) {
            Object objG = g(key);
            if (objG == null) {
                objG = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objG).add(k(it.next()));
            }
            this.f13655b.put(key, objG);
            return;
        }
        if (key.s() != zzdrn.MESSAGE) {
            this.f13655b.put(key, k(value));
            return;
        }
        Object objG2 = g(key);
        if (objG2 == null) {
            this.f13655b.put(key, k(value));
        } else {
            this.f13655b.put(key, objG2 instanceof zzdpr ? key.C((zzdpr) objG2, (zzdpr) value) : key.r(((zzdpk) objG2).b(), (zzdpk) value).p0());
        }
    }

    private static int t(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.s() != zzdrn.MESSAGE || key.t() || key.w()) {
            return p(key, value);
        }
        return value instanceof zzdon ? zzdni.y(entry.getKey().i(), (zzdon) value) : zzdni.O(entry.getKey().i(), (zzdpk) value);
    }

    final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        return this.f13657d ? new jv(this.f13655b.j().iterator()) : this.f13655b.j().iterator();
    }

    final boolean b() {
        return this.f13655b.isEmpty();
    }

    public final boolean c() {
        return this.f13656c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        yu yuVar = new yu();
        for (int i2 = 0; i2 < this.f13655b.h(); i2++) {
            Map.Entry<K, Object> entryQ = this.f13655b.q(i2);
            yuVar.i((zzdnu) entryQ.getKey(), entryQ.getValue());
        }
        Iterator it = this.f13655b.i().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            yuVar.i((zzdnu) entry.getKey(), entry.getValue());
        }
        yuVar.f13657d = this.f13657d;
        return yuVar;
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f13655b.h(); i2++) {
            if (!r(this.f13655b.q(i2))) {
                return false;
            }
        }
        Iterator it = this.f13655b.i().iterator();
        while (it.hasNext()) {
            if (!r((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        return this.f13657d ? new jv(this.f13655b.entrySet().iterator()) : this.f13655b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof yu) {
            return this.f13655b.equals(((yu) obj).f13655b);
        }
        return false;
    }

    public final void h(yu<FieldDescriptorType> yuVar) {
        for (int i2 = 0; i2 < yuVar.f13655b.h(); i2++) {
            s(yuVar.f13655b.q(i2));
        }
        Iterator it = yuVar.f13655b.i().iterator();
        while (it.hasNext()) {
            s((Map.Entry) it.next());
        }
    }

    public final int hashCode() {
        return this.f13655b.hashCode();
    }

    public final void l() {
        if (this.f13656c) {
            return;
        }
        this.f13655b.f();
        this.f13656c = true;
    }

    public final int n() {
        int iP = 0;
        for (int i2 = 0; i2 < this.f13655b.h(); i2++) {
            Map.Entry<K, Object> entryQ = this.f13655b.q(i2);
            iP += p((zzdnu) entryQ.getKey(), entryQ.getValue());
        }
        Iterator it = this.f13655b.i().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            iP += p((zzdnu) entry.getKey(), entry.getValue());
        }
        return iP;
    }

    public final int o() {
        int iT = 0;
        for (int i2 = 0; i2 < this.f13655b.h(); i2++) {
            iT += t(this.f13655b.q(i2));
        }
        Iterator it = this.f13655b.i().iterator();
        while (it.hasNext()) {
            iT += t((Map.Entry) it.next());
        }
        return iT;
    }

    private yu(boolean z) {
        l();
    }
}
