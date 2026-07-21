package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class v3 extends b4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ u3 f17272g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private v3(u3 u3Var) {
        super(u3Var, null);
        this.f17272g = u3Var;
    }

    @Override // com.google.android.gms.internal.measurement.b4, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new w3(this.f17272g, null);
    }

    /* synthetic */ v3(u3 u3Var, t3 t3Var) {
        this(u3Var);
    }
}
