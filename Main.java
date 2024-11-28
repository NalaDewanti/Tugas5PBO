import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean loginBerhasil = false;
            String namaKasir = ""; // Variabel untuk menyimpan nama kasir
            
            // Proses login
            while (!loginBerhasil) {
                try {
                    System.out.println("+----------------------------------------+");
                    System.out.println("Log in");
                    System.out.println("+----------------------------------------+");
                    System.out.print("Username : ");
                    String username = scanner.nextLine().trim(); // Method String: trim()
                    System.out.print("Password : ");
                    String password = scanner.nextLine();
                    
                    // Membuat captcha sederhana
                    String captcha = generateCaptcha();
                    System.out.println("Captcha : " + captcha);
                    System.out.print("Masukkan Captcha : ");
                    String inputCaptcha = scanner.nextLine();
                    
                    // Validasi login
                    if (username.isEmpty() || password.isEmpty() || inputCaptcha.isEmpty()) {
                        throw new IllegalArgumentException("\nInput tidak boleh kosong! Silakan coba lagi.");
                    }
                    
                    if (username.equalsIgnoreCase("aldi") && password.equals("1234") && inputCaptcha.equals(captcha)) {
                        System.out.println("\nLogin berhasil!\n");
                        namaKasir = username; // Menyimpan username sebagai nama kasir
                        loginBerhasil = true;
                    } else {
                        throw new IllegalArgumentException("\nLogin gagal, silakan coba lagi.");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (Exception e) {
                    System.out.println("\nTerjadi kesalahan tak terduga. Silakan coba lagi.");
                    scanner.nextLine(); // Membersihkan buffer
                }
            }
            
            // Setelah login berhasil, lanjut ke transaksi
            boolean transaksiLanjut = true;
            while (transaksiLanjut) {
                try {
                    System.out.println("\n+----------------------------------------+");
                    System.out.println("Selamat Datang di Domaret");
                    Date tanggal = new Date(); // Mengambil waktu saat ini
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    System.out.println("Tanggal dan Waktu : " + formatter.format(tanggal));
                    System.out.println("+----------------------------------------+");
                    
                    // Input Transaksi
                    System.out.print("No. Faktur : ");
                    int noFaktur = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer
                    System.out.print("Kode Barang : ");
                    String kodeBarang = scanner.nextLine();
                    System.out.print("Nama Barang : ");
                    String namaBarang = scanner.nextLine();
                    System.out.print("Harga Barang : ");
                    double hargaBarang = scanner.nextDouble();
                    if (hargaBarang < 1) {
                        throw new IllegalArgumentException("\nHarga barang tidak boleh kurang dari 1!");
                    }
                    System.out.print("Jumlah Beli : ");
                    int jumlahBeli = scanner.nextInt();
                    if (jumlahBeli < 1) {
                        throw new IllegalArgumentException("\nJumlah beli tidak boleh kurang dari 1!");
                    }
                    
                    // Menghitung total
                    double total = hargaBarang * jumlahBeli;
                    
                    // Menampilkan hasil transaksi
                    System.out.println("+----------------------------------------+");
                    System.out.println("No. Faktur   : " + noFaktur);
                    System.out.println("Kode Barang  : " + kodeBarang);
                    System.out.println("Nama Barang  : " + namaBarang);
                    System.out.println("Harga Barang : " + hargaBarang);
                    System.out.println("Jumlah Beli  : " + jumlahBeli);
                    System.out.println("TOTAL        : " + total);
                    System.out.println("+----------------------------------------+");
                    System.out.println("Kasir        : " + namaKasir);
                    System.out.println("+----------------------------------------+");
                    
                    // Tanya apakah ingin melakukan transaksi lain
                    System.out.print("Apakah Anda ingin melakukan transaksi lain? (ya/tidak): ");
                    scanner.nextLine(); // Membersihkan buffer
                    String pilihan = scanner.nextLine().trim().toLowerCase();
                    if (pilihan.equals("tidak")) {
                        transaksiLanjut = false;
                        System.out.println("Terima kasih telah berbelanja!");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage() + "\n");
                } catch (Exception e) {
                    System.out.println("\nTerjadi kesalahan input. Silakan coba lagi.\n");
                    scanner.nextLine(); // Membersihkan buffer
                }
            }
        }
    }

    // Method untuk membuat captcha
    public static String generateCaptcha() {
        String karakter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder captcha = new StringBuilder(); // StringBuilder untuk efisiensi manipulasi string
        for (int i = 0; i < 6; i++) {
            int index = (int) (Math.random() * karakter.length());
            captcha.append(karakter.charAt(index)); // Method String: charAt
        }
        return captcha.toString();
    }
}
