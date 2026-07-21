package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class x2 implements d3 {
    private d3[] a;

    x2(d3... d3VarArr) {
        this.a = d3VarArr;
    }

    @Override // com.google.android.gms.internal.measurement.d3
    public final boolean a(Class<?> cls) {
        for (d3 d3Var : this.a) {
            if (d3Var.a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.d3
    public final e3 b(Class<?> cls) {
        for (d3 d3Var : this.a) {
            if (d3Var.a(cls)) {
                return d3Var.b(cls);
            }
        }
        String name = cls.getName();
        throw new UnsupportedOperationException(name.length() != 0 ? "No factory is available for message type: ".concat(name) : new String("No factory is available for message type: "));
    }
}
