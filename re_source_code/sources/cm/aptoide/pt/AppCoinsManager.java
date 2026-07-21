package cm.aptoide.pt;

import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.bonus.BonusAppcService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.p003y.Continuation;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AppCoinsManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/AppCoinsManager;", HttpUrl.FRAGMENT_ENCODE_SET, "bonusAppcService", "Lcm/aptoide/pt/bonus/BonusAppcService;", "(Lcm/aptoide/pt/bonus/BonusAppcService;)V", "getBonusAppc", "Lio/reactivex/Single;", "Lcm/aptoide/pt/bonus/BonusAppcModel;", "appcoins"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AppCoinsManager {
    private final BonusAppcService bonusAppcService;

    /* JADX INFO: renamed from: cm.aptoide.pt.AppCoinsManager$getBonusAppc$1, reason: invalid class name */
    /* JADX INFO: compiled from: AppCoinsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/bonus/BonusAppcModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "cm.aptoide.pt.AppCoinsManager$getBonusAppc$1", f = "AppCoinsManager.kt", l = {13}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BonusAppcModel>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return AppCoinsManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BonusAppcModel> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = kotlin.p003y.intrinsics.d.c();
            int i2 = this.label;
            if (i2 == 0) {
                kotlin.o.b(obj);
                BonusAppcService bonusAppcService = AppCoinsManager.this.bonusAppcService;
                this.label = 1;
                obj = bonusAppcService.getBonusAppc(this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return obj;
        }
    }

    public AppCoinsManager(BonusAppcService bonusAppcService) {
        kotlin.jvm.internal.m.f(bonusAppcService, "bonusAppcService");
        this.bonusAppcService = bonusAppcService;
    }

    public final h.a.s<BonusAppcModel> getBonusAppc() {
        return kotlinx.coroutines.rx2.h.c(null, new AnonymousClass1(null), 1, null);
    }
}
