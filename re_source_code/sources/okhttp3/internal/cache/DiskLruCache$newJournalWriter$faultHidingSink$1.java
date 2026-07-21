package okhttp3.internal.cache;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.internal.Util;

/* JADX INFO: compiled from: DiskLruCache.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/io/IOException;", "it", "Lkotlin/u;", "invoke", "(Ljava/io/IOException;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class DiskLruCache$newJournalWriter$faultHidingSink$1 extends Lambda implements Function1<IOException, u> {
    final /* synthetic */ DiskLruCache this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DiskLruCache$newJournalWriter$faultHidingSink$1(DiskLruCache diskLruCache) {
        super(1);
        this.this$0 = diskLruCache;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ u invoke(IOException iOException) {
        invoke2(iOException);
        return u.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(IOException iOException) {
        m.f(iOException, "it");
        DiskLruCache diskLruCache = this.this$0;
        if (!Util.assertionsEnabled || Thread.holdsLock(diskLruCache)) {
            this.this$0.hasJournalErrors = true;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        m.e(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(diskLruCache);
        throw new AssertionError(sb.toString());
    }
}
