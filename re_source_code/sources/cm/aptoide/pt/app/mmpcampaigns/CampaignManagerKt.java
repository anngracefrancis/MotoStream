package cm.aptoide.pt.app.mmpcampaigns;

import cm.aptoide.pt.BuildConfig;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CampaignManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¨\u0006\u0004"}, d2 = {"injectCampaignAttributes", HttpUrl.FRAGMENT_ENCODE_SET, "medium", "guestUID", "app_vanillaProdRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CampaignManagerKt {
    public static final String injectCampaignAttributes(String str, String str2, String str3) {
        m.f(str, "<this>");
        m.f(str2, "medium");
        String strA = u.A(str, "{{OEMID}}", BuildConfig.OEMID, false, 4, null);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("utm_source", "Vanilla");
        linkedHashMap.put("utm_medium", str2);
        String string = null;
        if (str3 != null) {
            if (!(str3.length() > 0)) {
                str3 = null;
            }
            if (str3 != null) {
                linkedHashMap.put("guest_uid", str3);
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add(((String) entry.getKey()) + '=' + ((String) entry.getValue()));
        }
        String strE0 = c0.e0(arrayList, "&", null, null, 0, null, null, 62, null);
        if (!(strE0.length() > 0)) {
            strE0 = null;
        }
        if (strE0 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(v.J(strA, "?", false, 2, null) ? "&" : "?");
            sb.append(strE0);
            string = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strA);
        if (string == null) {
            string = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb2.append(string);
        return sb2.toString();
    }
}
