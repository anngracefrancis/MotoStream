package i.a.g;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;

/* JADX INFO: compiled from: NetworkTopologyDiscoveryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class o implements i.a.b {
    private static final k.b.b a = k.b.c.i(o.class.getName());

    @Override // i.a.b
    public InetAddress[] a() {
        HashSet hashSet = new HashSet();
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    k.b.b bVar = a;
                    if (bVar.d()) {
                        bVar.i("Found NetworkInterface/InetAddress: " + networkInterfaceNextElement + " -- " + inetAddressNextElement);
                    }
                    if (b(networkInterfaceNextElement, inetAddressNextElement)) {
                        hashSet.add(inetAddressNextElement);
                    }
                }
            }
        } catch (SocketException e2) {
            a.h("Error while fetching network interfaces addresses: " + e2);
        }
        return (InetAddress[]) hashSet.toArray(new InetAddress[hashSet.size()]);
    }

    public boolean b(NetworkInterface networkInterface, InetAddress inetAddress) {
        try {
            return networkInterface.isUp() && networkInterface.supportsMulticast() && !networkInterface.isLoopback();
        } catch (Exception unused) {
            return false;
        }
    }
}
