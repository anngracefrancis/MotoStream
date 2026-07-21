package com.aptoide.authentication.service;

import com.aptoide.authentication.model.CodeAuth;
import com.aptoide.authentication.model.OAuth2;
import kotlin.Metadata;
import kotlin.p003y.Continuation;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AuthenticationService.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/aptoide/authentication/service/AuthenticationService;", HttpUrl.FRAGMENT_ENCODE_SET, "authenticate", "Lcom/aptoide/authentication/model/OAuth2;", "magicToken", HttpUrl.FRAGMENT_ENCODE_SET, "state", "agent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMagicLink", "Lcom/aptoide/authentication/model/CodeAuth;", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AuthenticationService {
    Object authenticate(String str, String str2, String str3, Continuation<? super OAuth2> continuation);

    Object sendMagicLink(String str, Continuation<? super CodeAuth> continuation);
}
