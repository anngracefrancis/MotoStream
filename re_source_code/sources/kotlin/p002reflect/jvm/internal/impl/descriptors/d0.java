package kotlin.p002reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: Modality.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum d0 {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25129f = new a(null);

    /* JADX INFO: compiled from: Modality.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final d0 a(boolean z, boolean z2, boolean z3) {
            if (z) {
                return d0.SEALED;
            }
            if (z2) {
                return d0.ABSTRACT;
            }
            return z3 ? d0.OPEN : d0.FINAL;
        }
    }
}
