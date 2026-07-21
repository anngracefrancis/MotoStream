package kotlinx.coroutines.rx2;

import h.a.y.d;
import kotlin.Metadata;
import kotlinx.coroutines.Job;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.b3.c, reason: from Kotlin metadata */
/* JADX INFO: compiled from: RxCancellable.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/rx2/RxCancellable;", "Lio/reactivex/functions/Cancellable;", "job", "Lkotlinx/coroutines/Job;", "(Lkotlinx/coroutines/Job;)V", "cancel", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-rx2"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RxCancellable implements d {
    private final Job a;

    public RxCancellable(Job job) {
        this.a = job;
    }

    @Override // h.a.y.d
    public void cancel() {
        Job.a.a(this.a, null, 1, null);
    }
}
