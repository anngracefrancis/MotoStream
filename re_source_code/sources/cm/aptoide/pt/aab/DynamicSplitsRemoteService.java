package cm.aptoide.pt.aab;

import java.util.Collections;
import java.util.List;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h;
import okhttp3.HttpUrl;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* JADX INFO: compiled from: DynamicSplitsRemoteService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsRemoteService;", "Lcm/aptoide/pt/aab/DynamicSplitsService;", "dynamicSplitsApi", "Lcm/aptoide/pt/aab/DynamicSplitsRemoteService$DynamicSplitsApi;", "mapper", "Lcm/aptoide/pt/aab/DynamicSplitsMapper;", "(Lcm/aptoide/pt/aab/DynamicSplitsRemoteService$DynamicSplitsApi;Lcm/aptoide/pt/aab/DynamicSplitsMapper;)V", "getDynamicSplitsByMd5", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "apkMd5Sum", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapErrorResponse", "mapResponse", "dynamicSplitsResponseBody", "Lcm/aptoide/pt/aab/DynamicSplitsResponse;", "DynamicSplitsApi", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DynamicSplitsRemoteService implements DynamicSplitsService {
    private final DynamicSplitsApi dynamicSplitsApi;
    private final DynamicSplitsMapper mapper;

    /* JADX INFO: compiled from: DynamicSplitsRemoteService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsRemoteService$DynamicSplitsApi;", HttpUrl.FRAGMENT_ENCODE_SET, "getDynamicSplitsByMd5", "Lretrofit2/Response;", "Lcm/aptoide/pt/aab/DynamicSplitsResponse;", "md5", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface DynamicSplitsApi {
        @GET("app/getDynamicSplits")
        Object getDynamicSplitsByMd5(@Query("apk_md5sum") String str, Continuation<? super Response<DynamicSplitsResponse>> continuation);
    }

    /* JADX INFO: renamed from: cm.aptoide.pt.aab.DynamicSplitsRemoteService$getDynamicSplitsByMd5$2, reason: invalid class name */
    /* JADX INFO: compiled from: DynamicSplitsRemoteService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "cm.aptoide.pt.aab.DynamicSplitsRemoteService$getDynamicSplitsByMd5$2", f = "DynamicSplitsRemoteService.kt", l = {18}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DynamicSplitsModel>, Object> {
        final /* synthetic */ String $apkMd5Sum;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$apkMd5Sum = str;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return DynamicSplitsRemoteService.this.new AnonymousClass2(this.$apkMd5Sum, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DynamicSplitsModel> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                DynamicSplitsApi dynamicSplitsApi = DynamicSplitsRemoteService.this.dynamicSplitsApi;
                String str = this.$apkMd5Sum;
                this.label = 1;
                obj = dynamicSplitsApi.getDynamicSplitsByMd5(str, this);
                if (obj == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
            }
            Response response = (Response) obj;
            DynamicSplitsResponse dynamicSplitsResponse = (DynamicSplitsResponse) response.body();
            return (!response.isSuccessful() || dynamicSplitsResponse == null) ? DynamicSplitsRemoteService.this.mapErrorResponse() : DynamicSplitsRemoteService.this.mapResponse(dynamicSplitsResponse);
        }
    }

    public DynamicSplitsRemoteService(DynamicSplitsApi dynamicSplitsApi, DynamicSplitsMapper dynamicSplitsMapper) {
        m.f(dynamicSplitsApi, "dynamicSplitsApi");
        m.f(dynamicSplitsMapper, "mapper");
        this.dynamicSplitsApi = dynamicSplitsApi;
        this.mapper = dynamicSplitsMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DynamicSplitsModel mapErrorResponse() {
        List listEmptyList = Collections.emptyList();
        m.e(listEmptyList, "emptyList()");
        return new DynamicSplitsModel(listEmptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DynamicSplitsModel mapResponse(DynamicSplitsResponse dynamicSplitsResponseBody) {
        DynamicSplitsMapper dynamicSplitsMapper = this.mapper;
        List<DynamicSplitsResponse.DynamicSplit> dynamicSplitList = dynamicSplitsResponseBody.getDynamicSplitList();
        m.e(dynamicSplitList, "dynamicSplitsResponseBody.dynamicSplitList");
        return new DynamicSplitsModel(dynamicSplitsMapper.mapDynamicSplits(dynamicSplitList));
    }

    @Override // cm.aptoide.pt.aab.DynamicSplitsService
    public Object getDynamicSplitsByMd5(String str, Continuation<? super DynamicSplitsModel> continuation) {
        return h.e(Dispatchers.b(), new AnonymousClass2(str, null), continuation);
    }
}
