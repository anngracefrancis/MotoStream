package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: loaded from: classes2.dex */
public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a f11501j = new a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    private static int f11502k = b.a;

    private static class a implements PendingResultUtil.ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private a() {
        }

        @Override // com.google.android.gms.common.internal.PendingResultUtil.ResultConverter
        public final /* synthetic */ GoogleSignInAccount a(Result result) {
            return ((GoogleSignInResult) result).a();
        }
    }

    @VisibleForTesting
    static final enum b {
        public static final int a = 1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ int[] f11503b = {1, 2, 3, 4};
    }
}
