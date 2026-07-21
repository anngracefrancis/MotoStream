package cm.aptoide.pt.app.mmpcampaigns;

import java.io.IOException;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.c;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlin.p003y.j.p004a.SuspendLambda;
import kotlin.p003y.j.p004a.h;
import kotlin.u;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: CampaignApiRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcm/aptoide/pt/app/mmpcampaigns/CampaignApiRepository;", "Lcm/aptoide/pt/app/mmpcampaigns/CampaignRepository;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "knock", HttpUrl.FRAGMENT_ENCODE_SET, "url", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CampaignApiRepository implements CampaignRepository {
    private final OkHttpClient client;

    /* JADX INFO: renamed from: cm.aptoide.pt.app.mmpcampaigns.CampaignApiRepository$knock$2, reason: invalid class name */
    /* JADX INFO: compiled from: CampaignApiRepository.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "cm.aptoide.pt.app.mmpcampaigns.CampaignApiRepository$knock$2", f = "CampaignApiRepository.kt", l = {33}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {
        final /* synthetic */ String $url;
        Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return CampaignApiRepository.this.new AnonymousClass2(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                CampaignApiRepository campaignApiRepository = CampaignApiRepository.this;
                String str = this.$url;
                this.L$0 = campaignApiRepository;
                this.L$1 = str;
                this.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(c.b(this), 1);
                cancellableContinuationImpl.z();
                campaignApiRepository.client.newCall(new Request.Builder().url(str).build()).enqueue(new Callback() { // from class: cm.aptoide.pt.app.mmpcampaigns.CampaignApiRepository$knock$2$1$1
                    @Override // okhttp3.Callback
                    public void onFailure(Call call, IOException e2) {
                        m.f(call, "call");
                        m.f(e2, "e");
                        if (cancellableContinuationImpl.b()) {
                            CancellableContinuation<u> cancellableContinuation = cancellableContinuationImpl;
                            Result.a aVar = Result.f25108f;
                            cancellableContinuation.resumeWith(Result.a(u.a));
                        }
                    }

                    @Override // okhttp3.Callback
                    public void onResponse(Call call, Response response) throws IOException {
                        m.f(call, "call");
                        m.f(response, "response");
                        if (cancellableContinuationImpl.b()) {
                            CancellableContinuation<u> cancellableContinuation = cancellableContinuationImpl;
                            Result.a aVar = Result.f25108f;
                            cancellableContinuation.resumeWith(Result.a(u.a));
                        }
                        ResponseBody responseBodyBody = response.body();
                        if (responseBodyBody != null) {
                            responseBodyBody.close();
                        }
                    }
                });
                Object objW = cancellableContinuationImpl.w();
                if (objW == d.c()) {
                    h.c(this);
                }
                if (objW == objC) {
                    return objC;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
            }
            return u.a;
        }
    }

    @Inject
    public CampaignApiRepository(OkHttpClient okHttpClient) {
        m.f(okHttpClient, "client");
        this.client = okHttpClient;
    }

    @Override // cm.aptoide.pt.app.mmpcampaigns.CampaignRepository
    public Object knock(String str, Continuation<? super u> continuation) {
        Object objE = kotlinx.coroutines.h.e(Dispatchers.b(), new AnonymousClass2(str, null), continuation);
        return objE == d.c() ? objE : u.a;
    }
}
