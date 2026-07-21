package com.aptoide.authenticationrx;

import com.aptoide.authentication.AptoideAuthentication;
import com.aptoide.authentication.model.CodeAuth;
import com.aptoide.authentication.model.OAuth2;
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

/* JADX INFO: compiled from: AptoideAuthenticationRx.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/aptoide/authenticationrx/AptoideAuthenticationRx;", HttpUrl.FRAGMENT_ENCODE_SET, "aptoideAuthentication", "Lcom/aptoide/authentication/AptoideAuthentication;", "(Lcom/aptoide/authentication/AptoideAuthentication;)V", "authenticate", "Lio/reactivex/Single;", "Lcom/aptoide/authentication/model/OAuth2;", "magicCode", HttpUrl.FRAGMENT_ENCODE_SET, "state", "agent", "sendMagicLink", "Lcom/aptoide/authentication/model/CodeAuth;", "email", "aptoide-authentication-rx"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AptoideAuthenticationRx {
    private final AptoideAuthentication aptoideAuthentication;

    /* JADX INFO: renamed from: com.aptoide.authenticationrx.AptoideAuthenticationRx$authenticate$1, reason: invalid class name */
    /* JADX INFO: compiled from: AptoideAuthenticationRx.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/authentication/model/OAuth2;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.aptoide.authenticationrx.AptoideAuthenticationRx$authenticate$1", f = "AptoideAuthenticationRx.kt", l = {15}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super OAuth2>, Object> {
        final /* synthetic */ String $agent;
        final /* synthetic */ String $magicCode;
        final /* synthetic */ String $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$magicCode = str;
            this.$state = str2;
            this.$agent = str3;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return AptoideAuthenticationRx.this.new AnonymousClass1(this.$magicCode, this.$state, this.$agent, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super OAuth2> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                AptoideAuthentication aptoideAuthentication = AptoideAuthenticationRx.this.aptoideAuthentication;
                String str = this.$magicCode;
                String str2 = this.$state;
                String str3 = this.$agent;
                this.label = 1;
                obj = aptoideAuthentication.authenticate(str, str2, str3, this);
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

    /* JADX INFO: renamed from: com.aptoide.authenticationrx.AptoideAuthenticationRx$sendMagicLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AptoideAuthenticationRx.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/authentication/model/CodeAuth;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.aptoide.authenticationrx.AptoideAuthenticationRx$sendMagicLink$1", f = "AptoideAuthenticationRx.kt", l = {11}, m = "invokeSuspend")
    static final class C04771 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CodeAuth>, Object> {
        final /* synthetic */ String $email;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C04771(String str, Continuation<? super C04771> continuation) {
            super(2, continuation);
            this.$email = str;
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return AptoideAuthenticationRx.this.new C04771(this.$email, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CodeAuth> continuation) {
            return ((C04771) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC = d.c();
            int i2 = this.label;
            if (i2 == 0) {
                o.b(obj);
                AptoideAuthentication aptoideAuthentication = AptoideAuthenticationRx.this.aptoideAuthentication;
                String str = this.$email;
                this.label = 1;
                obj = aptoideAuthentication.sendMagicLink(str, this);
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

    public AptoideAuthenticationRx(AptoideAuthentication aptoideAuthentication) {
        m.f(aptoideAuthentication, "aptoideAuthentication");
        this.aptoideAuthentication = aptoideAuthentication;
    }

    public final s<OAuth2> authenticate(String str, String str2, String str3) {
        m.f(str, "magicCode");
        m.f(str2, "state");
        m.f(str3, "agent");
        return h.c(null, new AnonymousClass1(str, str2, str3, null), 1, null);
    }

    public final s<CodeAuth> sendMagicLink(String str) {
        m.f(str, "email");
        return h.c(null, new C04771(str, null), 1, null);
    }
}
