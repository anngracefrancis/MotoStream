package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: PropertyReference.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b0 extends c implements KProperty {
    public b0() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b0) {
            b0 b0Var = (b0) obj;
            return getOwner().equals(b0Var.getOwner()) && getName().equals(b0Var.getName()) && getSignature().equals(b0Var.getSignature()) && m.a(getBoundReceiver(), b0Var.getBoundReceiver());
        }
        if (obj instanceof KProperty) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // kotlin.reflect.KProperty
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    public b0(Object obj) {
        super(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    public KProperty getReflected() {
        return (KProperty) super.getReflected();
    }

    public b0(Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
    }
}
