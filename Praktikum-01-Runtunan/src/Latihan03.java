import java.util.Scanner;
public class Latihan03 {
    static double phi = 3.14;
    static double r, t, s;  // s = Panjang Garis Pelukis
    static double luasPKerucut, volumeKerucut, luasPTabung, volumeTabung;
    
    public static void main(String[] args) {
        r = 5;
        t = 12;
        s = Math.sqrt(r * r + t * t);
 
        System.out.println("Hitung Luas Permukaan dan Volume Kerucut dan Tabung \n");
 
        volumeKerucut = 1 * phi * r * r * t / 3;
        System.out.println("Volume Kerucutnya  : " + volumeKerucut);
        
        luasPKerucut = phi * r * (r + s);
        System.out.println("Luas Permukaannya : " + luasPKerucut);
 

        volumeTabung = (phi * r * r) * t;
        System.out.println("\nVolume Tabung  : " + volumeTabung);
        
        luasPTabung = 2 * (phi * r * r) + (2 * phi * r * t);
        System.out.println("Luas Permukaannya : " + luasPTabung);
        
        
        
        
        
    }
}