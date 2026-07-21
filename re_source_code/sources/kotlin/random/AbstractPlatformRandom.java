package kotlin.random;

import java.util.Random;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.d0.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0017"}, d2 = {"Lkotlin/random/AbstractPlatformRandom;", "Lkotlin/random/Random;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "nextBits", HttpUrl.FRAGMENT_ENCODE_SET, "bitCount", "nextBoolean", HttpUrl.FRAGMENT_ENCODE_SET, "nextBytes", HttpUrl.FRAGMENT_ENCODE_SET, "array", "nextDouble", HttpUrl.FRAGMENT_ENCODE_SET, "nextFloat", HttpUrl.FRAGMENT_ENCODE_SET, "nextInt", "until", "nextLong", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractPlatformRandom extends Random {
    @Override // kotlin.random.Random
    public int b(int i2) {
        return d.e(f().nextInt(), i2);
    }

    @Override // kotlin.random.Random
    public int c() {
        return f().nextInt();
    }

    @Override // kotlin.random.Random
    public int d(int i2) {
        return f().nextInt(i2);
    }

    public abstract Random f();
}
