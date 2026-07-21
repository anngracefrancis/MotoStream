package com.aptoide.aptoide_ab_testing.network;

import com.aptoide.aptoide_ab_testing.FlagrException;
import com.aptoide.aptoide_ab_testing.model.EvalContext;
import com.aptoide.aptoide_ab_testing.model.Flag;
import com.aptoide.aptoide_ab_testing.model.PostEvaluationResponseJson;
import com.aptoide.aptoide_ab_testing.service.FlagrService;
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
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/* JADX INFO: compiled from: FlagrApiService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/aptoide/aptoide_ab_testing/network/FlagrApiService;", "Lcom/aptoide/aptoide_ab_testing/service/FlagrService;", "flagrBaseHost", HttpUrl.FRAGMENT_ENCODE_SET, "okHttpClient", "Lokhttp3/OkHttpClient;", "(Ljava/lang/String;Lokhttp3/OkHttpClient;)V", "flagr", "Lcom/aptoide/aptoide_ab_testing/network/FlagrApiService$Flagr;", "getFlag", "Lcom/aptoide/aptoide_ab_testing/model/Flag;", "flagID", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postEvaluation", "Lcom/aptoide/aptoide_ab_testing/model/PostEvaluationResponseJson;", "body", "Lcom/aptoide/aptoide_ab_testing/model/EvalContext;", "(Lcom/aptoide/aptoide_ab_testing/model/EvalContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Flagr", "aptoide-ab-testing"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlagrApiService implements FlagrService {
    private final Flagr flagr;
    private final String flagrBaseHost;

    /* JADX INFO: compiled from: FlagrApiService.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH§@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/aptoide/aptoide_ab_testing/network/FlagrApiService$Flagr;", HttpUrl.FRAGMENT_ENCODE_SET, "getFlag", "Lretrofit2/Response;", "Lcom/aptoide/aptoide_ab_testing/model/Flag;", "flagID", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postEvaluation", "Lcom/aptoide/aptoide_ab_testing/model/PostEvaluationResponseJson;", "body", "Lcom/aptoide/aptoide_ab_testing/model/EvalContext;", "(Lcom/aptoide/aptoide_ab_testing/model/EvalContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aptoide-ab-testing"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface Flagr {
        @GET("/api/v1/flags/{flagID}")
        Object getFlag(@Path("flagID") String str, Continuation<? super Response<Flag>> continuation);

        @POST("/api/v1/evaluation")
        Object postEvaluation(@Body EvalContext evalContext, Continuation<? super Response<PostEvaluationResponseJson>> continuation);
    }

    /* JADX INFO: renamed from: com.aptoide.aptoide_ab_testing.network.FlagrApiService$getFlag$2, reason: invalid class name */
    /* JADX INFO: compiled from: FlagrApiService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/aptoide_ab_testing/model/Flag;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.aptoide.aptoide_ab_testing.network.FlagrApiService$getFlag$2", f = "FlagrApiService.kt", l = {33}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Flag>, Object> {
        final /* synthetic */ String $flagID;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$flagID = str;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return FlagrApiService.this.new AnonymousClass2(this.$flagID, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Flag> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                Flagr flagr = FlagrApiService.this.flagr;
                String str = this.$flagID;
                this.label = 1;
                obj = flagr.getFlag(str, this);
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
            Flag flag = (Flag) response.body();
            if (response.isSuccessful() && flag != null) {
                return flag;
            }
            String strMessage = response.message();
            m.e(strMessage, "getFlagResponse.message()");
            throw new FlagrException(strMessage, response.code());
        }
    }

    /* JADX INFO: renamed from: com.aptoide.aptoide_ab_testing.network.FlagrApiService$postEvaluation$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FlagrApiService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/aptoide_ab_testing/model/PostEvaluationResponseJson;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.aptoide.aptoide_ab_testing.network.FlagrApiService$postEvaluation$2", f = "FlagrApiService.kt", l = {47}, m = "invokeSuspend")
    static final class C04742 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PostEvaluationResponseJson>, Object> {
        final /* synthetic */ EvalContext $body;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04742(EvalContext evalContext, Continuation<? super C04742> continuation) {
            super(2, continuation);
            this.$body = evalContext;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return FlagrApiService.this.new C04742(this.$body, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PostEvaluationResponseJson> continuation) {
            return ((C04742) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                Flagr flagr = FlagrApiService.this.flagr;
                EvalContext evalContext = this.$body;
                this.label = 1;
                obj = flagr.postEvaluation(evalContext, this);
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
            PostEvaluationResponseJson postEvaluationResponseJson = (PostEvaluationResponseJson) response.body();
            if (response.isSuccessful() && postEvaluationResponseJson != null) {
                return postEvaluationResponseJson;
            }
            String strMessage = response.message();
            m.e(strMessage, "postEvaluationResult.message()");
            throw new FlagrException(strMessage, response.code());
        }
    }

    public FlagrApiService(String str, OkHttpClient okHttpClient) {
        m.f(str, "flagrBaseHost");
        m.f(okHttpClient, "okHttpClient");
        this.flagrBaseHost = str;
        Object objCreate = new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build().create(Flagr.class);
        m.e(objCreate, "Builder()\n            .b…create(Flagr::class.java)");
        this.flagr = (Flagr) objCreate;
    }

    @Override // com.aptoide.aptoide_ab_testing.service.FlagrService
    public Object getFlag(String str, Continuation<? super Flag> continuation) {
        return h.e(Dispatchers.b(), new AnonymousClass2(str, null), continuation);
    }

    @Override // com.aptoide.aptoide_ab_testing.service.FlagrService
    public Object postEvaluation(EvalContext evalContext, Continuation<? super PostEvaluationResponseJson> continuation) {
        return h.e(Dispatchers.b(), new C04742(evalContext, null), continuation);
    }
}
