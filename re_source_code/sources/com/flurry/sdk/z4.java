package com.flurry.sdk;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes2.dex */
public final class z4 implements f7<e> {
    z4() {
    }

    @Override // com.flurry.sdk.f7
    public final /* synthetic */ void a(e eVar) {
        e eVar2 = eVar;
        if (eVar2 == null) {
            d1.c(2, "SessionInfoFrame", "Session info data is null, do not send the frame.");
        } else {
            n0.a();
            int i2 = n2.a.AGENT_REPORT_TYPE_MAIN_DEVICE.f10944j;
            n nVar = eVar2.f10712d;
            if (nVar != null && nVar.a) {
                i2 = n2.a.AGENT_REPORT_TYPE_INSTANT_APP.f10944j;
            }
            m2.a().b(new m6(new n6(eVar2.a, i2, eVar2.f10710b, eVar2.f10711c)));
        }
        d1.c(4, "SessionInfoObserver", "SessionInfoData".concat(String.valueOf(eVar2)));
    }
}
