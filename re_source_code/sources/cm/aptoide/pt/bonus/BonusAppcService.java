package cm.aptoide.pt.bonus;

import kotlin.Metadata;
import kotlin.p003y.Continuation;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: BonusAppcService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcm/aptoide/pt/bonus/BonusAppcService;", HttpUrl.FRAGMENT_ENCODE_SET, "getBonusAppc", "Lcm/aptoide/pt/bonus/BonusAppcModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appcoins"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BonusAppcService {
    Object getBonusAppc(Continuation<? super BonusAppcModel> continuation);
}
