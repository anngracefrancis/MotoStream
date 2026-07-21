package cm.aptoide.pt.aab;

import h.a.s;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.rx2.h;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: DynamicSplitsManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsManager;", HttpUrl.FRAGMENT_ENCODE_SET, "dynamicSplitsService", "Lcm/aptoide/pt/aab/DynamicSplitsService;", "(Lcm/aptoide/pt/aab/DynamicSplitsService;)V", "getAppSplitsByMd5", "Lio/reactivex/Single;", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "apkMd5Sum", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DynamicSplitsManager {
    private final DynamicSplitsService dynamicSplitsService;

    /* JADX INFO: renamed from: cm.aptoide.pt.aab.DynamicSplitsManager$getAppSplitsByMd5$1, reason: invalid class name */
    /* JADX INFO: compiled from: DynamicSplitsManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "cm.aptoide.pt.aab.DynamicSplitsManager$getAppSplitsByMd5$1", f = "DynamicSplitsManager.kt", l = {9}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DynamicSplitsModel>, Object> {
        final /* synthetic */ String $apkMd5Sum;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$apkMd5Sum = str;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return DynamicSplitsManager.this.new AnonymousClass1(this.$apkMd5Sum, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DynamicSplitsModel> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                DynamicSplitsService dynamicSplitsService = DynamicSplitsManager.this.dynamicSplitsService;
                String str = this.$apkMd5Sum;
                this.label = 1;
                obj = dynamicSplitsService.getDynamicSplitsByMd5(str, this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
            }
            return obj;
        }
    }

    public DynamicSplitsManager(DynamicSplitsService dynamicSplitsService) {
        m.f(dynamicSplitsService, "dynamicSplitsService");
        this.dynamicSplitsService = dynamicSplitsService;
    }

    public s<DynamicSplitsModel> getAppSplitsByMd5(String str) {
        m.f(str, "apkMd5Sum");
        return h.c(null, new AnonymousClass1(str, null), 1, null);
    }
}
