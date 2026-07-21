package io.sentry;

/* JADX INFO: compiled from: Attachment.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s0 {
    private byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r2 f22690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f22691c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f22692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f22693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f22694f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f22695g;

    public s0(byte[] bArr, String str, String str2, boolean z) {
        this(bArr, str, str2, "event.attachment", z);
    }

    public static s0 a(byte[] bArr) {
        return new s0(bArr, "screenshot.png", "image/png", false);
    }

    public static s0 b(byte[] bArr) {
        return new s0(bArr, "thread-dump.txt", "text/plain", false);
    }

    public static s0 c(io.sentry.protocol.b0 b0Var) {
        return new s0((r2) b0Var, "view-hierarchy.json", "application/json", "event.view_hierarchy", false);
    }

    public String d() {
        return this.f22695g;
    }

    public byte[] e() {
        return this.a;
    }

    public String f() {
        return this.f22693e;
    }

    public String g() {
        return this.f22692d;
    }

    public String h() {
        return this.f22691c;
    }

    public r2 i() {
        return this.f22690b;
    }

    boolean j() {
        return this.f22694f;
    }

    public s0(byte[] bArr, String str, String str2, String str3, boolean z) {
        this.f22695g = "event.attachment";
        this.a = bArr;
        this.f22690b = null;
        this.f22692d = str;
        this.f22693e = str2;
        this.f22695g = str3;
        this.f22694f = z;
    }

    public s0(r2 r2Var, String str, String str2, String str3, boolean z) {
        this.f22695g = "event.attachment";
        this.a = null;
        this.f22690b = r2Var;
        this.f22692d = str;
        this.f22693e = str2;
        this.f22695g = str3;
        this.f22694f = z;
    }
}
