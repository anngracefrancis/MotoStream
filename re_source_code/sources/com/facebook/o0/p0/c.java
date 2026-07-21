package com.facebook.o0.p0;

import android.os.Bundle;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.collections.w0;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: ProtectedModeManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f10393b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static HashSet<String> f10395d;
    public static final c a = new c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f10394c = i.b(a.f10396f);

    /* JADX INFO: compiled from: ProtectedModeManager.kt */
    static final class a extends Lambda implements Function0<HashSet<String>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f10396f = new a();

        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HashSet<String> invoke() {
            return w0.e("_currency", "_valueToSum", "fb_availability", "fb_body_style", "fb_checkin_date", "fb_checkout_date", "fb_city", "fb_condition_of_vehicle", "fb_content_category", "fb_content_ids", "fb_content_name", "fb_content_type", "fb_contents", "fb_country", "fb_currency", "fb_delivery_category", "fb_departing_arrival_date", "fb_departing_departure_date", "fb_destination_airport", "fb_destination_ids", "fb_dma_code", "fb_drivetrain", "fb_exterior_color", "fb_fuel_type", "fb_hotel_score", "fb_interior_color", "fb_lease_end_date", "fb_lease_start_date", "fb_listing_type", "fb_make", "fb_mileage.unit", "fb_mileage.value", "fb_model", "fb_neighborhood", "fb_num_adults", "fb_num_children", "fb_num_infants", "fb_num_items", "fb_order_id", "fb_origin_airport", "fb_postal_code", "fb_predicted_ltv", "fb_preferred_baths_range", "fb_preferred_beds_range", "fb_preferred_neighborhoods", "fb_preferred_num_stops", "fb_preferred_price_range", "fb_preferred_star_ratings", "fb_price", "fb_property_type", "fb_region", "fb_returning_arrival_date", "fb_returning_departure_date", "fb_search_string", "fb_state_of_vehicle", "fb_status", "fb_suggested_destinations", "fb_suggested_home_listings", "fb_suggested_hotels", "fb_suggested_jobs", "fb_suggested_local_service_businesses", "fb_suggested_location_based_items", "fb_suggested_vehicles", "fb_transmission", "fb_travel_class", "fb_travel_end", "fb_travel_start", "fb_trim", "fb_user_bucket", "fb_value", "fb_vin", "fb_year", "lead_event_source", "predicted_ltv", "product_catalog_id", "app_user_id", "appVersion", "_eventName", "_eventName_md5", "_implicitlyLogged", "_inBackground", "_isTimedEvent", "_logTime", "_session_id", "_ui", "_valueToUpdate", "_is_fb_codeless", "_is_suggested_event", "_fb_pixel_referral_id", "fb_pixel_id", "trace_id", "subscription_id", "event_id", "_restrictedParams", "_onDeviceParams", "purchase_valid_result_type", "core_lib_included", "login_lib_included", "share_lib_included", "place_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "_codeless_action", "sdk_initialized", "billing_client_lib_included", "billing_service_lib_included", "user_data_keys", "device_push_token", "fb_mobile_pckg_fp", "fb_mobile_app_cert_hash", "aggregate_id", "anonymous_id", "campaign_ids", "fb_post_attachment", "receipt_data", "ad_type", "fb_content", "fb_content_id", "fb_description", "fb_level", "fb_max_rating_value", "fb_payment_info_available", "fb_registration_method", "fb_success", "pm", "_audiencePropertyIds", "cs_maca");
        }
    }

    private c() {
    }

    private final HashSet<String> a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet<String> hashSet = new HashSet<>();
        int i2 = 0;
        int length = jSONArray.length();
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                String string = jSONArray.getString(i2);
                m.e(string, "jsonArray.getString(i)");
                hashSet.add(string);
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return hashSet;
    }

    public static final void b() {
        c cVar = a;
        f10393b = true;
        cVar.d();
    }

    private final void d() throws JSONException {
        d0 d0Var = d0.a;
        a0 a0Var = a0.a;
        c0 c0VarO = d0.o(a0.d(), false);
        if (c0VarO == null) {
            return;
        }
        HashSet<String> hashSetA = a(c0VarO.g());
        if (hashSetA == null) {
            hashSetA = c();
        }
        f10395d = hashSetA;
    }

    public static final void e(Bundle bundle) {
        if (!f10393b || bundle == null || bundle.isEmpty() || f10395d == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Set<String> setKeySet = bundle.keySet();
        m.e(setKeySet, "parameters.keySet()");
        for (String str : setKeySet) {
            HashSet<String> hashSet = f10395d;
            m.c(hashSet);
            if (!hashSet.contains(str)) {
                m.e(str, "param");
                arrayList.add(str);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            bundle.remove((String) it.next());
        }
        bundle.putString("pm", "1");
    }

    public final HashSet<String> c() {
        return (HashSet) f10394c.getValue();
    }
}
