package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcmn<AdT> implements zzcjv<AdT> {
    private static Bundle d(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<AdT> a(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        String strOptString = zzcxmVar.s.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, HttpUrl.FRAGMENT_ENCODE_SET);
        zzcxv zzcxvVar = zzcxuVar.a.a;
        zzcxx zzcxxVarT = new zzcxx().w(zzcxvVar.f15750d).n(zzcxvVar.f15751e).o(zzcxvVar.a).t(zzcxvVar.f15752f).k(zzcxvVar.f15748b).h(zzcxvVar.f15753g).l(zzcxvVar.f15754h).f(zzcxvVar.f15755i).u(zzcxvVar.f15756j).e(zzcxvVar.m).v(zzcxvVar.f15757k).t(strOptString);
        Bundle bundleD = d(zzcxvVar.f15750d.r);
        Bundle bundleD2 = d(bundleD.getBundle("com.google.ads.mediation.admob.AdMobAdapter"));
        bundleD2.putInt("gw", 1);
        String strOptString2 = zzcxmVar.s.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundleD2.putString("mad_hac", strOptString2);
        }
        String strOptString3 = zzcxmVar.s.optString("adJson", null);
        if (strOptString3 != null) {
            bundleD2.putString("_ad", strOptString3);
        }
        bundleD2.putBoolean("_noRefresh", true);
        Iterator<String> itKeys = zzcxmVar.A.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = zzcxmVar.A.optString(next, null);
            if (next != null) {
                bundleD2.putString(next, strOptString4);
            }
        }
        bundleD.putBundle("com.google.ads.mediation.admob.AdMobAdapter", bundleD2);
        zzxz zzxzVar = zzcxvVar.f15750d;
        zzcxv zzcxvVarD = zzcxxVarT.w(new zzxz(zzxzVar.f16968f, zzxzVar.f16969g, bundleD2, zzxzVar.f16971i, zzxzVar.f16972j, zzxzVar.f16973k, zzxzVar.l, zzxzVar.m, zzxzVar.n, zzxzVar.o, zzxzVar.p, zzxzVar.q, bundleD, zzxzVar.s, zzxzVar.t, zzxzVar.u, zzxzVar.v, zzxzVar.w, zzxzVar.x, zzxzVar.y, zzxzVar.z)).d();
        Bundle bundle = new Bundle();
        zzcxo zzcxoVar = zzcxuVar.f15747b.f15744b;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzcxoVar.a));
        bundle2.putInt("refresh_interval", zzcxoVar.f15737c);
        bundle2.putString("gws_query_id", zzcxoVar.f15736b);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzcxuVar.a.a.f15752f;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzcxmVar.t);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzcxmVar.f15725c));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzcxmVar.f15726d));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzcxmVar.n));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzcxmVar.m));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzcxmVar.f15729g));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzcxmVar.f15730h));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzcxmVar.f15731i));
        bundle3.putString("transaction_id", zzcxmVar.f15732j);
        bundle3.putString("valid_from_timestamp", zzcxmVar.f15733k);
        bundle3.putBoolean("is_closable_area_disabled", zzcxmVar.G);
        if (zzcxmVar.l != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzcxmVar.l.f14158g);
            bundle4.putString("rb_type", zzcxmVar.l.f14157f);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return c(zzcxvVarD, bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return !TextUtils.isEmpty(zzcxmVar.s.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, HttpUrl.FRAGMENT_ENCODE_SET));
    }

    protected abstract zzbbh<AdT> c(zzcxv zzcxvVar, Bundle bundle);
}
