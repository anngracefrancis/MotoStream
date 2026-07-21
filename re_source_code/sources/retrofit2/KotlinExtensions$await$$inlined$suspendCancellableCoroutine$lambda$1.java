package retrofit2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "it", "Lkotlin/u;", "invoke", "(Ljava/lang/Throwable;)V", "retrofit2/KotlinExtensions$await$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1 extends Lambda implements Function1<Throwable, u> {
    final /* synthetic */ Call $this_await$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(Call call) {
        super(1);
        this.$this_await$inlined = call;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ u invoke(Throwable th) {
        invoke2(th);
        return u.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$this_await$inlined.cancel();
    }
}
