package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public final class PendingResults {

    private static final class a<R extends Result> extends BasePendingResult<R> {
        private final R q;

        public a(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.q = r;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        protected final R h(Status status) {
            return this.q;
        }
    }

    @KeepForSdk
    private PendingResults() {
    }

    @KeepForSdk
    public static <R extends Result> PendingResult<R> a(R r, GoogleApiClient googleApiClient) {
        Preconditions.l(r, "Result must not be null");
        Preconditions.b(!r.getStatus().e0(), "Status code must not be SUCCESS");
        a aVar = new a(googleApiClient, r);
        aVar.k(r);
        return aVar;
    }

    @KeepForSdk
    public static PendingResult<Status> b(Status status, GoogleApiClient googleApiClient) {
        Preconditions.l(status, "Result must not be null");
        StatusPendingResult statusPendingResult = new StatusPendingResult(googleApiClient);
        statusPendingResult.k(status);
        return statusPendingResult;
    }
}
