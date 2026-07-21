package kotlin.reflect.y.internal.j0.d.a;

import cm.aptoide.pt.dataprovider.model.v7.Malware;
import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: ReportLevel.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum f0 {
    IGNORE("ignore"),
    WARN(Malware.WARN),
    STRICT("strict");


    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f23365f = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f23370k;

    /* JADX INFO: compiled from: ReportLevel.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    f0(String str) {
        this.f23370k = str;
    }

    public final String k() {
        return this.f23370k;
    }

    public final boolean q() {
        return this == IGNORE;
    }

    public final boolean u() {
        return this == WARN;
    }
}
