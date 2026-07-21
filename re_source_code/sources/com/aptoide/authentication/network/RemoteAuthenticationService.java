package com.aptoide.authentication.network;

import com.aptoide.authentication.AuthenticationException;
import com.aptoide.authentication.model.CodeAuth;
import com.aptoide.authentication.model.OAuth2;
import com.aptoide.authentication.service.AuthenticationService;
import com.squareup.moshi.g;
import com.squareup.moshi.r;
import com.squareup.moshi.x.reflect.KotlinJsonAdapterFactory;
import java.util.Arrays;
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
import retrofit2.converter.moshi.MoshiConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

/* JADX INFO: compiled from: RemoteAuthenticationService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0013\u0014B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/aptoide/authentication/network/RemoteAuthenticationService;", "Lcom/aptoide/authentication/service/AuthenticationService;", "authenticationBaseHost", HttpUrl.FRAGMENT_ENCODE_SET, "okHttpClient", "Lokhttp3/OkHttpClient;", "(Ljava/lang/String;Lokhttp3/OkHttpClient;)V", "authorizationV7", "Lcom/aptoide/authentication/network/RemoteAuthenticationService$AuthorizationV7;", "authenticate", "Lcom/aptoide/authentication/model/OAuth2;", "magicToken", "state", "agent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMagicLink", "Lcom/aptoide/authentication/model/CodeAuth;", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "AuthorizationV7", "Credentials", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RemoteAuthenticationService implements AuthenticationService {
    private final String authenticationBaseHost;
    private final AuthorizationV7 authorizationV7;

    /* JADX INFO: compiled from: RemoteAuthenticationService.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001JO\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ;\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\b\b\u0001\u0010\f\u001a\u00020\rH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/aptoide/authentication/network/RemoteAuthenticationService$AuthorizationV7;", HttpUrl.FRAGMENT_ENCODE_SET, "authenticate", "Lretrofit2/Response;", "Lcom/aptoide/authentication/model/OAuth2;", "type", "Lcom/aptoide/authentication/network/Type;", "state", HttpUrl.FRAGMENT_ENCODE_SET, "agent", "accepted", HttpUrl.FRAGMENT_ENCODE_SET, "credentials", "Lcom/aptoide/authentication/network/RemoteAuthenticationService$Credentials;", "(Lcom/aptoide/authentication/network/Type;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Lcom/aptoide/authentication/network/RemoteAuthenticationService$Credentials;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMagicLink", "Lcom/aptoide/authentication/model/CodeAuth;", "(Lcom/aptoide/authentication/network/Type;[Ljava/lang/String;Lcom/aptoide/authentication/network/RemoteAuthenticationService$Credentials;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface AuthorizationV7 {
        @POST("user/authorize")
        Object authenticate(@Query("type") Type type, @Query("state") String str, @Query("agent") String str2, @Query(encoded = true, value = "accepted[]") String[] strArr, @Body Credentials credentials, Continuation<? super Response<OAuth2>> continuation);

        @POST("user/authorize")
        Object sendMagicLink(@Query("type") Type type, @Query(encoded = true, value = "accepted[]") String[] strArr, @Body Credentials credentials, Continuation<? super Response<CodeAuth>> continuation);
    }

    /* JADX INFO: compiled from: RemoteAuthenticationService.kt */
    @g(generateAdapter = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ(\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/aptoide/authentication/network/RemoteAuthenticationService$Credentials;", HttpUrl.FRAGMENT_ENCODE_SET, "credential", HttpUrl.FRAGMENT_ENCODE_SET, "supported", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;[Ljava/lang/String;)V", "getCredential", "()Ljava/lang/String;", "getSupported", "()[Ljava/lang/String;", "[Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;[Ljava/lang/String;)Lcom/aptoide/authentication/network/RemoteAuthenticationService$Credentials;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final /* data */ class Credentials {
        private final String credential;
        private final String[] supported;

        public Credentials(String str, String[] strArr) {
            m.f(str, "credential");
            m.f(strArr, "supported");
            this.credential = str;
            this.supported = strArr;
        }

        public static /* synthetic */ Credentials copy$default(Credentials credentials, String str, String[] strArr, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = credentials.credential;
            }
            if ((i2 & 2) != 0) {
                strArr = credentials.supported;
            }
            return credentials.copy(str, strArr);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getCredential() {
            return this.credential;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String[] getSupported() {
            return this.supported;
        }

        public final Credentials copy(String credential, String[] supported) {
            m.f(credential, "credential");
            m.f(supported, "supported");
            return new Credentials(credential, supported);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Credentials)) {
                return false;
            }
            Credentials credentials = (Credentials) other;
            return m.a(this.credential, credentials.credential) && m.a(this.supported, credentials.supported);
        }

        public final String getCredential() {
            return this.credential;
        }

        public final String[] getSupported() {
            return this.supported;
        }

        public int hashCode() {
            return (this.credential.hashCode() * 31) + Arrays.hashCode(this.supported);
        }

        public String toString() {
            return "Credentials(credential=" + this.credential + ", supported=" + Arrays.toString(this.supported) + ')';
        }
    }

    /* JADX INFO: renamed from: com.aptoide.authentication.network.RemoteAuthenticationService$authenticate$2, reason: invalid class name */
    /* JADX INFO: compiled from: RemoteAuthenticationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/authentication/model/OAuth2;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.aptoide.authentication.network.RemoteAuthenticationService$authenticate$2", f = "RemoteAuthenticationService.kt", l = {53}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OAuth2>, Object> {
        final /* synthetic */ String $agent;
        final /* synthetic */ String $magicToken;
        final /* synthetic */ String $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, String str2, String str3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$state = str;
            this.$agent = str2;
            this.$magicToken = str3;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return RemoteAuthenticationService.this.new AnonymousClass2(this.$state, this.$agent, this.$magicToken, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OAuth2> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                Credentials credentials = new Credentials(this.$magicToken, new String[]{"OAUTH2"});
                this.label = 1;
                obj = RemoteAuthenticationService.this.authorizationV7.authenticate(Type.CODE, this.$state, this.$agent, new String[]{"TOS", "PRIVACY", "DISTRIBUTION"}, credentials, this);
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
            OAuth2 oAuth2 = (OAuth2) response.body();
            if (response.isSuccessful() && oAuth2 != null) {
                return oAuth2;
            }
            String strMessage = response.message();
            m.e(strMessage, "authenticateResponse.message()");
            throw new AuthenticationException(strMessage, response.code());
        }
    }

    /* JADX INFO: renamed from: com.aptoide.authentication.network.RemoteAuthenticationService$sendMagicLink$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RemoteAuthenticationService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/authentication/model/CodeAuth;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.aptoide.authentication.network.RemoteAuthenticationService$sendMagicLink$2", f = "RemoteAuthenticationService.kt", l = {37}, m = "invokeSuspend")
    static final class C04762 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CodeAuth>, Object> {
        final /* synthetic */ String $email;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04762(String str, Continuation<? super C04762> continuation) {
            super(2, continuation);
            this.$email = str;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return RemoteAuthenticationService.this.new C04762(this.$email, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CodeAuth> continuation) {
            return ((C04762) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                Credentials credentials = new Credentials(this.$email, new String[]{"CODE:TOKEN:EMAIL"});
                this.label = 1;
                obj = RemoteAuthenticationService.this.authorizationV7.sendMagicLink(Type.EMAIL, new String[]{"TOS", "PRIVACY", "DISTRIBUTION"}, credentials, this);
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
            CodeAuth codeAuth = (CodeAuth) response.body();
            if (response.isSuccessful() && codeAuth != null) {
                codeAuth.setEmail(this.$email);
                return codeAuth;
            }
            String strMessage = response.message();
            m.e(strMessage, "sendMagicLinkResponse.message()");
            throw new AuthenticationException(strMessage, response.code());
        }
    }

    public RemoteAuthenticationService(String str, OkHttpClient okHttpClient) {
        m.f(str, "authenticationBaseHost");
        m.f(okHttpClient, "okHttpClient");
        this.authenticationBaseHost = str;
        Object objCreate = new Retrofit.Builder().baseUrl(str).addConverterFactory(MoshiConverterFactory.create(new r.a().a(new KotlinJsonAdapterFactory()).b())).client(okHttpClient).build().create(AuthorizationV7.class);
        m.e(objCreate, "Builder().baseUrl(authen…horizationV7::class.java)");
        this.authorizationV7 = (AuthorizationV7) objCreate;
    }

    @Override // com.aptoide.authentication.service.AuthenticationService
    public Object authenticate(String str, String str2, String str3, Continuation<? super OAuth2> continuation) {
        return h.e(Dispatchers.b(), new AnonymousClass2(str2, str3, str, null), continuation);
    }

    @Override // com.aptoide.authentication.service.AuthenticationService
    public Object sendMagicLink(String str, Continuation<? super CodeAuth> continuation) {
        return h.e(Dispatchers.b(), new C04762(str, null), continuation);
    }
}
