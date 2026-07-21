package androidx.media;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
class AudioAttributesImplBase implements AudioAttributesImpl {
    int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f1790b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f1791c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f1792d = -1;

    AudioAttributesImplBase() {
    }

    public int a() {
        return this.f1790b;
    }

    public int b() {
        int i2 = this.f1791c;
        int iC = c();
        if (iC == 6) {
            i2 |= 4;
        } else if (iC == 7) {
            i2 |= 1;
        }
        return i2 & 273;
    }

    public int c() {
        int i2 = this.f1792d;
        return i2 != -1 ? i2 : AudioAttributesCompat.a(false, this.f1791c, this.a);
    }

    public int d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        return this.f1790b == audioAttributesImplBase.a() && this.f1791c == audioAttributesImplBase.b() && this.a == audioAttributesImplBase.d() && this.f1792d == audioAttributesImplBase.f1792d;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f1790b), Integer.valueOf(this.f1791c), Integer.valueOf(this.a), Integer.valueOf(this.f1792d)});
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f1792d != -1) {
            sb.append(" stream=");
            sb.append(this.f1792d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.b(this.a));
        sb.append(" content=");
        sb.append(this.f1790b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f1791c).toUpperCase());
        return sb.toString();
    }
}
