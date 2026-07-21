package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.e0.b, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lkotlin/ranges/CharProgressionIterator;", "Lkotlin/collections/CharIterator;", "first", HttpUrl.FRAGMENT_ENCODE_SET, "last", "step", HttpUrl.FRAGMENT_ENCODE_SET, "(CCI)V", "finalElement", "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "getStep", "()I", "nextChar", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CharProgressionIterator extends CharIterator {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f22965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22966g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f22967h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f22968i;

    public CharProgressionIterator(char c2, char c3, int i2) {
        this.f22965f = i2;
        this.f22966g = c3;
        boolean z = true;
        if (i2 <= 0 ? m.h(c2, c3) < 0 : m.h(c2, c3) > 0) {
            z = false;
        }
        this.f22967h = z;
        this.f22968i = z ? c2 : c3;
    }

    @Override // kotlin.collections.CharIterator
    public char b() {
        int i2 = this.f22968i;
        if (i2 != this.f22966g) {
            this.f22968i = this.f22965f + i2;
        } else {
            if (!this.f22967h) {
                throw new NoSuchElementException();
            }
            this.f22967h = false;
        }
        return (char) i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22967h;
    }
}
