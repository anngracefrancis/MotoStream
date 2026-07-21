package cm.aptoide.pt.aab;

import kotlin.Metadata;
import kotlin.p003y.Continuation;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DynamicSplitsService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsService;", HttpUrl.FRAGMENT_ENCODE_SET, "getDynamicSplitsByMd5", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "apkMd5Sum", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface DynamicSplitsService {
    Object getDynamicSplitsByMd5(String str, Continuation<? super DynamicSplitsModel> continuation);
}
