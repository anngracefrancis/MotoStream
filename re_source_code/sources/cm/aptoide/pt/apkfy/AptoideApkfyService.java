package cm.aptoide.pt.apkfy;

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

/* JADX INFO: compiled from: AptoideApkfyService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcm/aptoide/pt/apkfy/AptoideApkfyService;", "Lcm/aptoide/pt/apkfy/ApkfyService;", "serviceApi", "Lcm/aptoide/pt/apkfy/AptoideApkfyService$ServiceApi;", "(Lcm/aptoide/pt/apkfy/AptoideApkfyService$ServiceApi;)V", "getApkfy", "Lcm/aptoide/pt/apkfy/ApkfyModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapErrorResponse", "ServiceApi", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AptoideApkfyService implements ApkfyService {
    private final ServiceApi serviceApi;

    /* JADX INFO: compiled from: AptoideApkfyService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcm/aptoide/pt/apkfy/AptoideApkfyService$ServiceApi;", HttpUrl.FRAGMENT_ENCODE_SET, "getApkfyModel", "Lretrofit2/Response;", "Lcm/aptoide/pt/apkfy/ApkfyResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ServiceApi {
        @GET("apkfy")
        Object getApkfyModel(Continuation<? super Response<ApkfyResponse>> continuation);
    }

    /* JADX INFO: renamed from: cm.aptoide.pt.apkfy.AptoideApkfyService$getApkfy$2, reason: invalid class name */
    /* JADX INFO: compiled from: AptoideApkfyService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/apkfy/ApkfyModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "cm.aptoide.pt.apkfy.AptoideApkfyService$getApkfy$2", f = "AptoideApkfyService.kt", l = {12}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApkfyModel>, Object> {
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return AptoideApkfyService.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApkfyModel> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                ServiceApi serviceApi = AptoideApkfyService.this.serviceApi;
                this.label = 1;
                obj = serviceApi.getApkfyModel(this);
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
            ApkfyResponse apkfyResponse = (ApkfyResponse) response.body();
            return (!response.isSuccessful() || apkfyResponse == null) ? AptoideApkfyService.this.mapErrorResponse() : ApkfyResponseKt.mapToApkfyModel(apkfyResponse);
        }
    }

    public AptoideApkfyService(ServiceApi serviceApi) {
        m.f(serviceApi, "serviceApi");
        this.serviceApi = serviceApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApkfyModel mapErrorResponse() {
        return new ApkfyModel(HttpUrl.FRAGMENT_ENCODE_SET, null, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // cm.aptoide.pt.apkfy.ApkfyService
    public Object getApkfy(Continuation<? super ApkfyModel> continuation) {
        return h.e(Dispatchers.b(), new AnonymousClass2(null), continuation);
    }
}
