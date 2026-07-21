package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ModalityUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 {
    public static final boolean a(e eVar) {
        m.f(eVar, "<this>");
        return eVar.j() == d0.FINAL && eVar.i() != f.ENUM_CLASS;
    }
}
