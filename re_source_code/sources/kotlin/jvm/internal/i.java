package kotlin.jvm.internal;

import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: FunctionReference.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends c implements FunctionBase, KFunction {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22945f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22946g;

    public i(int i2) {
        this(i2, c.NO_RECEIVER, null, null, null, 0);
    }

    @Override // kotlin.jvm.internal.c
    protected KCallable computeReflected() {
        return g0.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return getName().equals(iVar.getName()) && getSignature().equals(iVar.getSignature()) && this.f22946g == iVar.f22946g && this.f22945f == iVar.f22945f && m.a(getBoundReceiver(), iVar.getBoundReceiver()) && m.a(getOwner(), iVar.getOwner());
        }
        if (obj instanceof KFunction) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.f22945f;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.c
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    public String toString() {
        KCallable kCallableCompute = compute();
        if (kCallableCompute != this) {
            return kCallableCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }

    public i(int i2, Object obj) {
        this(i2, obj, null, null, null, 0);
    }

    public i(int i2, Object obj, Class cls, String str, String str2, int i3) {
        super(obj, cls, str, str2, (i3 & 1) == 1);
        this.f22945f = i2;
        this.f22946g = i3 >> 1;
    }
}
