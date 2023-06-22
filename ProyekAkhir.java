import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ProyekAkhir {
    private Queue<String> antrian;
    private Scanner scanner;

    public ProyekAkhir() {
        antrian = new LinkedList<>();
        scanner = new Scanner(System.in);
    }

    public void tambahPelanggan(String pelanggan) {
        antrian.add(pelanggan);
        System.out.println("Pelanggan " + pelanggan + " ditambahkan ke dalam antrian.");
    }

    public void panggilPelanggan() {
        if (kosong()) {
            System.out.println("Antrian kosong.");
        } else {
            String pelanggan = antrian.poll();
            System.out.println("Pelanggan " + pelanggan + " dipanggil.");
        }
    }

    public boolean kosong() {
        return antrian.isEmpty();
    }

    public void tampilkanAntrian() {
        if (kosong()) {
            System.out.println("Antrian kosong.");
        } else {
            System.out.println("Antrian saat ini:");
            System.out.println("-----------------");
            System.out.println("|  Nomor  |  Nama  |");
            System.out.println("-----------------");
            int indeks = 1;
            for (String pelanggan : antrian) {
            System.out.printf("|   %d    |   %s   |\n", indeks, pelanggan);
                System.out.println("-----------------");
                indeks++;
            }
        }
    }

    public void cekPelanggan(String pelanggan) {
        if (antrian.contains(pelanggan)) {
            System.out.println("Pelanggan " + pelanggan + " ada dalam antrian.");
        } else {
            System.out.println("Pelanggan " + pelanggan + " tidak ada dalam antrian.");
        }
    }

    public void menu() {
        int pilihan;
        do {
            System.out.println("\n=== Menu Antrian Bank ===");
            System.out.println("1. Tambahkan Pelanggan ke antrian");
            System.out.println("2. Panggil Pelanggan dari antrian");
            System.out.println("3. Cek Pelanggan dalam antrian");
            System.out.println("4. Tampilkan antrian");
            System.out.println("5. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    scanner.nextLine(); // Hapus karakter newline
                    System.out.print("Masukkan nama pelanggan: ");
                    String namaPelanggan = scanner.nextLine();
                    tambahPelanggan(namaPelanggan);
                    break;
                case 2:
                    panggilPelanggan();
                    break;
                case 3:
                    scanner.nextLine(); // Hapus karakter newline
                    System.out.print("Masukkan nama pelanggan: ");
                    String pelangganCek = scanner.nextLine();
                    cekPelanggan(pelangganCek);
                    break;
                case 4:
                    tampilkanAntrian();
                    break;
                case 5:
                    System.out.println("Keluar...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        } while (pilihan != 5);
    }

    public static void main(String[] args) {
        ProyekAkhir proyekAkhir = new ProyekAkhir();
        proyekAkhir.menu();
    }
}