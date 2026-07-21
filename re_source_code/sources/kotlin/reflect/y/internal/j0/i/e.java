package kotlin.reflect.y.internal.j0.i;

/* JADX INFO: compiled from: ExternalOverridabilityCondition.java */
/* JADX INFO: loaded from: classes3.dex */
public interface e {

    /* JADX INFO: compiled from: ExternalOverridabilityCondition.java */
    public enum a {
        CONFLICTS_ONLY,
        SUCCESS_ONLY,
        BOTH
    }

    /* JADX INFO: compiled from: ExternalOverridabilityCondition.java */
    public enum b {
        OVERRIDABLE,
        CONFLICT,
        INCOMPATIBLE,
        UNKNOWN
    }

    a a();

    b b(kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar, kotlin.p002reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.p002reflect.jvm.internal.impl.descriptors.e eVar);
}
