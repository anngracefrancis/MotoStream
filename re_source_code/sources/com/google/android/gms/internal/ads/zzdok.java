package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class zzdok extends IOException {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private zzdpk f16036f;

    public zzdok(String str) {
        super(str);
        this.f16036f = null;
    }

    static zzdok a() {
        return new zzdok("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzdok b() {
        return new zzdok("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzdok c() {
        return new zzdok("CodedInputStream encountered a malformed varint.");
    }

    static zzdok d() {
        return new zzdok("Protocol message contained an invalid tag (zero).");
    }

    static zzdok e() {
        return new zzdok("Protocol message end-group tag did not match expected tag.");
    }

    static zzdol f() {
        return new zzdol("Protocol message tag had invalid wire type.");
    }

    static zzdok g() {
        return new zzdok("Failed to parse the message.");
    }

    static zzdok h() {
        return new zzdok("Protocol message had invalid UTF-8.");
    }

    public final zzdok i(zzdpk zzdpkVar) {
        this.f16036f = zzdpkVar;
        return this;
    }
}
