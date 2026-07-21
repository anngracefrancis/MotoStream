package cm.aptoide.pt.dataprovider.exception;

import cm.aptoide.pt.dataprovider.ws.v3.GenericResponseV3;
import cm.aptoide.pt.utils.BaseException;

/* JADX INFO: loaded from: classes.dex */
public class AptoideWsV3Exception extends BaseException {
    private GenericResponseV3 baseResponse;

    public AptoideWsV3Exception(Throwable th) {
        super(th);
    }

    public GenericResponseV3 getBaseResponse() {
        return this.baseResponse;
    }

    public void setBaseResponse(GenericResponseV3 genericResponseV3) {
        this.baseResponse = genericResponseV3;
    }
}
