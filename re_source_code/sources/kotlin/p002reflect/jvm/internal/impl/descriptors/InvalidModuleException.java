package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: InvalidModuleException.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InvalidModuleException extends IllegalStateException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InvalidModuleException(String str) {
        super(str);
        m.f(str, "message");
    }
}
