package com.aptoide.authentication.mock;

import com.aptoide.authentication.model.CodeAuth;
import com.aptoide.authentication.model.OAuth2;
import com.aptoide.authentication.service.AuthenticationService;
import kotlin.Metadata;
import kotlin.o;
import kotlin.p003y.Continuation;
import kotlin.p003y.intrinsics.d;
import kotlin.p003y.j.p004a.ContinuationImpl;
import kotlin.p003y.j.p004a.DebugMetadata;
import kotlinx.coroutines.y0;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: MockAuthenticationService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/aptoide/authentication/mock/MockAuthenticationService;", "Lcom/aptoide/authentication/service/AuthenticationService;", "()V", "authenticate", "Lcom/aptoide/authentication/model/OAuth2;", "magicToken", HttpUrl.FRAGMENT_ENCODE_SET, "state", "agent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMagicLink", "Lcom/aptoide/authentication/model/CodeAuth;", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MockAuthenticationService implements AuthenticationService {

    /* JADX INFO: renamed from: com.aptoide.authentication.mock.MockAuthenticationService$authenticate$1, reason: invalid class name */
    /* JADX INFO: compiled from: MockAuthenticationService.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.aptoide.authentication.mock.MockAuthenticationService", f = "MockAuthenticationService.kt", l = {19}, m = "authenticate")
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MockAuthenticationService.this.authenticate(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.aptoide.authentication.mock.MockAuthenticationService$sendMagicLink$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: MockAuthenticationService.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "com.aptoide.authentication.mock.MockAuthenticationService", f = "MockAuthenticationService.kt", l = {11}, m = "sendMagicLink")
    static final class C04751 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C04751(Continuation<? super C04751> continuation) {
            super(continuation);
        }

        @Override // kotlin.p003y.j.p004a.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MockAuthenticationService.this.sendMagicLink(null, this);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.aptoide.authentication.service.AuthenticationService
    public Object authenticate(String str, String str2, String str3, Continuation<? super OAuth2> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object objC = d.c();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            o.b(obj);
            anonymousClass1.label = 1;
            if (y0.a(200L, anonymousClass1) == objC) {
                return objC;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
        }
        return new OAuth2("OAUTH2", false, new OAuth2.Data("accesst0k3nF4k3", 3000, "r3fr3shT0k3nF4k3", "Bearer", null));
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // com.aptoide.authentication.service.AuthenticationService
    public Object sendMagicLink(String str, Continuation<? super CodeAuth> continuation) throws Throwable {
        C04751 c04751;
        if (continuation instanceof C04751) {
            c04751 = (C04751) continuation;
            int i2 = c04751.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c04751.label = i2 - Integer.MIN_VALUE;
            } else {
                c04751 = new C04751(continuation);
            }
        } else {
            c04751 = new C04751(continuation);
        }
        Object obj = c04751.result;
        Object objC = d.c();
        int i3 = c04751.label;
        if (i3 == 0) {
            o.b(obj);
            c04751.label = 1;
            if (y0.a(200L, c04751) == objC) {
                return objC;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
        }
        return new CodeAuth("code", "estado de arte", "agente da pejota", false, new CodeAuth.Data("TOKEN", "EMAIL"), "filipo@emailo.como");
    }
}
