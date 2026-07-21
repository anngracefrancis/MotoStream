package com.google.firebase.crashlytics.internal.p;

import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_FilesPayload_File.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends f0.d.b {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f19362b;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_FilesPayload_File.java */
    static final class b extends f0.d.b.a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private byte[] f19363b;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.d.b.a
        public f0.d.b a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " filename";
            }
            if (this.f19363b == null) {
                str2 = str2 + " contents";
            }
            if (str2.isEmpty()) {
                return new g(this.a, this.f19363b);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.d.b.a
        public f0.d.b.a b(byte[] bArr) {
            if (bArr == null) {
                throw new NullPointerException("Null contents");
            }
            this.f19363b = bArr;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.d.b.a
        public f0.d.b.a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null filename");
            }
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.d.b
    public byte[] b() {
        return this.f19362b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.d.b
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.d.b)) {
            return false;
        }
        f0.d.b bVar = (f0.d.b) obj;
        if (this.a.equals(bVar.c())) {
            if (Arrays.equals(this.f19362b, bVar instanceof g ? ((g) bVar).f19362b : bVar.b())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f19362b);
    }

    public String toString() {
        return "File{filename=" + this.a + ", contents=" + Arrays.toString(this.f19362b) + "}";
    }

    private g(String str, byte[] bArr) {
        this.a = str;
        this.f19362b = bArr;
    }
}
