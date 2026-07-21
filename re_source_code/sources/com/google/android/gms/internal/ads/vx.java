package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
final class vx implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzdrs<?, ?> f13470f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f13471g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List<Object> f13472h = new ArrayList();

    vx() {
    }

    private final byte[] b() throws IOException {
        byte[] bArr = new byte[f()];
        d(zzdrp.e(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final vx clone() {
        vx vxVar = new vx();
        try {
            vxVar.f13470f = this.f13470f;
            List<Object> list = this.f13472h;
            if (list == null) {
                vxVar.f13472h = null;
            } else {
                vxVar.f13472h.addAll(list);
            }
            Object obj = this.f13471g;
            if (obj != null) {
                if (obj instanceof zzdrw) {
                    vxVar.f13471g = (zzdrw) ((zzdrw) obj).clone();
                } else if (obj instanceof byte[]) {
                    vxVar.f13471g = ((byte[]) obj).clone();
                } else {
                    int i2 = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length][];
                        vxVar.f13471g = bArr2;
                        while (i2 < bArr.length) {
                            bArr2[i2] = (byte[]) bArr[i2].clone();
                            i2++;
                        }
                    } else if (obj instanceof boolean[]) {
                        vxVar.f13471g = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        vxVar.f13471g = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        vxVar.f13471g = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        vxVar.f13471g = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        vxVar.f13471g = ((double[]) obj).clone();
                    } else if (obj instanceof zzdrw[]) {
                        zzdrw[] zzdrwVarArr = (zzdrw[]) obj;
                        zzdrw[] zzdrwVarArr2 = new zzdrw[zzdrwVarArr.length];
                        vxVar.f13471g = zzdrwVarArr2;
                        while (i2 < zzdrwVarArr.length) {
                            zzdrwVarArr2[i2] = (zzdrw) zzdrwVarArr[i2].clone();
                            i2++;
                        }
                    }
                }
            }
            return vxVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    final void d(zzdrp zzdrpVar) throws IOException {
        if (this.f13471g != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> it = this.f13472h.iterator();
        if (it.hasNext()) {
            it.next();
            throw new NoSuchMethodError();
        }
    }

    public final boolean equals(Object obj) {
        List<Object> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vx)) {
            return false;
        }
        vx vxVar = (vx) obj;
        if (this.f13471g == null || vxVar.f13471g == null) {
            List<Object> list2 = this.f13472h;
            if (list2 != null && (list = vxVar.f13472h) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(b(), vxVar.b());
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }
        zzdrs<?, ?> zzdrsVar = this.f13470f;
        if (zzdrsVar != vxVar.f13470f) {
            return false;
        }
        if (!zzdrsVar.a.isArray()) {
            return this.f13471g.equals(vxVar.f13471g);
        }
        Object obj2 = this.f13471g;
        if (obj2 instanceof byte[]) {
            return Arrays.equals((byte[]) obj2, (byte[]) vxVar.f13471g);
        }
        if (obj2 instanceof int[]) {
            return Arrays.equals((int[]) obj2, (int[]) vxVar.f13471g);
        }
        if (obj2 instanceof long[]) {
            return Arrays.equals((long[]) obj2, (long[]) vxVar.f13471g);
        }
        if (obj2 instanceof float[]) {
            return Arrays.equals((float[]) obj2, (float[]) vxVar.f13471g);
        }
        if (obj2 instanceof double[]) {
            return Arrays.equals((double[]) obj2, (double[]) vxVar.f13471g);
        }
        return obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) vxVar.f13471g) : Arrays.deepEquals((Object[]) obj2, (Object[]) vxVar.f13471g);
    }

    final int f() {
        if (this.f13471g != null) {
            throw new NoSuchMethodError();
        }
        Iterator<Object> it = this.f13472h.iterator();
        if (!it.hasNext()) {
            return 0;
        }
        it.next();
        throw new NoSuchMethodError();
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(b()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
