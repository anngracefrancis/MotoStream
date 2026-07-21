package kotlinx.coroutines;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlinx.coroutines.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CancellableContinuationImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/Active;", "Lkotlinx/coroutines/NotCompleted;", "()V", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class Active implements NotCompleted {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Active f25723f = new Active();

    private Active() {
    }

    public String toString() {
        return "Active";
    }
}
