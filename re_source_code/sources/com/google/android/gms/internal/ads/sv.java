package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes2.dex */
final class sv implements yv {
    private yv[] a;

    sv(yv... yvVarArr) {
        this.a = yvVarArr;
    }

    @Override // com.google.android.gms.internal.ads.yv
    public final xv a(Class<?> cls) {
        for (yv yvVar : this.a) {
            if (yvVar.b(cls)) {
                return yvVar.a(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }

    @Override // com.google.android.gms.internal.ads.yv
    public final boolean b(Class<?> cls) {
        for (yv yvVar : this.a) {
            if (yvVar.b(cls)) {
                return true;
            }
        }
        return false;
    }
}
