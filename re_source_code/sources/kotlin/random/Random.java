package kotlin.random;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.internal.b;
import kotlin.jvm.internal.g;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.d0.c, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b'\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0016H\u0016¨\u0006\u0018"}, d2 = {"Lkotlin/random/Random;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "nextBits", HttpUrl.FRAGMENT_ENCODE_SET, "bitCount", "nextBoolean", HttpUrl.FRAGMENT_ENCODE_SET, "nextBytes", HttpUrl.FRAGMENT_ENCODE_SET, "array", "fromIndex", "toIndex", "size", "nextDouble", HttpUrl.FRAGMENT_ENCODE_SET, "until", "from", "nextFloat", HttpUrl.FRAGMENT_ENCODE_SET, "nextInt", "nextLong", HttpUrl.FRAGMENT_ENCODE_SET, "Default", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class Random {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f22952f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Random f22953g = b.a.b();

    /* JADX INFO: renamed from: kotlin.d0.c$a */
    /* JADX INFO: compiled from: Random.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lkotlin/random/Random$Default;", "Lkotlin/random/Random;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "defaultRandom", "nextBits", HttpUrl.FRAGMENT_ENCODE_SET, "bitCount", "nextBoolean", HttpUrl.FRAGMENT_ENCODE_SET, "nextBytes", HttpUrl.FRAGMENT_ENCODE_SET, "array", "fromIndex", "toIndex", "size", "nextDouble", HttpUrl.FRAGMENT_ENCODE_SET, "until", "from", "nextFloat", HttpUrl.FRAGMENT_ENCODE_SET, "nextInt", "nextLong", HttpUrl.FRAGMENT_ENCODE_SET, "writeReplace", HttpUrl.FRAGMENT_ENCODE_SET, "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Random implements Serializable {

        /* JADX INFO: renamed from: kotlin.d0.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Random.kt */
        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\bÂ\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/random/Random$Default$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "serialVersionUID", HttpUrl.FRAGMENT_ENCODE_SET, "readResolve", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
        private static final class C0313a implements Serializable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final C0313a f22954f = new C0313a();

            private C0313a() {
            }

            private final Object readResolve() {
                return Random.f22952f;
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        private final Object writeReplace() {
            return C0313a.f22954f;
        }

        @Override // kotlin.random.Random
        public int b(int i2) {
            return Random.f22953g.b(i2);
        }

        @Override // kotlin.random.Random
        public int c() {
            return Random.f22953g.c();
        }

        @Override // kotlin.random.Random
        public int d(int i2) {
            return Random.f22953g.d(i2);
        }

        @Override // kotlin.random.Random
        public int e(int i2, int i3) {
            return Random.f22953g.e(i2, i3);
        }
    }

    public abstract int b(int i2);

    public abstract int c();

    public abstract int d(int i2);

    public int e(int i2, int i3) {
        int iC;
        int i4;
        int iB;
        int iC2;
        boolean z;
        d.b(i2, i3);
        int i5 = i3 - i2;
        if (i5 > 0 || i5 == Integer.MIN_VALUE) {
            if (((-i5) & i5) == i5) {
                iB = b(d.c(i5));
            } else {
                do {
                    iC = c() >>> 1;
                    i4 = iC % i5;
                } while ((iC - i4) + (i5 - 1) < 0);
                iB = i4;
            }
            return i2 + iB;
        }
        do {
            iC2 = c();
            z = false;
            if (i2 <= iC2 && iC2 < i3) {
                z = true;
            }
        } while (!z);
        return iC2;
    }
}
