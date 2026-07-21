package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzfo extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzgo f17411f;

    public zzfo(String str) {
        super(str);
        this.f17411f = null;
    }

    static zzfo a() {
        return new zzfo("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfo b() {
        return new zzfo("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfo c() {
        return new zzfo("CodedInputStream encountered a malformed varint.");
    }

    static zzfo d() {
        return new zzfo("Protocol message contained an invalid tag (zero).");
    }

    static zzfo e() {
        return new zzfo("Protocol message end-group tag did not match expected tag.");
    }

    static zzfn f() {
        return new zzfn("Protocol message tag had invalid wire type.");
    }

    static zzfo g() {
        return new zzfo("Failed to parse the message.");
    }

    static zzfo h() {
        return new zzfo("Protocol message had invalid UTF-8.");
    }
}
