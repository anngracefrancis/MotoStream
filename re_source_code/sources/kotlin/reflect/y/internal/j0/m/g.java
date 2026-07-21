package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    private final boolean a;

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f24894b = new a();

        private a() {
            super(false, null);
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class b extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f24895b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(false, null);
            m.f(str, "error");
            this.f24895b = str;
        }
    }

    /* JADX INFO: compiled from: modifierChecks.kt */
    public static final class c extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f24896b = new c();

        private c() {
            super(true, null);
        }
    }

    private g(boolean z) {
        this.a = z;
    }

    public /* synthetic */ g(boolean z, kotlin.jvm.internal.g gVar) {
        this(z);
    }

    public final boolean a() {
        return this.a;
    }
}
