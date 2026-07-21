package e.e.a;

/* JADX INFO: loaded from: classes2.dex */
public enum a {
    INVALID_REQUEST("Invalid Ad request."),
    NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
    NETWORK_ERROR("A network error occurred."),
    INTERNAL_ERROR("There was an internal error.");


    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f20713k;

    a(String str) {
        this.f20713k = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f20713k;
    }
}
