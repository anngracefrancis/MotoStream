package io.rakam.api;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: compiled from: DeviceInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    private boolean a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f21923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f21924c;

    /* JADX INFO: compiled from: DeviceInfo.java */
    private class b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f21925b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f21926c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f21927d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f21928e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f21929f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f21930g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f21931h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f21932i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f21933j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f21934k;
        private boolean l;

        private String A() {
            return Build.VERSION.RELEASE;
        }

        private String B() {
            try {
                return d.this.f21923b.getPackageManager().getPackageInfo(d.this.f21923b.getPackageName(), 0).versionName;
            } catch (PackageManager.NameNotFoundException e2) {
                e.e().g("Failed to get version name", e2);
                return null;
            }
        }

        private boolean m() {
            try {
                Integer num = (Integer) Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, d.this.f21923b);
                return num != null && num.intValue() == 0;
            } catch (ClassNotFoundException e2) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services Util not found!");
                e.e().g("Failed to check GPS enabled", e2);
                return false;
            } catch (IllegalAccessException e3) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services not available");
                e.e().g("Failed to check GPS enabled", e3);
                return false;
            } catch (NoClassDefFoundError e4) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services Util not found!");
                e.e().g("Failed to check GPS enabled", e4);
                return false;
            } catch (NoSuchMethodException e5) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services not available");
                e.e().g("Failed to check GPS enabled", e5);
                return false;
            } catch (InvocationTargetException e6) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services not available");
                e.e().g("Failed to check GPS enabled", e6);
                return false;
            } catch (Exception e7) {
                h.d().g("io.rakam.api.DeviceInfo", "Error when checking for Google Play Services: " + e7);
                e.e().g("Failed to check GPS enabled", e7);
                return false;
            }
        }

        private String n() {
            return "Amazon".equals(x()) ? o() : p();
        }

        private String o() {
            ContentResolver contentResolver = d.this.f21923b.getContentResolver();
            this.f21934k = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 0) == 1;
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            this.a = string;
            return string;
        }

        private String p() {
            try {
                boolean z = true;
                Object objInvoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, d.this.f21923b);
                Boolean bool = (Boolean) objInvoke.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(objInvoke, new Object[0]);
                if (bool == null || !bool.booleanValue()) {
                    z = false;
                }
                this.f21934k = z;
                this.a = (String) objInvoke.getClass().getMethod("getId", new Class[0]).invoke(objInvoke, new Object[0]);
            } catch (ClassNotFoundException e2) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services SDK not found!");
                e.e().g("Failed to get ADID", e2);
            } catch (InvocationTargetException e3) {
                h.d().g("io.rakam.api.DeviceInfo", "Google Play Services not available");
                e.e().g("Failed to get ADID", e3);
            } catch (Exception e4) {
                h.d().c("io.rakam.api.DeviceInfo", "Encountered an error connecting to Google Play Services", e4);
                e.e().g("Failed to get ADID", e4);
            }
            return this.a;
        }

        private String q() {
            return Build.BRAND;
        }

        private String r() {
            try {
                return ((TelephonyManager) d.this.f21923b.getSystemService("phone")).getNetworkOperatorName();
            } catch (Exception e2) {
                e.e().g("Failed to get carrier", e2);
                return null;
            }
        }

        private String s() {
            String strU = u();
            if (!j.d(strU)) {
                return strU;
            }
            String strV = v();
            return !j.d(strV) ? strV : t();
        }

        private String t() {
            return Locale.getDefault().getCountry();
        }

        private String u() {
            Location locationL;
            List<Address> fromLocation;
            if (d.this.r() && (locationL = d.this.l()) != null) {
                try {
                    if (Geocoder.isPresent() && (fromLocation = d.this.h().getFromLocation(locationL.getLatitude(), locationL.getLongitude(), 1)) != null) {
                        for (Address address : fromLocation) {
                            if (address != null) {
                                return address.getCountryCode();
                            }
                        }
                    }
                } catch (IOException e2) {
                    e.e().g("Failed to get country from location", e2);
                } catch (IllegalArgumentException e3) {
                    e.e().g("Failed to get country from location", e3);
                } catch (IllegalStateException e4) {
                    e.e().g("Failed to get country from location", e4);
                } catch (NoSuchMethodError e5) {
                    e.e().g("Failed to get country from location", e5);
                } catch (NullPointerException e6) {
                    e.e().g("Failed to get country from location", e6);
                }
            }
            return null;
        }

        private String v() {
            String networkCountryIso;
            try {
                TelephonyManager telephonyManager = (TelephonyManager) d.this.f21923b.getSystemService("phone");
                if (telephonyManager.getPhoneType() == 2 || (networkCountryIso = telephonyManager.getNetworkCountryIso()) == null) {
                    return null;
                }
                return networkCountryIso.toUpperCase(Locale.US);
            } catch (Exception e2) {
                e.e().g("Failed to get country from network", e2);
                return null;
            }
        }

        private String w() {
            return Locale.getDefault().getLanguage();
        }

        private String x() {
            return Build.MANUFACTURER;
        }

        private String y() {
            return Build.MODEL;
        }

        private String z() {
            return "android";
        }

        private b() {
            this.a = n();
            this.f21926c = B();
            this.f21927d = z();
            this.f21928e = A();
            this.f21929f = q();
            this.f21930g = x();
            this.f21931h = y();
            this.f21932i = r();
            this.f21925b = s();
            this.f21933j = w();
            this.l = m();
        }
    }

    public d(Context context) {
        this.f21923b = context;
    }

    public static String b() {
        return UUID.randomUUID().toString();
    }

    private b e() {
        if (this.f21924c == null) {
            this.f21924c = new b();
        }
        return this.f21924c;
    }

    public String c() {
        return e().a;
    }

    public String d() {
        return e().f21929f;
    }

    public String f() {
        return e().f21932i;
    }

    public String g() {
        return e().f21925b;
    }

    protected Geocoder h() {
        return new Geocoder(this.f21923b, Locale.ENGLISH);
    }

    public String i() {
        return e().f21933j;
    }

    public String j() {
        return e().f21930g;
    }

    public String k() {
        return e().f21931h;
    }

    public Location l() {
        LocationManager locationManager;
        List<String> providers;
        Location lastKnownLocation;
        Location location = null;
        if (!r() || (locationManager = (LocationManager) this.f21923b.getSystemService("location")) == null) {
            return null;
        }
        try {
            providers = locationManager.getProviders(true);
        } catch (SecurityException e2) {
            e.e().g("Failed to get most recent location", e2);
            providers = null;
        }
        if (providers == null) {
            return null;
        }
        ArrayList<Location> arrayList = new ArrayList();
        Iterator<String> it = providers.iterator();
        while (it.hasNext()) {
            try {
                lastKnownLocation = locationManager.getLastKnownLocation(it.next());
            } catch (IllegalArgumentException e3) {
                e.e().g("Failed to get most recent location", e3);
                lastKnownLocation = null;
            } catch (SecurityException e4) {
                e.e().g("Failed to get most recent location", e4);
                lastKnownLocation = null;
            }
            if (lastKnownLocation != null) {
                arrayList.add(lastKnownLocation);
            }
        }
        long time = -1;
        for (Location location2 : arrayList) {
            if (location2.getTime() > time) {
                time = location2.getTime();
                location = location2;
            }
        }
        return location;
    }

    public String m() {
        return e().f21927d;
    }

    public String n() {
        return e().f21928e;
    }

    public String o() {
        return e().f21926c;
    }

    public boolean p() {
        return e().l;
    }

    public boolean q() {
        return e().f21934k;
    }

    public boolean r() {
        return this.a;
    }

    public void s() {
        e();
    }
}
