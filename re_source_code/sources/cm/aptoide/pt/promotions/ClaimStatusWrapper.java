package cm.aptoide.pt.promotions;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ClaimStatusWrapper {
    private final List<Error> errors;
    private final Status status;

    public enum Error {
        PROMOTION_CLAIMED,
        WRONG_ADDRESS,
        GENERIC,
        WALLET_NOT_VERIFIED
    }

    public enum Status {
        OK,
        FAIL
    }

    public ClaimStatusWrapper(Status status, List<Error> list) {
        this.status = status;
        this.errors = list;
    }

    public List<Error> getErrors() {
        return this.errors;
    }

    public Status getStatus() {
        return this.status;
    }
}
